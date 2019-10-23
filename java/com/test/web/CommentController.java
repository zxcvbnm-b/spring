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
    //��������
	@ResponseBody
	@PostMapping("/comment")
private Object getComment( @RequestBody(required=false) CommentDTO commentdto){
		if(StringUtils.isEmpty(commentdto.getParent_id())){
			throw new MyException("�Բ�������ʵ����ⲻ���ڣ����ܱ���ɾ���ˣ�����");
		}
		if(StringUtils.isEmpty(commentdto.getUsera_id())){
			return new ResultDTO(2006, "�Բ���û�е�¼�������¼������");
		}
		if(StringUtils.isEmpty(commentdto.getContent())){
			return new ResultDTO(2007, "�Բ���,�������ۿ����ݣ�������");
		}
		return 	commetService.getCommentLsit(commentdto);
      }
	//չ����������
	@ResponseBody
	@PostMapping("/comment/{id}")
     private Object getComment2(@PathVariable(name="id") String id){
		if(id==null||"".equals(id)){
			
			throw new MyException("���û������ڣ�����������ϵͳ�������쳣������ˢ�¿���");
		}
		List<Comment> comment = service.getComment(Integer.parseInt(id),2);		
		return new ResultDTO(2005, "�ɹ�",comment);
		}
	
	}
