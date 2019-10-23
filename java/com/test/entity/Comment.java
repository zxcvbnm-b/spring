package com.test.entity;

import java.util.Date;

import lombok.Data;
@Data
public class Comment {
	private Integer user_commentCount;//回复数量
	private User user;
	private Question question;
    private Integer id;
    private Integer parentId;//如果是回复问题为，这个问题的id，如果是回复用户评论，则这个是这个评论的id
    private Integer type;//回复类型，是回复问题，还是回复评论
    private Date commentTime;
    private String content;//内容
    private Integer commentator;//评论人
    private Date updateTime;
    private Integer likeCount;
}