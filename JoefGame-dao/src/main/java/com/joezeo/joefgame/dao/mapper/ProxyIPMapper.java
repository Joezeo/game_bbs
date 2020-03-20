package com.joezeo.joefgame.dao.mapper;

import com.joezeo.joefgame.dao.pojo.ProxyIP;
import com.joezeo.joefgame.dao.pojo.ProxyIPExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface ProxyIPMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    long countByExample(ProxyIPExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int deleteByExample(ProxyIPExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int insert(ProxyIP record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int insertSelective(ProxyIP record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    List<ProxyIP> selectByExampleWithRowbounds(ProxyIPExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    List<ProxyIP> selectByExample(ProxyIPExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    ProxyIP selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int updateByExampleSelective(@Param("record") ProxyIP record, @Param("example") ProxyIPExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int updateByExample(@Param("record") ProxyIP record, @Param("example") ProxyIPExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int updateByPrimaryKeySelective(ProxyIP record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_proxy_ip
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    int updateByPrimaryKey(ProxyIP record);
}