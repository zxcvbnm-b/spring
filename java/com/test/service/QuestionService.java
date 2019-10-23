package com.test.service;

import java.util.List;

import com.test.entity.Comment;

public interface QuestionService {

	List<Comment> getComment(Integer questionId,Integer ida);

}
