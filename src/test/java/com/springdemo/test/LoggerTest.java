package com.springdemo.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**����slf4j��ʹ�ã���δ����logback���
 * @author ��ֽб��
 *
 */
public class LoggerTest {
	private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);
	
	public static void main(String[] args) {
		logger.debug("Hello debug!");
	}
}
