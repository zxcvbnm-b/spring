package com.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.test.entity.Category;
import com.test.entity.CategoryExample;
import com.test.entity.Notification;
import com.test.entity.NotificationExample;
import com.test.entity.Question;
import com.test.entity.User;
import com.test.entity.UserExample;
import com.test.mapper.CategoryMapper;
import com.test.mapper.NotificationMapper;
import com.test.mapper.QuestionMapper;
import com.test.mapper.UserMapper;
import com.test.service.UserService;
import com.test.utils.NoticeDTO;
@Service
@Transactional
public class UserServiceImpl implements UserService{
	@Autowired
	private QuestionMapper mapper;
	@Autowired
	private NotificationMapper mpaerr;
	@Autowired
	private CategoryMapper categorymapper;
	@Autowired
   private UserMapper usermapper;
	public List<User> findByUser(String username, String passwd) {
		UserExample example = new UserExample() ;
		example.createCriteria().andUsernameEqualTo(username).andPasswdEqualTo(passwd);
		List<User> selectByExample = usermapper.selectByExample(example);
		return selectByExample;
		
		
	}
	//��ҳ����
	@Cacheable("category")
	@Override
	public List<Category> getCategoryList() {
		CategoryExample example = new CategoryExample();
		List<Category> list = categorymapper.selectByExample(example);
		System.out.println("�����ݿ��ˣ�");
		return list;
	}
	@Override
	public List<NoticeDTO> getNoticeCount(Integer attribute) {
		List<NoticeDTO> list1=new ArrayList<>();
		if(attribute!=null){
			Question selectByPrimaryKey=null;
			User selectByPrimaryKey2=null;
			NoticeDTO dto=null;
			//��������û���֪ͨ��Ϣ
			NotificationExample example5=new NotificationExample();
			example5.createCriteria().andNoticeInnerNotEqualTo(attribute).andNoticeStateEqualTo(0);
			List<Notification> selectByExample = mpaerr.selectByExample(example5);
			//����֪ͨ�ҵ�������Ϣ���û���Ϣ
			for (Notification notification : selectByExample) {
				dto=new NoticeDTO();
				selectByPrimaryKey= mapper.selectByPrimaryKey(notification.getNoticeQuestionId());
				selectByPrimaryKey2= usermapper.selectByPrimaryKey(notification.getNoticeInner());
				
			
			if(attribute==selectByPrimaryKey.getUserId()){
				dto.setUsersss(selectByPrimaryKey2);
				dto.setNotification(notification);
			    dto.setQuestion(selectByPrimaryKey);
			    list1.add(dto);
			}
			
		
			}
	  }
		return list1;
	}

}
