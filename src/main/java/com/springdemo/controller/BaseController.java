package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// 这就是Spring在后端关于前端页面请求的上下文Holder
import org.springframework.web.context.request.RequestContextHolder;
// 这是Spring接收到的请求属性
import org.springframework.web.context.request.ServletRequestAttributes;

import com.springdemo.util.PageData;

public class BaseController {
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	/**
	 * Create object of PageData
	 * @return
	 */
	public PageData getPageData() {
		return new PageData(this.getRequest());
	}
	
	/**
	 * 这个过程干了3件事：
	 * 1、前端请求上下文RequestContextHolder得到请求属性
	 * 2、由ServletRequestAttributes强转成Servlet型的请求
	 * 3、得到请求的句柄，赋值于request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request
			= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
