package com.springdemo.util;

import org.springframework.context.ApplicationContext;

public class Const {
	public static ApplicationContext WEB_APP_CONTEXT = null;	//��ֵ����web��������ʱ��WebAppContextListener��ʼ��
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)).*";	//��������Щ·��
}
