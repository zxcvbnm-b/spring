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
		throw new MyException("对不起你还没有登录呢");	
		}
		List<NoticeDTO> list=new ArrayList<>();
		Question selectByPrimaryKey=null;
		User selectByPrimaryKey2=null;
		NoticeDTO dto=null;
		//查找这个用户的通知信息
		NotificationExample example=new NotificationExample();
		example.createCriteria().andNoticeInnerNotEqualTo(Integer.parseInt(userid));
		List<Notification> selectByExample = notifice.selectByExample(example);
		//根据通知找到问题信息，用户信息
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
			  //计算通知的数量
			  model.addAttribute("noiceCount",list1.size());
			  }
		//右部部分 
		  List<String> remenLabel=new ArrayList<>();
			//标签排序
			Map<String,Integer> map1 = MapUtil.sortByValueDescending(map.getMap1());
			List<Question> xiangguanxinxi=new ArrayList<>();
			//热门问题排序
			Map<Double,Question> map2 = MapUtil.sortByKey(map.getMap2(), true);
		  //热门问题：
		  Iterator<Double> it = map2.keySet().iterator();  //map.keySet()得到的是set集合，可以使用迭代器遍历
		  int i=0;
			while(it.hasNext()&&i<10){
				Double key = it.next();
				xiangguanxinxi.add((Question) map2.get(key));
				i++;
			}
			//热门标签：根据map得到一个里面是string的迭代器，这个string是map的key（就是这个set里面的全是map的key）
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
