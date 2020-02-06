package com.joezeo.community.spider;

import com.joezeo.community.enums.SpiderJobTypeEnum;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class PageGetter {
    @Autowired
    private OkHttpClient okHttpClient;

    @Autowired
    private PageResolver pageResolver;

    @Autowired
    private SpiderComponent spiderComponent;

    public void spiderUrlAsyn(String url, String type,Integer appid, SpiderJobTypeEnum jobType) {
        Request request = new Request.Builder()
                .url(url)
                .addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36")
                .addHeader("cookie", "birthtime=470678401") // 认证年龄
                .addHeader("Accept-Language", "zh-CN,zh;q=0.9") // 设置语言
                .get()
                .build();

        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                log.error("爬取网页失败 - 可能等待时间过长 - 将再次重试：" + url);
                spiderComponent.add2Fail(url, type);
            }

            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String page = response.body().string();
                System.out.println("获取页面成功 ： " + url);

                // 如果执行成功，删除spiderComponent中相应的失败url
                spiderComponent.removeFail(url, type);

                if (jobType == SpiderJobTypeEnum.INIT_URL_DATA) {
                    pageResolver.initUrl(page, type);
                } else if (jobType == SpiderJobTypeEnum.DAILY_CHECK_URL) {
                    pageResolver.dailyUrlCheck(page, type);
                } else if (jobType == SpiderJobTypeEnum.INIT_APP_INFO) {
                    pageResolver.initAppInfo(page, type, appid);
                } else if (jobType == SpiderJobTypeEnum.DAILY_CHECK_APP_INFO){
                    pageResolver.dailyCheckAppInfo(page, type, appid);
                }
            }
        });
    }
}
