package com.springdemo.service;

import java.util.List;

import com.springdemo.entity.User;
import com.springdemo.util.PageData;

public interface LoginService {
	/**
	 * ͨ��ҳ���map��Ϣpd��ѯ�û�
	 * @param pd
	 * @return
	 */
	PageData findByUsername(PageData pd);

	boolean isUser(String username, String password);

	boolean existsUser(String username, String password);

	List<User> getUserList();

	void update(User user);
}
