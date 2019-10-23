package com.test.service;

import com.test.dto.CommentDTO;
import com.test.dto.ResultDTO;
import com.test.entity.Comment;

public interface CommentService {

	void insert(Comment commet);

	ResultDTO getCommentLsit(CommentDTO commentdto);

}
