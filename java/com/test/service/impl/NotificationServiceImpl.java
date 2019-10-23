package com.test.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.CommentDTO;
import com.test.entity.Comment;
import com.test.entity.Notification;
import com.test.mapper.CommentMapper;
import com.test.mapper.NotificationMapper;
import com.test.service.NotificationService;
@Service
@Transactional
public class NotificationServiceImpl implements NotificationService{

 @Autowired
 private NotificationMapper mapper;
 @Autowired
 private CommentMapper commentapper;
	@Override
	public void inertNotice(CommentDTO commentdto) {
	Notification record = new Notification();
	record.setCreateTime(new Date());
	record.setNoticeType(commentdto.getCode());//类型，评论，还是回复
	record.setNoticeState(0);
	record.setNoticeInner(commentdto.getUsera_id());//评论者的id，谁回复了谁的什么问题，谁评论了谁的什么问题
	if(commentdto.getCode()==1){
		record.setNoticeQuestionId(commentdto.getParent_id());
	}else if(commentdto.getCode()==2){
		//如果是二级评论就要找到这个二级评论是评论的谁的问题，（反正要找到问题的id）commentdto.getParent_id()的问题的id是什么
		Comment selectByPrimaryKey = commentapper.selectByPrimaryKey(commentdto.getParent_id());
		record.setNoticeQuestionId(selectByPrimaryKey.getParentId());
	}
	
	mapper.insertSelective(record);
	}

}
