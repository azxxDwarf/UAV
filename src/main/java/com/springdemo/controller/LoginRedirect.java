package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginRedirect {
	
	@RequestMapping(value = "/loginRedirect")
	public String login(HttpServletRequest request, HttpServletResponse response,
			String username, String password) {
		System.out.println("Web is redirected! To index.jsp");
		return "index";
	}
}
