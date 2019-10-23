package com.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.dto.CommentDTO;
import com.test.dto.ResultDTO;
import com.test.entity.Comment;
import com.test.service.CommentService;
import com.test.service.QuestionService;
import com.test.utils.MyException;

@Controller
public class CommentController {
	@Autowired
	private QuestionService service;
	@Autowired
	private CommentService commetService;
    //评论问题
	@ResponseBody
	@PostMapping("/comment")
private Object getComment( @RequestBody(required=false) CommentDTO commentdto){
		if(StringUtils.isEmpty(commentdto.getParent_id())){
			throw new MyException("对不起，你访问的问题不存在，可能被人删除了！！！");
		}
		if(StringUtils.isEmpty(commentdto.getUsera_id())){
			return new ResultDTO(2006, "对不起还没有登录，点击登录！！！");
		}
		if(StringUtils.isEmpty(commentdto.getContent())){
			return new ResultDTO(2007, "对不起,不能评论空内容，！！！");
		}
		return 	commetService.getCommentLsit(commentdto);
      }
	//展开二级评论
	@ResponseBody
	@PostMapping("/comment/{id}")
     private Object getComment2(@PathVariable(name="id") String id){
		if(id==null||"".equals(id)){
			
			throw new MyException("此用户不存在！！！或者是系统出现了异常，请你刷新看看");
		}
		List<Comment> comment = service.getComment(Integer.parseInt(id),2);		
		return new ResultDTO(2005, "成功",comment);
		}
	
	}
