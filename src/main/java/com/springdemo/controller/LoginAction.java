package com.springdemo.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.entity.User;
import com.springdemo.service.LoginService;

@Controller
public class LoginAction {

	// From LoginServiceImpl.javaÖÐµÄ²Ö¿â
	@Resource(name = "loginService")
	private LoginService loginService;
	
	private Logger logger = LoggerFactory.getLogger(LoginAction.class);
	
    @RequestMapping("login.do")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
    //	boolean loginSuc = loginService.isUser(username, password);
    	boolean loginSuc = loginService.existsUser(username, password);
    	List<User> userList = loginService.getUserList();
    	System.out.println("userList size = " + userList.size());
    	ModelAndView mv = new ModelAndView();
    	if (loginSuc) {
    		mv.setViewName("loginSuc");
    		System.out.println("login suc!");
    		if (userList != null && userList.size() != 0) {
    			mv.addObject("userList", userList);
    			logger.debug("userList is injected!");
    			mv.addObject("test", "This is a test string!");
    		}
    		return mv;
    	} else {
    		mv.setViewName("loginErr");
    		return mv;
    	}
    }

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

}