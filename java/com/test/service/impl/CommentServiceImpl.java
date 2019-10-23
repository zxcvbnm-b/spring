package com.test.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.dto.CommentDTO;
import com.test.dto.ResultDTO;
import com.test.entity.Comment;
import com.test.entity.Question;
import com.test.mapper.CommentMapper;
import com.test.mapper.QuestionMapper;
import com.test.service.CommentService;
import com.test.service.NotificationService;
import com.test.utils.MyException;
@Service
@Transactional
public class CommentServiceImpl implements CommentService{
	@Autowired
	private CommentService commentService;
	@Autowired
	private NotificationService noticeService;
	@Autowired
       private CommentMapper mapper;
	@Autowired
	private QuestionMapper questionmapper;
	@Override
	public void insert(Comment commet) {
		Question record = new Question();
	mapper.insertSelective(commet);
		 record.setQuestionId(commet.getParentId());
		 //������������������Ŀ
		questionmapper.addQuesttionreply(record);
		if(commet.getType()==2){
			Comment parentComment=new Comment();
			parentComment.setId(commet.getParentId());
			System.out.println("idû���ҵ���"+parentComment.getId());
		    mapper.addCommentLike(parentComment);
		
		
		}
		
	}
	@Override
	public ResultDTO getCommentLsit(CommentDTO commentdto) {
		//�ж������Ƿ񻹴���

			Comment commet=new Comment();
			commet.setParentId(commentdto.getParent_id());
			commet.setContent(commentdto.getContent());
			commet.setCommentator(commentdto.getUsera_id());
			commet.setType(commentdto.getCode());
			commet.setCommentTime(new Date(System.currentTimeMillis()));
			commet.setUpdateTime(new Date(System.currentTimeMillis()));
			commet.setLikeCount(0);
			commentService.insert(commet);
			//֪ͨ��¼
			noticeService.inertNotice(commentdto);
			return new ResultDTO(2005, "�ɹ�");
		
	}

}
