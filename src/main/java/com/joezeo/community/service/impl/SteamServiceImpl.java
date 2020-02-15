package com.joezeo.community.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.joezeo.community.dao.RedisDao;
import com.joezeo.community.dto.HistoryPriceDTO;
import com.joezeo.community.dto.PaginationDTO;
import com.joezeo.community.dto.SteamAppDTO;
import com.joezeo.community.enums.SteamAppTypeEnum;
import com.joezeo.community.exception.CustomizeErrorCode;
import com.joezeo.community.exception.CustomizeException;
import com.joezeo.community.mapper.SteamAppInfoMapper;
import com.joezeo.community.mapper.SteamHistoryPriceMapper;
import com.joezeo.community.mapper.SteamSubInfoMapper;
import com.joezeo.community.pojo.SteamAppInfo;
import com.joezeo.community.pojo.SteamHistoryPrice;
import com.joezeo.community.pojo.SteamSubInfo;
import com.joezeo.community.service.SteamService;
import com.joezeo.community.utils.TimeUtils;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
public class SteamServiceImpl implements SteamService {
    @Autowired
    private SteamAppInfoMapper steamAppInfoMapper;
    @Autowired
    private SteamHistoryPriceMapper steamHistoryPriceMapper;
    @Autowired
    private SteamSubInfoMapper steamSubInfoMapper;
    @Autowired
    private RedisDao redisDao;

    @Override
    public PaginationDTO<?>
    listApps(Integer page, Integer size, Integer typeIndex) {
        // 获取所要获取的软件列表的类型(String)
        String type = SteamAppTypeEnum.typeOf(typeIndex);

        // 如果类型为sub 礼包，则单独处理逻辑
        if ("sub".equals(type)) {
            return listSubs(page, size);
        }

        // 获取该类型软件的总数
        int totalCount = steamAppInfoMapper.selectCount(type);

        // 设置分页对象
        PaginationDTO<SteamAppInfo> paginationDTO = new PaginationDTO<>();
        paginationDTO.setPagination(page, size, totalCount);
        // 避免page传入异常值
        page = paginationDTO.getPage();
        int index = (page - 1) * size;

        // 获取该页的数据list
        List<SteamAppInfo> list = steamAppInfoMapper.selectPage(index, size, type);
        if (list == null || list.size() == 0) {
            paginationDTO.setDatas(new ArrayList<>());
            return paginationDTO;
        }

        try {
            // 获取当天零点的时间戳
            Long preTimeAtZero = TimeUtils.getTimestampAtZero();

            // 获取当天新获取的特惠商品价格 gmt_create>preTimeAtZero
            List<SteamHistoryPrice> specials = steamHistoryPriceMapper.selectByTime(preTimeAtZero);
            if (specials != null && specials.size() != 0) {
                // 将特惠商品以appid为key，价格为value放入map中
                Map<Integer, Integer> specialMap = specials.stream().distinct()
                        .collect(Collectors.toMap(special -> special.getAppid(), special -> special.getPrice()));

                // 重新设定list中特惠商品的finalPrice
                for (SteamAppInfo appInfo : list) {
                    Integer price = specialMap.get(appInfo.getAppid());
                    if (price != null) {
                        appInfo.setFinalPrice(price);
                    }
                }
            }
        } catch (Exception e) {
            log.error("获取特惠价格失败，所有商品价格将以历史记录展示: stackTrace=" + e.getMessage());
        }

        // 将获取到的所有商品放入Redis中，凌晨4点对缓存中的商品信息进行删除
        // key: app-类型-appid
        list.stream().forEach(app -> {
            String key = "app-" + type + "-" + app.getAppid();
            if (!redisDao.hasKey(key)) { // redis缓存中不存在该app信息
                int difftime = 60 * 60; // 如果获取时间差失败则默认保存1小时
                try {
                    // 获取现在时间与下一天凌晨4点的时间差，单位秒
                    difftime = TimeUtils.getDifftimeFromNextZero();
                } catch (ParseException e) {
                    log.error("获取时间差失败,将默认保存1小时,stackTrace=" + e.getMessage());
                }
                // 每天凌晨4点清除缓存信息
                // 由于缓存中的信息并不需要修改，所以使用String的方式存储
                redisDao.set(key, app, difftime);
            }
        });

        paginationDTO.setDatas(list);
        return paginationDTO;
    }

    /*
        获取礼包信息
     */
    @NotNull
    private PaginationDTO<SteamSubInfo> listSubs(Integer page, Integer size) {
        // 获取该类型软件的总数
        int totalCount = steamSubInfoMapper.selectCount();

        // 设置分页对象
        PaginationDTO<SteamSubInfo> paginationDTO = new PaginationDTO<>();
        paginationDTO.setPagination(page, size, totalCount);
        // 避免page传入异常值
        page = paginationDTO.getPage();
        int index = (page - 1) * size;

        // 获取该页的数据list
        List<SteamSubInfo> list = steamSubInfoMapper.selectPage(index, size);
        if (list == null || list.size() == 0) {
            paginationDTO.setDatas(new ArrayList<>());
            return paginationDTO;
        }

        // 将获取到的所有商品放入Redis中，凌晨4点对缓存中的商品信息进行删除
        // key: app-类型-appid
        list.stream().forEach(app -> {
            String key = "app-sub-" + app.getAppid();
            if (!redisDao.hasKey(key)) { // redis缓存中不存在该app信息
                int difftime = 60 * 60; // 如果获取时间差失败则默认保存1小时
                try {
                    // 获取现在时间与下一天凌晨4点的时间差，单位秒
                    difftime = TimeUtils.getDifftimeFromNextZero();
                } catch (ParseException e) {
                    log.error("获取时间差失败,将默认保存1小时,stackTrace=" + e.getMessage());
                }
                // 每天凌晨4点清除缓存信息
                // 由于缓存中的信息并不需要修改，所以使用String的方式存储
                redisDao.set(key, app, difftime);
            }
        });

        paginationDTO.setDatas(list);
        return paginationDTO;
    }

    @Override
    public SteamAppDTO queryApp(Integer appid, Integer type) {
        String typeStr = SteamAppTypeEnum.typeOf(type);
        SteamAppDTO appDTO = new SteamAppDTO();
        appDTO.setType(type);

        /*
            首先从redis缓存中查询是否存在该app的信息
            key: app-类型-appid
         */
        String key = "app-" + typeStr + "-" + appid;
        if (redisDao.hasKey(key)) {
            JSONObject object = (JSONObject) redisDao.get(key);
            SteamAppInfo appInfo = JSONObject.parseObject(object.toJSONString(), SteamAppInfo.class);
            BeanUtils.copyProperties(appInfo, appDTO);
        } else { // 如redis中不存在该app的信息，从数据库中查询，再放入到redis缓存中
            SteamAppInfo app = steamAppInfoMapper.selectByAppid(appid, typeStr);
            int difftime = 60 * 60; // 如果获取时间差失败则默认保存1小时
            try {
                // 获取现在时间与下一天凌晨4点的时间差，单位秒
                difftime = TimeUtils.getDifftimeFromNextZero();
            } catch (ParseException e) {
                log.error("获取时间差失败,将默认保存1小时,stackTrace=" + e.getMessage());
            }
            // 每天凌晨4点清除缓存信息
            // 由于缓存中的信息并不需要修改，所以使用String的方式存储
            redisDao.set(key, app, difftime);
        }
        return appDTO;
    }

    @Override
    public HistoryPriceDTO queryHistoryPrice(Integer appid, Integer type) {
        HistoryPriceDTO historyPriceDTO = new HistoryPriceDTO();
        // 首先获取该appid对应的app信息
        SteamAppInfo appInfo = null;

        // 首先redis缓存中获取
        String typeStr = SteamAppTypeEnum.typeOf(type);
        String key = "app-" + typeStr + "-" + appid;
        if (redisDao.hasKey(key)) {
            JSONObject object = (JSONObject) redisDao.get(key);
            appInfo = JSONObject.parseObject(object.toJSONString(), SteamAppInfo.class);
        } else { // 如redis中不存在该app的信息，从数据库中查询，再放入到redis缓存中
            SteamAppInfo app = steamAppInfoMapper.selectByAppid(appid, typeStr);
            int difftime = 60 * 60; // 如果获取时间差失败则默认保存1小时
            try {
                // 获取现在时间与下一天凌晨4点的时间差，单位秒
                difftime = TimeUtils.getDifftimeFromNextZero();
            } catch (ParseException e) {
                log.error("获取时间差失败,将默认保存1小时,stackTrace=" + e.getMessage());
            }
            // 每天凌晨4点清除缓存信息
            // 由于缓存中的信息并不需要修改，所以使用String的方式存储
            redisDao.set(key, app, difftime);
        }

        // 获取该app的原价格
        Integer basePrice = appInfo.getOriginalPrice();

        List<SteamHistoryPrice> historyPriceList = new ArrayList<>();
        // 首先从redis缓存中获取该app的历史价格
        key = "price-" + typeStr + "-" + appid;
        if (redisDao.hasKey(key)) {
            JSONArray jsonArray = (JSONArray) redisDao.get(key);
            for (int i = 0; i < jsonArray.size(); i++) {
                historyPriceList.add(JSONObject.parseObject(jsonArray.getJSONObject(i).toJSONString(), SteamHistoryPrice.class));
            }
        } else {// redis缓存中不存在数据，从数据库中获取数据
            historyPriceList = steamHistoryPriceMapper.selectByAppid(appid);
            if (historyPriceList.size() != 0) {
                // 将获取的数据放入redis缓存中
                int difftime = 60 * 60; // 如果获取时间差失败则默认保存1小时
                try {
                    // 获取现在时间与下一天凌晨4点的时间差，单位秒
                    difftime = TimeUtils.getDifftimeFromNextZero();
                } catch (ParseException e) {
                    log.error("获取时间差失败,将默认保存1小时,stackTrace=" + e.getMessage());
                }
                // 每天凌晨4点清除缓存信息
                // 由于缓存中的信息并不需要修改，所以使用String的方式存储
                redisDao.set(key, historyPriceList, difftime);
            }
        }

        // 将app的历史价格转换成时间为key(格式:20200215)，价格为value的map
        Map<Integer, Integer> priceMap = historyPriceList.stream().collect(
                Collectors.toMap(item -> TimeUtils.timeToInt(item.getGmtCreate()), item -> item.getPrice()));

        // 设置起始时间和当前的时间(格式:20200215)
        Integer farTime = 20200215; // 默认起始时间2020-2-15
        Integer preTime = TimeUtils.timeToInt(System.currentTimeMillis());

        List<String> times = new ArrayList<>();
        List<Integer> prices = new ArrayList<>();
        for (int i = farTime; i <= preTime; i++) {
            Integer price = priceMap.get(i);
            if (price == null) { // 该时间节点app没有降价，以原价展示
                price = basePrice;
            }
            try {
                times.add(TimeUtils.tansferInt(i)); // 把时间从20200215转换成2020-02-15
                prices.add(price);
            } catch (ParseException e) {
                e.printStackTrace();
                log.error("转换时间格式失败");
                throw new CustomizeException(CustomizeErrorCode.INIT_PRICE_CHART_FAILED);
            }
        }

        historyPriceDTO.setTime(times);
        historyPriceDTO.setPrice(prices);
        return historyPriceDTO;
    }
}
