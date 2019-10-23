package com.test.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.test.utils.MyException;
@ControllerAdvice(basePackages={"com"})
public class ExceptionInterceptor {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        String message="服务器好像出现错误了！！！";
        mav.addObject("errora",message);
        if(e instanceof MyException){
        	message=e.getMessage();
        	  mav.addObject("errora",message);       	
        }
        mav.setViewName("errorPage");
        return mav;
    }

}
