package com.test.entity;

import java.util.Date;

import lombok.Data;
@Data
public class Question {
	private User user;
	private Integer questionId;//���}id
    private String questionTitle;//�������
    private Date createTime;//��������ʱ��
	private Integer browse;//�����Ŀ
    private Integer reply;//�ظ�����
    private Integer userId;//�ظ���
    private String describes;//��ǩ
    private String label;//��������
}