package com.springdemo.dao;

import java.util.List;

import com.springdemo.entity.User;
import com.springdemo.util.PageData;

public interface LoginDao {
	User findByUsername(User user);

	boolean hasUser(String username, String password); 
	
	/**
	 * @param str
	 * @param obj
	 * @return
	 * @throws Exception
	 */
	public Object findForList(String str, Object obj) throws Exception;

	List<User> getUserList();

	void update(User user);

	PageData findForObject(String str, Object obj);
	
}
