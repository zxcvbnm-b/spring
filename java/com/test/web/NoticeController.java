package com.test.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.test.dto.MapDTO;
import com.test.entity.Notification;
import com.test.entity.NotificationExample;
import com.test.entity.Question;
import com.test.entity.User;
import com.test.mapper.NotificationMapper;
import com.test.mapper.QuestionMapper;
import com.test.mapper.UserMapper;
import com.test.service.UserService;
import com.test.utils.MapUtil;
import com.test.utils.MyException;
import com.test.utils.NoticeDTO;

@Controller
public class NoticeController {
	@Autowired
	private QuestionMapper mapper;
	@Autowired
	private UserMapper usernamepper;
	@Autowired
	private NotificationMapper notifice;
	@Autowired
	private UserService userService;
	@Autowired
	private MapDTO map;
	@RequestMapping("/getnotices/{userid}")
  private String getNotices(@PathVariable("userid") String userid,Model model){
		if(StringUtils.isEmpty(userid)){
		throw new MyException("�Բ����㻹û�е�¼��");	
		}
		List<NoticeDTO> list=new ArrayList<>();
		Question selectByPrimaryKey=null;
		User selectByPrimaryKey2=null;
		NoticeDTO dto=null;
		//��������û���֪ͨ��Ϣ
		NotificationExample example=new NotificationExample();
		example.createCriteria().andNoticeInnerNotEqualTo(Integer.parseInt(userid));
		List<Notification> selectByExample = notifice.selectByExample(example);
		//����֪ͨ�ҵ�������Ϣ���û���Ϣ
		for (Notification notification : selectByExample) {
			dto=new NoticeDTO();
			selectByPrimaryKey= mapper.selectByPrimaryKey(notification.getNoticeQuestionId());
			selectByPrimaryKey2= usernamepper.selectByPrimaryKey(notification.getNoticeInner());
		
		if(Integer.parseInt(userid)==selectByPrimaryKey.getUserId()){
			dto.setUsersss(selectByPrimaryKey2);
			dto.setNotification(notification);
		dto.setQuestion(selectByPrimaryKey);
		}
		list.add(dto);
		}
		 if(userid!=null){
			  List<NoticeDTO> list1=userService.getNoticeCount(Integer.parseInt(userid));
			  //����֪ͨ������
			  model.addAttribute("noiceCount",list1.size());
			  }
		//�Ҳ����� 
		  List<String> remenLabel=new ArrayList<>();
			//��ǩ����
			Map<String,Integer> map1 = MapUtil.sortByValueDescending(map.getMap1());
			List<Question> xiangguanxinxi=new ArrayList<>();
			//������������
			Map<Double,Question> map2 = MapUtil.sortByKey(map.getMap2(), true);
		  //�������⣺
		  Iterator<Double> it = map2.keySet().iterator();  //map.keySet()�õ�����set���ϣ�����ʹ�õ���������
		  int i=0;
			while(it.hasNext()&&i<10){
				Double key = it.next();
				xiangguanxinxi.add((Question) map2.get(key));
				i++;
			}
			//���ű�ǩ������map�õ�һ��������string�ĵ����������string��map��key���������set�����ȫ��map��key��
      Iterator<String> iterator = map1.keySet().iterator();
      int j=0;
      while(iterator.hasNext()&&j<8){
   	   String next = (String)iterator.next();
   	   remenLabel.add(next);
   	   j++;
      }
	
		model.addAttribute("remenwenti", remenLabel);	
		model.addAttribute("xiangguanwenti", xiangguanxinxi);
     model.addAttribute("noticelist", list);
	return "mynotices";  
  }
}
