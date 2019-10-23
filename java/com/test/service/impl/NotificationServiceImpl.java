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
	record.setNoticeType(commentdto.getCode());//���ͣ����ۣ����ǻظ�
	record.setNoticeState(0);
	record.setNoticeInner(commentdto.getUsera_id());//�����ߵ�id��˭�ظ���˭��ʲô���⣬˭������˭��ʲô����
	if(commentdto.getCode()==1){
		record.setNoticeQuestionId(commentdto.getParent_id());
	}else if(commentdto.getCode()==2){
		//����Ƕ������۾�Ҫ�ҵ�����������������۵�˭�����⣬������Ҫ�ҵ������id��commentdto.getParent_id()�������id��ʲô
		Comment selectByPrimaryKey = commentapper.selectByPrimaryKey(commentdto.getParent_id());
		record.setNoticeQuestionId(selectByPrimaryKey.getParentId());
	}
	
	mapper.insertSelective(record);
	}

}
