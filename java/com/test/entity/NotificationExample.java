package com.test.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NotificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotificationExample() {
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

        protected void addCriterionForJDBCTime(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value.getTime()), property);
        }

        protected void addCriterionForJDBCTime(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Time> timeList = new ArrayList<java.sql.Time>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                timeList.add(new java.sql.Time(iter.next().getTime()));
            }
            addCriterion(condition, timeList, property);
        }

        protected void addCriterionForJDBCTime(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Time(value1.getTime()), new java.sql.Time(value2.getTime()), property);
        }

        public Criteria andNotificationIdIsNull() {
            addCriterion("notification_id is null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIsNotNull() {
            addCriterion("notification_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotificationIdEqualTo(Integer value) {
            addCriterion("notification_id =", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotEqualTo(Integer value) {
            addCriterion("notification_id <>", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThan(Integer value) {
            addCriterion("notification_id >", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notification_id >=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThan(Integer value) {
            addCriterion("notification_id <", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdLessThanOrEqualTo(Integer value) {
            addCriterion("notification_id <=", value, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdIn(List<Integer> values) {
            addCriterion("notification_id in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotIn(List<Integer> values) {
            addCriterion("notification_id not in", values, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdBetween(Integer value1, Integer value2) {
            addCriterion("notification_id between", value1, value2, "notificationId");
            return (Criteria) this;
        }

        public Criteria andNotificationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notification_id not between", value1, value2, "notificationId");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterionForJDBCTime("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterionForJDBCTime("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterionForJDBCTime("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCTime("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterionForJDBCTime("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterionForJDBCTime("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCTime("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNull() {
            addCriterion("notice_state is null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIsNotNull() {
            addCriterion("notice_state is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeStateEqualTo(Integer value) {
            addCriterion("notice_state =", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotEqualTo(Integer value) {
            addCriterion("notice_state <>", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThan(Integer value) {
            addCriterion("notice_state >", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_state >=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThan(Integer value) {
            addCriterion("notice_state <", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateLessThanOrEqualTo(Integer value) {
            addCriterion("notice_state <=", value, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateIn(List<Integer> values) {
            addCriterion("notice_state in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotIn(List<Integer> values) {
            addCriterion("notice_state not in", values, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateBetween(Integer value1, Integer value2) {
            addCriterion("notice_state between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_state not between", value1, value2, "noticeState");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNull() {
            addCriterion("notice_type is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIsNotNull() {
            addCriterion("notice_type is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeEqualTo(Integer value) {
            addCriterion("notice_type =", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotEqualTo(Integer value) {
            addCriterion("notice_type <>", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThan(Integer value) {
            addCriterion("notice_type >", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_type >=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThan(Integer value) {
            addCriterion("notice_type <", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeLessThanOrEqualTo(Integer value) {
            addCriterion("notice_type <=", value, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeIn(List<Integer> values) {
            addCriterion("notice_type in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotIn(List<Integer> values) {
            addCriterion("notice_type not in", values, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeBetween(Integer value1, Integer value2) {
            addCriterion("notice_type between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_type not between", value1, value2, "noticeType");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterIsNull() {
            addCriterion("notice_outer is null");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterIsNotNull() {
            addCriterion("notice_outer is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterEqualTo(Integer value) {
            addCriterion("notice_outer =", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterNotEqualTo(Integer value) {
            addCriterion("notice_outer <>", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterGreaterThan(Integer value) {
            addCriterion("notice_outer >", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_outer >=", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterLessThan(Integer value) {
            addCriterion("notice_outer <", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterLessThanOrEqualTo(Integer value) {
            addCriterion("notice_outer <=", value, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterIn(List<Integer> values) {
            addCriterion("notice_outer in", values, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterNotIn(List<Integer> values) {
            addCriterion("notice_outer not in", values, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterBetween(Integer value1, Integer value2) {
            addCriterion("notice_outer between", value1, value2, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeOuterNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_outer not between", value1, value2, "noticeOuter");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerIsNull() {
            addCriterion("notice_inner is null");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerIsNotNull() {
            addCriterion("notice_inner is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerEqualTo(Integer value) {
            addCriterion("notice_inner =", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerNotEqualTo(Integer value) {
            addCriterion("notice_inner <>", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerGreaterThan(Integer value) {
            addCriterion("notice_inner >", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_inner >=", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerLessThan(Integer value) {
            addCriterion("notice_inner <", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerLessThanOrEqualTo(Integer value) {
            addCriterion("notice_inner <=", value, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerIn(List<Integer> values) {
            addCriterion("notice_inner in", values, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerNotIn(List<Integer> values) {
            addCriterion("notice_inner not in", values, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerBetween(Integer value1, Integer value2) {
            addCriterion("notice_inner between", value1, value2, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeInnerNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_inner not between", value1, value2, "noticeInner");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdIsNull() {
            addCriterion("notice_question_id is null");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdIsNotNull() {
            addCriterion("notice_question_id is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdEqualTo(Integer value) {
            addCriterion("notice_question_id =", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdNotEqualTo(Integer value) {
            addCriterion("notice_question_id <>", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdGreaterThan(Integer value) {
            addCriterion("notice_question_id >", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_question_id >=", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdLessThan(Integer value) {
            addCriterion("notice_question_id <", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdLessThanOrEqualTo(Integer value) {
            addCriterion("notice_question_id <=", value, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdIn(List<Integer> values) {
            addCriterion("notice_question_id in", values, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdNotIn(List<Integer> values) {
            addCriterion("notice_question_id not in", values, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdBetween(Integer value1, Integer value2) {
            addCriterion("notice_question_id between", value1, value2, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeQuestionIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_question_id not between", value1, value2, "noticeQuestionId");
            return (Criteria) this;
        }

        public Criteria andNoticeTestIsNull() {
            addCriterion("notice_test is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTestIsNotNull() {
            addCriterion("notice_test is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTestEqualTo(Integer value) {
            addCriterion("notice_test =", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestNotEqualTo(Integer value) {
            addCriterion("notice_test <>", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestGreaterThan(Integer value) {
            addCriterion("notice_test >", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestGreaterThanOrEqualTo(Integer value) {
            addCriterion("notice_test >=", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestLessThan(Integer value) {
            addCriterion("notice_test <", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestLessThanOrEqualTo(Integer value) {
            addCriterion("notice_test <=", value, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestIn(List<Integer> values) {
            addCriterion("notice_test in", values, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestNotIn(List<Integer> values) {
            addCriterion("notice_test not in", values, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestBetween(Integer value1, Integer value2) {
            addCriterion("notice_test between", value1, value2, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTestNotBetween(Integer value1, Integer value2) {
            addCriterion("notice_test not between", value1, value2, "noticeTest");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2IsNull() {
            addCriterion("notice_test2 is null");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2IsNotNull() {
            addCriterion("notice_test2 is not null");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2EqualTo(String value) {
            addCriterion("notice_test2 =", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2NotEqualTo(String value) {
            addCriterion("notice_test2 <>", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2GreaterThan(String value) {
            addCriterion("notice_test2 >", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2GreaterThanOrEqualTo(String value) {
            addCriterion("notice_test2 >=", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2LessThan(String value) {
            addCriterion("notice_test2 <", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2LessThanOrEqualTo(String value) {
            addCriterion("notice_test2 <=", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2Like(String value) {
            addCriterion("notice_test2 like", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2NotLike(String value) {
            addCriterion("notice_test2 not like", value, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2In(List<String> values) {
            addCriterion("notice_test2 in", values, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2NotIn(List<String> values) {
            addCriterion("notice_test2 not in", values, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2Between(String value1, String value2) {
            addCriterion("notice_test2 between", value1, value2, "noticeTest2");
            return (Criteria) this;
        }

        public Criteria andNoticeTest2NotBetween(String value1, String value2) {
            addCriterion("notice_test2 not between", value1, value2, "noticeTest2");
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