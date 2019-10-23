package com.test.interceptor;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.test.entity.User;
import com.test.entity.UserExample;
import com.test.mapper.UserMapper;
@Component
public class LoginInterceptor implements HandlerInterceptor{
	//主要在拦截器注入属性
	@Autowired
  private UserMapper usermapper;
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object arg2, ModelAndView arg3)
			throws Exception {
		ModelAndView  mv=new ModelAndView();
		if(String.valueOf(response.getStatus()).matches("4[0-9][0-9]")){
//			request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
		/*	response.sendRedirect("/jsp/error.jsp");*/
		mv.addObject("error", "你请求的资源不存在！！！")	;
			
		}else if(String.valueOf(response.getStatus()).matches("5[0-9][0-9]")){
//			request.getRequestDispatcher("/jsp/error2.jsp").forward(request, response);
		/*	response.sendRedirect("/jsp/error2.jsp");*/
			mv.addObject("error", "服务器出现异常了，请你再试试！！！");
			
		}		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception {
		String value=null;
		User user=new User();
		Cookie[] cookies = request.getCookies();
		if(cookies==null){
			return true;
		}else{
		for (Cookie cookie : cookies) {
			if("token".equals(cookie.getName())){
				value = cookie.getValue();
				break;
			}
		}
		}
		if(value==null||"0".equals(value)){
			return true;
		}
		UserExample example = new UserExample();
		example.createCriteria().andDepatmentEqualTo(value);
		List<User> selectByExample = usermapper.selectByExample(example);
		if(selectByExample.size()>0){
			user = selectByExample.get(0);
			 request.getSession().setAttribute("usera", user);
		}
		return true;
	}

}
