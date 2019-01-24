package com.model.CBS;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CbsSuccessfulPurchaseQueryReportExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CbsSuccessfulPurchaseQueryReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
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

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCbsVinIsNull() {
            addCriterion("cbs_vin is null");
            return (Criteria) this;
        }

        public Criteria andCbsVinIsNotNull() {
            addCriterion("cbs_vin is not null");
            return (Criteria) this;
        }

        public Criteria andCbsVinEqualTo(String value) {
            addCriterion("cbs_vin =", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinNotEqualTo(String value) {
            addCriterion("cbs_vin <>", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinGreaterThan(String value) {
            addCriterion("cbs_vin >", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinGreaterThanOrEqualTo(String value) {
            addCriterion("cbs_vin >=", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinLessThan(String value) {
            addCriterion("cbs_vin <", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinLessThanOrEqualTo(String value) {
            addCriterion("cbs_vin <=", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinLike(String value) {
            addCriterion("cbs_vin like", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinNotLike(String value) {
            addCriterion("cbs_vin not like", value, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinIn(List<String> values) {
            addCriterion("cbs_vin in", values, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinNotIn(List<String> values) {
            addCriterion("cbs_vin not in", values, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinBetween(String value1, String value2) {
            addCriterion("cbs_vin between", value1, value2, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsVinNotBetween(String value1, String value2) {
            addCriterion("cbs_vin not between", value1, value2, "cbsVin");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoIsNull() {
            addCriterion("cbs_enginno is null");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoIsNotNull() {
            addCriterion("cbs_enginno is not null");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoEqualTo(String value) {
            addCriterion("cbs_enginno =", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoNotEqualTo(String value) {
            addCriterion("cbs_enginno <>", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoGreaterThan(String value) {
            addCriterion("cbs_enginno >", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoGreaterThanOrEqualTo(String value) {
            addCriterion("cbs_enginno >=", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoLessThan(String value) {
            addCriterion("cbs_enginno <", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoLessThanOrEqualTo(String value) {
            addCriterion("cbs_enginno <=", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoLike(String value) {
            addCriterion("cbs_enginno like", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoNotLike(String value) {
            addCriterion("cbs_enginno not like", value, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoIn(List<String> values) {
            addCriterion("cbs_enginno in", values, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoNotIn(List<String> values) {
            addCriterion("cbs_enginno not in", values, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoBetween(String value1, String value2) {
            addCriterion("cbs_enginno between", value1, value2, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsEnginnoNotBetween(String value1, String value2) {
            addCriterion("cbs_enginno not between", value1, value2, "cbsEnginno");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateIsNull() {
            addCriterion("cbs_licenseplate is null");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateIsNotNull() {
            addCriterion("cbs_licenseplate is not null");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateEqualTo(String value) {
            addCriterion("cbs_licenseplate =", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateNotEqualTo(String value) {
            addCriterion("cbs_licenseplate <>", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateGreaterThan(String value) {
            addCriterion("cbs_licenseplate >", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateGreaterThanOrEqualTo(String value) {
            addCriterion("cbs_licenseplate >=", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateLessThan(String value) {
            addCriterion("cbs_licenseplate <", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateLessThanOrEqualTo(String value) {
            addCriterion("cbs_licenseplate <=", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateLike(String value) {
            addCriterion("cbs_licenseplate like", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateNotLike(String value) {
            addCriterion("cbs_licenseplate not like", value, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateIn(List<String> values) {
            addCriterion("cbs_licenseplate in", values, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateNotIn(List<String> values) {
            addCriterion("cbs_licenseplate not in", values, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateBetween(String value1, String value2) {
            addCriterion("cbs_licenseplate between", value1, value2, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsLicenseplateNotBetween(String value1, String value2) {
            addCriterion("cbs_licenseplate not between", value1, value2, "cbsLicenseplate");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdIsNull() {
            addCriterion("cbs_apiuser_id is null");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdIsNotNull() {
            addCriterion("cbs_apiuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdEqualTo(Integer value) {
            addCriterion("cbs_apiuser_id =", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdNotEqualTo(Integer value) {
            addCriterion("cbs_apiuser_id <>", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdGreaterThan(Integer value) {
            addCriterion("cbs_apiuser_id >", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cbs_apiuser_id >=", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdLessThan(Integer value) {
            addCriterion("cbs_apiuser_id <", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("cbs_apiuser_id <=", value, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdIn(List<Integer> values) {
            addCriterion("cbs_apiuser_id in", values, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdNotIn(List<Integer> values) {
            addCriterion("cbs_apiuser_id not in", values, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdBetween(Integer value1, Integer value2) {
            addCriterion("cbs_apiuser_id between", value1, value2, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsApiuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cbs_apiuser_id not between", value1, value2, "cbsApiuserId");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidIsNull() {
            addCriterion("cbs_orderid is null");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidIsNotNull() {
            addCriterion("cbs_orderid is not null");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidEqualTo(String value) {
            addCriterion("cbs_orderid =", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidNotEqualTo(String value) {
            addCriterion("cbs_orderid <>", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidGreaterThan(String value) {
            addCriterion("cbs_orderid >", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("cbs_orderid >=", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidLessThan(String value) {
            addCriterion("cbs_orderid <", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidLessThanOrEqualTo(String value) {
            addCriterion("cbs_orderid <=", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidLike(String value) {
            addCriterion("cbs_orderid like", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidNotLike(String value) {
            addCriterion("cbs_orderid not like", value, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidIn(List<String> values) {
            addCriterion("cbs_orderid in", values, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidNotIn(List<String> values) {
            addCriterion("cbs_orderid not in", values, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidBetween(String value1, String value2) {
            addCriterion("cbs_orderid between", value1, value2, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsOrderidNotBetween(String value1, String value2) {
            addCriterion("cbs_orderid not between", value1, value2, "cbsOrderid");
            return (Criteria) this;
        }

        public Criteria andCbsMessageIsNull() {
            addCriterion("cbs_message is null");
            return (Criteria) this;
        }

        public Criteria andCbsMessageIsNotNull() {
            addCriterion("cbs_message is not null");
            return (Criteria) this;
        }

        public Criteria andCbsMessageEqualTo(String value) {
            addCriterion("cbs_message =", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageNotEqualTo(String value) {
            addCriterion("cbs_message <>", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageGreaterThan(String value) {
            addCriterion("cbs_message >", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageGreaterThanOrEqualTo(String value) {
            addCriterion("cbs_message >=", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageLessThan(String value) {
            addCriterion("cbs_message <", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageLessThanOrEqualTo(String value) {
            addCriterion("cbs_message <=", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageLike(String value) {
            addCriterion("cbs_message like", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageNotLike(String value) {
            addCriterion("cbs_message not like", value, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageIn(List<String> values) {
            addCriterion("cbs_message in", values, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageNotIn(List<String> values) {
            addCriterion("cbs_message not in", values, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageBetween(String value1, String value2) {
            addCriterion("cbs_message between", value1, value2, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsMessageNotBetween(String value1, String value2) {
            addCriterion("cbs_message not between", value1, value2, "cbsMessage");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeIsNull() {
            addCriterion("cbs_addtime is null");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeIsNotNull() {
            addCriterion("cbs_addtime is not null");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeEqualTo(Date value) {
            addCriterion("cbs_addtime =", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeNotEqualTo(Date value) {
            addCriterion("cbs_addtime <>", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeGreaterThan(Date value) {
            addCriterion("cbs_addtime >", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cbs_addtime >=", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeLessThan(Date value) {
            addCriterion("cbs_addtime <", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeLessThanOrEqualTo(Date value) {
            addCriterion("cbs_addtime <=", value, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeIn(List<Date> values) {
            addCriterion("cbs_addtime in", values, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeNotIn(List<Date> values) {
            addCriterion("cbs_addtime not in", values, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeBetween(Date value1, Date value2) {
            addCriterion("cbs_addtime between", value1, value2, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsAddtimeNotBetween(Date value1, Date value2) {
            addCriterion("cbs_addtime not between", value1, value2, "cbsAddtime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeIsNull() {
            addCriterion("cbs_uptime is null");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeIsNotNull() {
            addCriterion("cbs_uptime is not null");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeEqualTo(Date value) {
            addCriterion("cbs_uptime =", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeNotEqualTo(Date value) {
            addCriterion("cbs_uptime <>", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeGreaterThan(Date value) {
            addCriterion("cbs_uptime >", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cbs_uptime >=", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeLessThan(Date value) {
            addCriterion("cbs_uptime <", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeLessThanOrEqualTo(Date value) {
            addCriterion("cbs_uptime <=", value, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeIn(List<Date> values) {
            addCriterion("cbs_uptime in", values, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeNotIn(List<Date> values) {
            addCriterion("cbs_uptime not in", values, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeBetween(Date value1, Date value2) {
            addCriterion("cbs_uptime between", value1, value2, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsUptimeNotBetween(Date value1, Date value2) {
            addCriterion("cbs_uptime not between", value1, value2, "cbsUptime");
            return (Criteria) this;
        }

        public Criteria andCbsStartIsNull() {
            addCriterion("cbs_start is null");
            return (Criteria) this;
        }

        public Criteria andCbsStartIsNotNull() {
            addCriterion("cbs_start is not null");
            return (Criteria) this;
        }

        public Criteria andCbsStartEqualTo(Integer value) {
            addCriterion("cbs_start =", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartNotEqualTo(Integer value) {
            addCriterion("cbs_start <>", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartGreaterThan(Integer value) {
            addCriterion("cbs_start >", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartGreaterThanOrEqualTo(Integer value) {
            addCriterion("cbs_start >=", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartLessThan(Integer value) {
            addCriterion("cbs_start <", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartLessThanOrEqualTo(Integer value) {
            addCriterion("cbs_start <=", value, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartIn(List<Integer> values) {
            addCriterion("cbs_start in", values, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartNotIn(List<Integer> values) {
            addCriterion("cbs_start not in", values, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartBetween(Integer value1, Integer value2) {
            addCriterion("cbs_start between", value1, value2, "cbsStart");
            return (Criteria) this;
        }

        public Criteria andCbsStartNotBetween(Integer value1, Integer value2) {
            addCriterion("cbs_start not between", value1, value2, "cbsStart");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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