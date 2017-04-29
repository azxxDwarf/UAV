package com.springdemo.util;

import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class AppUtil {
	
	
	/**
	 * 如果页面中包含callback（回调）的key，则将其value和原属性json映射封装为JSONPObject返回
	 * @param pd
	 * @param map
	 * @return
	 */
	public static Object returnObject(PageData pd, Map<String, String> map) {
		if (pd.containsKey("callback")) {	// 如果包含回调的key
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		} else {
			return map;
		}
	}
}
