package com.springdemo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**测试slf4j的使用，暂未整合logback组件
 * @author 矮纸斜行
 *
 */
public class LoggerTest {
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		logger.debug("Hello debug!");
	}
}
