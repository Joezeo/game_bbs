package com.joezeo.joefgame.dao.pojo;

import java.util.ArrayList;
import java.util.List;

public class NotificationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public NotificationExample() {
        oredCriteria = new ArrayList<>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNull() {
            addCriterion("notifier is null");
            return (Criteria) this;
        }

        public Criteria andNotifierIsNotNull() {
            addCriterion("notifier is not null");
            return (Criteria) this;
        }

        public Criteria andNotifierEqualTo(Long value) {
            addCriterion("notifier =", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotEqualTo(Long value) {
            addCriterion("notifier <>", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThan(Long value) {
            addCriterion("notifier >", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierGreaterThanOrEqualTo(Long value) {
            addCriterion("notifier >=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThan(Long value) {
            addCriterion("notifier <", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierLessThanOrEqualTo(Long value) {
            addCriterion("notifier <=", value, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierIn(List<Long> values) {
            addCriterion("notifier in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotIn(List<Long> values) {
            addCriterion("notifier not in", values, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierBetween(Long value1, Long value2) {
            addCriterion("notifier between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andNotifierNotBetween(Long value1, Long value2) {
            addCriterion("notifier not between", value1, value2, "notifier");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNull() {
            addCriterion("receiver is null");
            return (Criteria) this;
        }

        public Criteria andReceiverIsNotNull() {
            addCriterion("receiver is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverEqualTo(Long value) {
            addCriterion("receiver =", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotEqualTo(Long value) {
            addCriterion("receiver <>", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThan(Long value) {
            addCriterion("receiver >", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverGreaterThanOrEqualTo(Long value) {
            addCriterion("receiver >=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThan(Long value) {
            addCriterion("receiver <", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverLessThanOrEqualTo(Long value) {
            addCriterion("receiver <=", value, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverIn(List<Long> values) {
            addCriterion("receiver in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotIn(List<Long> values) {
            addCriterion("receiver not in", values, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverBetween(Long value1, Long value2) {
            addCriterion("receiver between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andReceiverNotBetween(Long value1, Long value2) {
            addCriterion("receiver not between", value1, value2, "receiver");
            return (Criteria) this;
        }

        public Criteria andRelatedidIsNull() {
            addCriterion("relatedid is null");
            return (Criteria) this;
        }

        public Criteria andRelatedidIsNotNull() {
            addCriterion("relatedid is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedidEqualTo(Long value) {
            addCriterion("relatedid =", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidNotEqualTo(Long value) {
            addCriterion("relatedid <>", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidGreaterThan(Long value) {
            addCriterion("relatedid >", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidGreaterThanOrEqualTo(Long value) {
            addCriterion("relatedid >=", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidLessThan(Long value) {
            addCriterion("relatedid <", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidLessThanOrEqualTo(Long value) {
            addCriterion("relatedid <=", value, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidIn(List<Long> values) {
            addCriterion("relatedid in", values, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidNotIn(List<Long> values) {
            addCriterion("relatedid not in", values, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidBetween(Long value1, Long value2) {
            addCriterion("relatedid between", value1, value2, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedidNotBetween(Long value1, Long value2) {
            addCriterion("relatedid not between", value1, value2, "relatedid");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeIsNull() {
            addCriterion("relatedtype is null");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeIsNotNull() {
            addCriterion("relatedtype is not null");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeEqualTo(Integer value) {
            addCriterion("relatedtype =", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeNotEqualTo(Integer value) {
            addCriterion("relatedtype <>", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeGreaterThan(Integer value) {
            addCriterion("relatedtype >", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("relatedtype >=", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeLessThan(Integer value) {
            addCriterion("relatedtype <", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeLessThanOrEqualTo(Integer value) {
            addCriterion("relatedtype <=", value, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeIn(List<Integer> values) {
            addCriterion("relatedtype in", values, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeNotIn(List<Integer> values) {
            addCriterion("relatedtype not in", values, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeBetween(Integer value1, Integer value2) {
            addCriterion("relatedtype between", value1, value2, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andRelatedtypeNotBetween(Integer value1, Integer value2) {
            addCriterion("relatedtype not between", value1, value2, "relatedtype");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Long value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Long value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Long value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Long value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Long value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Long> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Long> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Long value1, Long value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Long value1, Long value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Long value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Long value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Long value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Long value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Long value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Long value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Long> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Long> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Long value1, Long value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Long value1, Long value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andRelatednameIsNull() {
            addCriterion("relatedName is null");
            return (Criteria) this;
        }

        public Criteria andRelatednameIsNotNull() {
            addCriterion("relatedName is not null");
            return (Criteria) this;
        }

        public Criteria andRelatednameEqualTo(String value) {
            addCriterion("relatedName =", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameNotEqualTo(String value) {
            addCriterion("relatedName <>", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameGreaterThan(String value) {
            addCriterion("relatedName >", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameGreaterThanOrEqualTo(String value) {
            addCriterion("relatedName >=", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameLessThan(String value) {
            addCriterion("relatedName <", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameLessThanOrEqualTo(String value) {
            addCriterion("relatedName <=", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameLike(String value) {
            addCriterion("relatedName like", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameNotLike(String value) {
            addCriterion("relatedName not like", value, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameIn(List<String> values) {
            addCriterion("relatedName in", values, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameNotIn(List<String> values) {
            addCriterion("relatedName not in", values, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameBetween(String value1, String value2) {
            addCriterion("relatedName between", value1, value2, "relatedname");
            return (Criteria) this;
        }

        public Criteria andRelatednameNotBetween(String value1, String value2) {
            addCriterion("relatedName not between", value1, value2, "relatedname");
            return (Criteria) this;
        }

        public Criteria andNotifiernameIsNull() {
            addCriterion("notifierName is null");
            return (Criteria) this;
        }

        public Criteria andNotifiernameIsNotNull() {
            addCriterion("notifierName is not null");
            return (Criteria) this;
        }

        public Criteria andNotifiernameEqualTo(String value) {
            addCriterion("notifierName =", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameNotEqualTo(String value) {
            addCriterion("notifierName <>", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameGreaterThan(String value) {
            addCriterion("notifierName >", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameGreaterThanOrEqualTo(String value) {
            addCriterion("notifierName >=", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameLessThan(String value) {
            addCriterion("notifierName <", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameLessThanOrEqualTo(String value) {
            addCriterion("notifierName <=", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameLike(String value) {
            addCriterion("notifierName like", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameNotLike(String value) {
            addCriterion("notifierName not like", value, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameIn(List<String> values) {
            addCriterion("notifierName in", values, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameNotIn(List<String> values) {
            addCriterion("notifierName not in", values, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameBetween(String value1, String value2) {
            addCriterion("notifierName between", value1, value2, "notifiername");
            return (Criteria) this;
        }

        public Criteria andNotifiernameNotBetween(String value1, String value2) {
            addCriterion("notifierName not between", value1, value2, "notifiername");
            return (Criteria) this;
        }

        public Criteria andTopicidIsNull() {
            addCriterion("topicid is null");
            return (Criteria) this;
        }

        public Criteria andTopicidIsNotNull() {
            addCriterion("topicid is not null");
            return (Criteria) this;
        }

        public Criteria andTopicidEqualTo(Long value) {
            addCriterion("topicid =", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidNotEqualTo(Long value) {
            addCriterion("topicid <>", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidGreaterThan(Long value) {
            addCriterion("topicid >", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidGreaterThanOrEqualTo(Long value) {
            addCriterion("topicid >=", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidLessThan(Long value) {
            addCriterion("topicid <", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidLessThanOrEqualTo(Long value) {
            addCriterion("topicid <=", value, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidIn(List<Long> values) {
            addCriterion("topicid in", values, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidNotIn(List<Long> values) {
            addCriterion("topicid not in", values, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidBetween(Long value1, Long value2) {
            addCriterion("topicid between", value1, value2, "topicid");
            return (Criteria) this;
        }

        public Criteria andTopicidNotBetween(Long value1, Long value2) {
            addCriterion("topicid not between", value1, value2, "topicid");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_notification
     *
     * @mbg.generated do_not_delete_during_merge Fri Mar 20 22:14:24 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table t_notification
     *
     * @mbg.generated Fri Mar 20 22:14:24 CST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}