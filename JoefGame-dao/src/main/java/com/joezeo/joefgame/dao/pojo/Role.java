package com.joezeo.joefgame.dao.pojo;

public class Role {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.id
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.name
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.gmt_create
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    private Long gmtCreate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_role.gmt_modify
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    private Long gmtModify;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.id
     *
     * @return the value of t_role.id
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.id
     *
     * @param id the value for t_role.id
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.name
     *
     * @return the value of t_role.name
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.name
     *
     * @param name the value for t_role.name
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.gmt_create
     *
     * @return the value of t_role.gmt_create
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.gmt_create
     *
     * @param gmtCreate the value for t_role.gmt_create
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_role.gmt_modify
     *
     * @return the value of t_role.gmt_modify
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public Long getGmtModify() {
        return gmtModify;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_role.gmt_modify
     *
     * @param gmtModify the value for t_role.gmt_modify
     *
     * @mbg.generated Fri Mar 20 15:27:20 CST 2020
     */
    public void setGmtModify(Long gmtModify) {
        this.gmtModify = gmtModify;
    }
}