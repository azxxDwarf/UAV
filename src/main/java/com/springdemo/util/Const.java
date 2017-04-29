package com.springdemo.util;

import org.springframework.context.ApplicationContext;

public class Const {
	public static ApplicationContext WEB_APP_CONTEXT = null;	//该值会在web容器启动时由WebAppContextListener初始化
	public static final String NO_INTERCEPTOR_PATH = ".*/((login)).*";	//不拦截这些路径
}
