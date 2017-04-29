package com.springdemo.util;

import java.util.Map;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class AppUtil {
	
	
	/**
	 * ���ҳ���а���callback���ص�����key������value��ԭ����jsonӳ���װΪJSONPObject����
	 * @param pd
	 * @param map
	 * @return
	 */
	public static Object returnObject(PageData pd, Map<String, String> map) {
		if (pd.containsKey("callback")) {	// ��������ص���key
			String callback = pd.get("callback").toString();
			return new JSONPObject(callback, map);
		} else {
			return map;
		}
	}
}
