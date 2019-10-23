package com.test.entity;

import java.util.Date;

import lombok.Data;
@Data
public class Question {
	private User user;
	private Integer questionId;//問題id
    private String questionTitle;//问题标题
    private Date createTime;//创建问题时间
	private Integer browse;//浏览数目
    private Integer reply;//回复数量
    private Integer userId;//回复人
    private String describes;//标签
    private String label;//问题内容
}