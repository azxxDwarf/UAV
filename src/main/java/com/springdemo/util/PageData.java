package com.springdemo.util;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

public class PageData extends HashMap<Object, Object> implements Map<Object, Object> {
	
	private static final long serialVersionUID = 1L;
	
	// <key, json串>
	Map<Object, Object> map = null;
	HttpServletRequest request;
	
	/**
	 * 无参构造
	 */
	public PageData() {
		map = new HashMap<Object, Object>();
	}
	
	/**
	 * 带参构造
	 * @param request
	 */
	public PageData(HttpServletRequest request) {
		this.request = request;
		
		// 从请求中得到参数的键值对，我们称之为属性(properties)
		Map<String, String[]> properties = request.getParameterMap();
		
		// 要返回的map，<key, json串>
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		
		// 遍历此map
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
			// 解析values
			if (values == null) {	// 请求是空，返回的值为空
				value = "";
			} else {				// 否则，将其拼接为json串
				for (String val : values) {
					value = value + val + ",";
					System.out.println("VALUE is: " + value);
				}
				value = value.substring(0, value.length() - 1);	//砍掉最后一个','
				System.out.println("VALUE in the end is: " + value);
			}
			System.out.printf("<%s, %s>\n", key, value);
			retMap.put(key, value);
		}
		map = retMap;
	}
	
	@Override
	public Object get(Object key) {
		return map.get(key);
	}
	
	public String getString(Object key) {
		return (String)get(key);
	}
	
	public Object put(String key, String value) {
		return map.put(key, value);
	}
	
	public Object remove(Object key) {
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

	public Set<java.util.Map.Entry<Object, Object>> entrySet() {
		return map.entrySet();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set<Object> keySet() {
		return map.keySet();
	}

	public int size() {
		return map.size();
	}

	public Collection<Object> values() {
		return map.values();
	}
	
	public void itPageData() {
		if (map == null) {
			System.out.println("The pd is null!");
			return;
		}
		Iterator<java.util.Map.Entry<Object, Object>> entries = map.entrySet().iterator();
		java.util.Map.Entry<Object, Object> entry = null;
		String key = null;
		String value = null;
		while (entries.hasNext()) {
			entry = entries.next();
			key = (String) entry.getKey();
			value = (String) entry.getValue();
			System.out.printf("<%s, %s>\n", key, value);
		}
	}
}
