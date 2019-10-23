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
			model.addAttribute("error","用户名或者密码不能为空！！");	
		return "forward:/";
		}
		List<User> list=UserService.findByUser(username,passwd);
		if(list.size()>0){
	    user=list.get(0);		
		}
		else{
			model.addAttribute("error","登录失败，不存在此用户！！！");	
			return "forward:/";
		}
		if(check!=null){
			user.setDepatment(token);
			//保存令牌到数据库
			usermapper.updateByPrimaryKeySelective(user);
			Cookie cookie=new Cookie("token", token);
			cookie.setPath("/");
			cookie.setMaxAge(60*600*60);
            response.addCookie(cookie);
		}		
		reqeust.getSession().setAttribute("usera",user);
		model.addAttribute("error","登录成功！！！");	
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
		String realPath ="/img";//获取本地存储位置的绝对路径
	    String   newfile=realPath+"/"+uuid+substring;
	    File file=new File(newfile);
	    //要使用绝对路径才行
	    user.setImgurl(newfile);
	    img_file.transferTo(file);
	    }
		usermapper.insert(user);
		model.addAttribute("error","注册成功！！！");	
		return "forward:/";
	}
	@RequestMapping("/personal_data/{user_id}")
     private String personal_data(HttpServletRequest request,HttpServletResponse response,Model model,@PathVariable("user_id") String user_id){
		if(StringUtils.isEmpty(user_id)){
			throw new MyException("对不起你还没有登录呢");	
			}
		User personalData = usermapper.selectByPrimaryKey(Integer.parseInt(user_id));
		 model.addAttribute("user_info", personalData);
		 //我的問題數目
		QuestionExample example=new QuestionExample();
		example.createCriteria().andUserIdEqualTo(Integer.parseInt(user_id));
		List<Question> selectByExample = mapper.selectByExample(example);
		int size = selectByExample.size();
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
		model.addAttribute("count", size);
		
		return "personal";
	
	
	
}
}
