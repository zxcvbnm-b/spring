package com.test.web;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.test.dto.AccesstTokenDTO;
import com.test.entity.User;
import com.test.entity.UserExample;
import com.test.mapper.UserMapper;
import com.test.provider.GitHubProvider;

@Controller
public class OauthController {
	@Autowired
	private UserMapper usermapper;
	@Autowired
	private GitHubProvider thp;
	@RequestMapping("/callback")
public String GitHubOauth(@RequestParam(name="code") String code,String state,HttpServletRequest reqeust,Model model,HttpServletResponse response) throws IOException{
	AccesstTokenDTO	atd=new AccesstTokenDTO();
	atd.setClient_id("0fb514ce85ccbc822fd1");
	atd.setClient_secret("139769311ae8252e296646dbd121f6f17821729a");
	atd.setCode(code);
	atd.setState(state);
	atd.setRedirect_uri("http://localhost:8080/callback");
	String sendPostRequest = thp.SendPostRequest(atd);
	User userInfo = thp.getUserInfo(sendPostRequest);
	
	UserExample example=new UserExample();
	example.createCriteria().andPasswdEqualTo(userInfo.getPasswd());
	List<User> selectByExample = usermapper.selectByExample(example);
	if(!(selectByExample.size()>0)){
		userInfo.setDepatment(UUID.randomUUID().toString().replaceAll("-", ""));
		 usermapper.insertSelective(userInfo);		
	}else{
		userInfo.setDepatment(UUID.randomUUID().toString().replaceAll("-", ""));
		 userInfo=selectByExample.get(0);
		usermapper.updateByPrimaryKeySelective(userInfo);
		
	}

  System.out.println(userInfo);
	Cookie cookie=new Cookie("token", userInfo.getDepatment());
	cookie.setPath("/");
	cookie.setMaxAge(60*600*60);
    response.addCookie(cookie);		
    reqeust.getSession().setAttribute("usera",userInfo);
    model.addAttribute("error","µÇÂ¼³É¹¦£¡£¡£¡");		
	return "redirect:/";		
}
}
