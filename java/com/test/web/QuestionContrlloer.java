package com.test.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dto.MapDTO;
import com.test.entity.Comment;
import com.test.entity.Labels;
import com.test.entity.LabelsExample;
import com.test.entity.Notification;
import com.test.entity.Question;
import com.test.entity.QuestionExample;
import com.test.entity.User;
import com.test.mapper.LabelsMapper;
import com.test.mapper.NotificationMapper;
import com.test.mapper.QuestionMapper;
import com.test.mapper.UserMapper;
import com.test.service.QuestionService;
import com.test.service.UserService;
import com.test.utils.MapUtil;
import com.test.utils.MyException;
import com.test.utils.NoticeDTO;

@Controller
public class QuestionContrlloer {
	@Autowired
	private  NotificationMapper noticemapper;
	@Autowired
	private LabelsMapper mapper2;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private UserService userService;
	@Autowired
private QuestionMapper mapper;
	@Autowired
	private MapDTO map;
	@Autowired
	private UserMapper uermapper;
	@RequestMapping("/question/user_question/{user_id}")
	public String Questions(@PathVariable("user_id") String user_id,HttpServletRequest request,Model model,@RequestParam(value = "start",defaultValue="0") int start,
			@RequestParam(required=false,defaultValue="8") int pageSize){	
		//��ѯ����
		if(StringUtils.isEmpty(user_id)){
			throw new MyException("�Բ����㻹û�е�¼��,���ܲ鿴�Լ������⣡����");	
			}
		PageHelper.startPage(start, pageSize);
		QuestionExample example2=new QuestionExample();
		example2.createCriteria().andUserIdEqualTo(Integer.parseInt(user_id));
		List<Question> questions = mapper.selectByExample(example2);
		  PageInfo<Question> question = new PageInfo<>(questions);
		  if(user_id!=null){
			  List<NoticeDTO> list1=userService.getNoticeCount(Integer.parseInt(user_id));
			  //����֪ͨ������
			  model.addAttribute("noiceCount",list1.size());
			  }
		model.addAttribute("questions", question);
		model.addAttribute("user_id", user_id);
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
		return "myquestion";
		
	}
	@RequestMapping("/question/{question_id}")
	public String FindQuestion(@PathVariable("question_id") String question_id,Model model,String checklook,HttpServletRequest request){
		User attribute = (User) request.getSession().getAttribute("usera");
		if(question_id.isEmpty()){
			model.addAttribute("error", "����ʵ����ⲻ����");
			return "forward:/";			
		}
		//��������id��������ľ�������
		Question selectByPrimaryKey = mapper.selectByPrimaryKey(Integer.parseInt(question_id));	
		if(selectByPrimaryKey== null){
			model.addAttribute("error", "����ʵ����ⲻ����");
		return "forward:/";
		}
		//�������������������
		mapper.addQuesttionCount(selectByPrimaryKey);		
		//�ҳ�����ķ����ߵ���Ϣ
		User selectByPrimaryKey2 = uermapper.selectByPrimaryKey(selectByPrimaryKey.getUserId());
		selectByPrimaryKey.setUser(selectByPrimaryKey2);
		model.addAttribute("question_info", selectByPrimaryKey);
		//��ȡ����
		List<Comment>  list_Comment=questionService.getComment(selectByPrimaryKey.getQuestionId(),1);
		model.addAttribute("list_Comment", list_Comment);
		
		//��ȡ��ǩ���������
		String describes = selectByPrimaryKey.getDescribes();
		String replaceAll = describes.replaceAll(",", "|");
		selectByPrimaryKey.setDescribes(replaceAll);
		List<Question> xiangguanwenti=mapper.SelectByTat(selectByPrimaryKey);
		//�������
		model.addAttribute("xiangguanwenti", xiangguanwenti);
		String[] splits = replaceAll.split("\\|");//|��Ҫת��
		model.addAttribute("splits", Arrays.asList(splits));
	   //����δ����Ϣ
		if(checklook!=null){
			Notification record5 = new Notification();
			record5.setNotificationId(Integer.parseInt(checklook));
			record5.setNoticeState(1);
			noticemapper.updateByPrimaryKeySelective(record5);
		}
		 if(attribute!=null){
			  List<NoticeDTO> list1=userService.getNoticeCount(attribute.getId());
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
		return "question_info";
		
	}
	@RequestMapping("/puquestion")
	public String puQuestion(HttpServletRequest request,Model model){	
		//���ر�ǩ����
		User attribute = (User) request.getSession().getAttribute("usera");
		LabelsExample example = new LabelsExample();
		List<Labels> selectByExample = mapper2.selectByExample(example);
		model.addAttribute("labels_category",selectByExample);
		 if(attribute!=null){
			  List<NoticeDTO> list1=userService.getNoticeCount(attribute.getId());
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
		return "puQuestion";
		
	}
	@RequestMapping("/addquestion")
	public String addQuestion(HttpServletRequest request,Model model,Question question){
		if(question.getUserId()==null){
			throw new MyException("�Բ����㻹û�е�¼�����ܽ������ʣ�����");
			
		}
		if(question.getLabel()==null){
			throw new MyException("�Բ�����ݔ��Ճ��ݣ�����");
			
		}
		if(question.getQuestionTitle()==null){
			throw new MyException("�Բ�����}���ܞ�գ�����");
			
		}
		question.setBrowse(0);
		question.setCreateTime(new Date(System.currentTimeMillis()));
		question.setReply(0);
		 mapper.insertSelective(question);
		return "forward:/";
		
	}
	
}
