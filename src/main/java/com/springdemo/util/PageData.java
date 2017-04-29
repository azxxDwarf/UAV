package com.springdemo.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PageData extends HashMap<String, String> implements Map<String, String> {
	private static final long serialVersionUID = 1L;
	
	// <key, json��>
	Map<String, String> map = null;
	HttpServletRequest request;
	
	/**
	 * �޲ι���
	 */
	public PageData() {
		map = new HashMap<String, String>();
	}
	
	/**
	 * ���ι���
	 * @param request
	 */
	public PageData(HttpServletRequest request) {
		this.request = request;
		
		// �������еõ������ļ�ֵ�ԣ����ǳ�֮Ϊ����(properties)
		Map<String, String[]> properties = request.getParameterMap();
		
		// Ҫ���ص�map��<key, json��>
		Map<String, String> retMap = new HashMap<String, String>();
		
		// ������map
		Iterator<Map.Entry<String, String[]>> entries = properties.entrySet().iterator();
		Map.Entry<String, String[]> entry;
		String key = "";
		String value = "";
		String[] values = null;
		
		while (entries.hasNext()) {
			// Get key and value
			entry = entries.next();
			key = entry.getKey();
			values = entry.getValue();
			// ����values
			if (values == null) {	// �����ǿգ����ص�ֵΪ��
				value = "";
			} else {				// ���򣬽���ƴ��Ϊjson��
				for (String val : values) {
					value = value + val + ",";
					System.out.println("VALUE is: " + value);
				}
				value = value.substring(0, value.length() - 1);	//�������һ��','
				System.out.println("VALUE in the end is: " + value);
			}
			System.out.printf("<%s, %s>\n", key, value);
			retMap.put(key, value);
		}
		map = retMap;
	}
	
	public String get(String key) {
		return map.get(key);
	}
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
	@Override
	public String put(String key, String value) {
		return map.put(key, value);
	}
	
	public String remove(String key) {
		return map.remove(key);
	}

	public void clear() {
		map.clear();
	}

	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	public Set<java.util.Map.Entry<String, String>> entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set<String> keySet() {
		return map.keySet();
	}

	public int size() {
		return map.size();
	}

	public Collection<String> values() {
		return map.values();
	}
	
	public void itPageData() {
		if (map == null) {
			System.out.println("The pd is null!");
			return;
		}
		Iterator<java.util.Map.Entry<String, String>> entries = map.entrySet().iterator();
		java.util.Map.Entry<String, String> entry = null;
		String key = null;
		String value = null;
		while (entries.hasNext()) {
			entry = entries.next();
			key = entry.getKey();
			value = entry.getValue();
			System.out.printf("<%s, %s>\n", key, value);
		}
	}
}
