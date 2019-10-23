package com.test.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Comment;
import com.test.entity.CommentExample;
import com.test.entity.User;
import com.test.mapper.CommentMapper;
import com.test.mapper.UserMapper;
import com.test.service.QuestionService;
@Service
@Transactional
public class QuestionServiceImpl implements QuestionService{
	@Autowired
  private UserMapper usermapper;
	@Autowired
  private CommentMapper commentMapper;
	@Override
	public List<Comment> getComment(Integer questionId,Integer ida) {
		
		 
		CommentExample example=new CommentExample();
		//查出一级评论
		example.createCriteria().andParentIdEqualTo(questionId).andTypeEqualTo(ida);
		List<Comment> selectByExample = commentMapper.selectByExample(example);
		
		for (Comment comment : selectByExample) {
			Integer id = comment.getCommentator();
			User selectByPrimaryKey = usermapper.selectByPrimaryKey(id);			
			comment.setUser(selectByPrimaryKey);		
			
		}
		
		return selectByExample;
	}

}
