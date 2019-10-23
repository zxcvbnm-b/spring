package com.test.entity;

import java.util.Date;

import lombok.Data;
@Data
public class Comment {
	private Integer user_commentCount;//�ظ�����
	private User user;
	private Question question;
    private Integer id;
    private Integer parentId;//����ǻظ�����Ϊ����������id������ǻظ��û����ۣ��������������۵�id
    private Integer type;//�ظ����ͣ��ǻظ����⣬���ǻظ�����
    private Date commentTime;
    private String content;//����
    private Integer commentator;//������
    private Date updateTime;
    private Integer likeCount;
}