package com.test.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dto.MapDTO;
import com.test.entity.Category;
import com.test.entity.Question;
import com.test.entity.QuestionExample;
import com.test.entity.User;
import com.test.mapper.QuestionMapper;
import com.test.service.UserService;
import com.test.utils.MapUtil;
import com.test.utils.NoticeDTO;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class IndexController {
	@Autowired
	private QuestionMapper mapper;
	@Autowired
	private UserService userService;
	@Autowired
	private MapDTO map;
	@RequestMapping("/")
public String test(HttpServletRequest request,Model model,@RequestParam(value = "start",defaultValue="0") int start,
		@RequestParam(required=false,defaultValue="8") int pageSize,@RequestParam(required=false,defaultValue="")String search){	
	
		User attribute = (User) request.getSession().getAttribute("usera");
		//首页分类
		List<Category>list=	userService.getCategoryList();
		model.addAttribute("list",list);		
		//查询问题
		PageHelper.startPage(start, pageSize);
		QuestionExample example2=new QuestionExample();
		//List<Question> questionss = mapper.selectByExample(example2);
		String search2=null;
		if(search!=null&&!"".equals(search)){
			search2=search.replaceAll(" ", "|").trim();
		
		}
       /* if("xxxx".equals(("xx"+search+"xx"))){
			search2=null;
		}*/
		  
		  List<Question> question = mapper.selectByExampleRegexp(example2,search2);
		  PageInfo<Question> questions = new PageInfo<>(question);
		  
		  
		  //计算通知的数量
		  if(attribute!=null){
		  List<NoticeDTO> list1=userService.getNoticeCount(attribute.getId());
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
		model.addAttribute("search", search);
		if(questions.getList().size()>0){
			model.addAttribute("questions", questions);	
			
		}else{
			model.addAttribute("questions", null);		
			
		}
		
		
	return "index";
	
	
	
}
}
