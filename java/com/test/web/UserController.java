package com.test.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.test.dto.MapDTO;
import com.test.entity.Question;
import com.test.entity.QuestionExample;
import com.test.entity.User;
import com.test.mapper.QuestionMapper;
import com.test.mapper.UserMapper;
import com.test.service.UserService;
import com.test.utils.MapUtil;
import com.test.utils.MyException;

@Controller
public class UserController {
	   @Autowired
	private UserService  UserService;
		@Autowired
		private MapDTO map;
	   @Autowired
	   private UserMapper usermapper;
	   @Autowired
	   private QuestionMapper mapper;
	@RequestMapping("/login")
	private String UserLogin(@RequestParam(name="passwd",required=true) String passwd,String check,
			@RequestParam(name="username",required=true) String username,Model model,HttpServletRequest reqeust,HttpServletResponse response){
		String token=UUID.randomUUID().toString().replaceAll("-", "");
		User user =null;		
		if("".equals(passwd)&&passwd==null&&"".equals(username)&&username==null){
			model.addAttribute("error","�û����������벻��Ϊ�գ���");	
		return "forward:/";
		}
		List<User> list=UserService.findByUser(username,passwd);
		if(list.size()>0){
	    user=list.get(0);		
		}
		else{
			model.addAttribute("error","��¼ʧ�ܣ������ڴ��û�������");	
			return "forward:/";
		}
		if(check!=null){
			user.setDepatment(token);
			//�������Ƶ����ݿ�
			usermapper.updateByPrimaryKeySelective(user);
			Cookie cookie=new Cookie("token", token);
			cookie.setPath("/");
			cookie.setMaxAge(60*600*60);
            response.addCookie(cookie);
		}		
		reqeust.getSession().setAttribute("usera",user);
		model.addAttribute("error","��¼�ɹ�������");	
		return "forward:/";
	}
	@RequestMapping("/logout")
	private String UserLoginOut(Model model,HttpServletRequest reqeust,HttpServletResponse response,String userid){
		User user=new User();
		user.setId(Integer.parseInt(userid));
		user.setDepatment("0");
		HttpSession session = reqeust.getSession();
		session.setMaxInactiveInterval(-1);
		session.removeAttribute("usera");
		Cookie cookie=new Cookie("token", null);
		cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
		usermapper.updateByPrimaryKeySelective(user);
		
		return "forward:/";
	}
	@RequestMapping("/register")
	private String UserRegister(Model model,HttpServletRequest reqeust,HttpServletResponse response){
		
		return "register";
	}
	@RequestMapping("/register_success")
	private String Register(Model model,HttpServletRequest reqeust,HttpServletResponse response,User user,@RequestParam(required=false)MultipartFile img_file) throws IllegalStateException, IOException{
		if(img_file!=null){
		String oldFilename = img_file.getOriginalFilename();
	    String substring = oldFilename.substring( oldFilename.lastIndexOf("."));
	    String uuid=UUID.randomUUID().toString().replaceAll("-", "");
		String realPath ="/img";//��ȡ���ش洢λ�õľ���·��
	    String   newfile=realPath+"/"+uuid+substring;
	    File file=new File(newfile);
	    //Ҫʹ�þ���·������
	    user.setImgurl(newfile);
	    img_file.transferTo(file);
	    }
		usermapper.insert(user);
		model.addAttribute("error","ע��ɹ�������");	
		return "forward:/";
	}
	@RequestMapping("/personal_data/{user_id}")
     private String personal_data(HttpServletRequest request,HttpServletResponse response,Model model,@PathVariable("user_id") String user_id){
		if(StringUtils.isEmpty(user_id)){
			throw new MyException("�Բ����㻹û�е�¼��");	
			}
		User personalData = usermapper.selectByPrimaryKey(Integer.parseInt(user_id));
		 model.addAttribute("user_info", personalData);
		 //�ҵĆ��}��Ŀ
		QuestionExample example=new QuestionExample();
		example.createCriteria().andUserIdEqualTo(Integer.parseInt(user_id));
		List<Question> selectByExample = mapper.selectByExample(example);
		int size = selectByExample.size();
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
		model.addAttribute("count", size);
		
		return "personal";
	
	
	
}
}
