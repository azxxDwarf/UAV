package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.User;
import com.springdemo.util.PageData;

public interface LoginService {
	/**
	 * 通过页面的map信息pd查询用户
	 * @param pd
	 * @return
	 */
	PageData findByUsername(PageData pd);

	boolean isUser(String username, String password);

	boolean existsUser(String username, String password);

	List<User> getUserList();

	void update(User user);
}
