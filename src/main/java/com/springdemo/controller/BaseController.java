package com.springdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// �����Spring�ں�˹���ǰ��ҳ�������������Holder
import org.springframework.web.context.request.RequestContextHolder;
// ����Spring���յ�����������
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
	 * ������̸���3���£�
	 * 1��ǰ������������RequestContextHolder�õ���������
	 * 2����ServletRequestAttributesǿת��Servlet�͵�����
	 * 3���õ�����ľ������ֵ��request
	 * @return
	 */
	public HttpServletRequest getRequest() {
		HttpServletRequest request
			= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
}
