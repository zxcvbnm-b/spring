package com.test.entity;

import java.util.Date;

public class Notification {
    private Integer notificationId;

    private Date createTime;

    private Integer noticeState;

    private Integer noticeType;

    private Integer noticeOuter;

    private Integer noticeInner;

    private Integer noticeQuestionId;

    private Integer noticeTest;

    private String noticeTest2;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getNoticeState() {
        return noticeState;
    }

    public void setNoticeState(Integer noticeState) {
        this.noticeState = noticeState;
    }

    public Integer getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(Integer noticeType) {
        this.noticeType = noticeType;
    }

    public Integer getNoticeOuter() {
        return noticeOuter;
    }

    public void setNoticeOuter(Integer noticeOuter) {
        this.noticeOuter = noticeOuter;
    }

    public Integer getNoticeInner() {
        return noticeInner;
    }

    public void setNoticeInner(Integer noticeInner) {
        this.noticeInner = noticeInner;
    }

    public Integer getNoticeQuestionId() {
        return noticeQuestionId;
    }

    public void setNoticeQuestionId(Integer noticeQuestionId) {
        this.noticeQuestionId = noticeQuestionId;
    }

    public Integer getNoticeTest() {
        return noticeTest;
    }

    public void setNoticeTest(Integer noticeTest) {
        this.noticeTest = noticeTest;
    }

    public String getNoticeTest2() {
        return noticeTest2;
    }

    public void setNoticeTest2(String noticeTest2) {
        this.noticeTest2 = noticeTest2 == null ? null : noticeTest2.trim();
    }

	@Override
	public String toString() {
		return "Notification [notificationId=" + notificationId + ", createTime=" + createTime + ", noticeState="
				+ noticeState + ", noticeType=" + noticeType + ", noticeOuter=" + noticeOuter + ", noticeInner="
				+ noticeInner + ", noticeQuestionId=" + noticeQuestionId + ", noticeTest=" + noticeTest
				+ ", noticeTest2=" + noticeTest2 + "]";
	}
	public static void main(String[] args) {
	}
}