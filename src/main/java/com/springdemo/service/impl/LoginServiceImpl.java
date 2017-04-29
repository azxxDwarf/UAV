package com.springdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.springdemo.dao.LoginDao;
import com.springdemo.dao.impl.LoginDaoImpl;
import com.springdemo.entity.User;
import com.springdemo.service.LoginService;
import com.springdemo.util.PageData;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * @author °«Ö½Ð±ÐÐ
 *
 */
@Repository("loginService")
public class LoginServiceImpl implements LoginService {
	
	/**
	 * From LoginDao.javaµÄ²Ö¿â@Repository
	 */
	@Resource(name = "daoSupport")
	private LoginDao loginDao;
	
	public boolean isUser(String username, String password) {
		loginDao = new LoginDaoImpl();
		
		return loginDao.hasUser(username, password);
	}
	
	public boolean existsUser(String username, String password) {
		List<User> userList = null;
		try {
			userList = ((List<User>) loginDao.findForList("getUserInfo", new User()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (User user : userList) {
			if (username.equals(user.getUsername()) && password.equals(user.getPassword()))
				return true;
		}
		return false;
	}
	
	public List<User> getUserList() {
		return loginDao.getUserList();
	}

	public void update(User user) {
		loginDao.update(user);		
	}
	
	public PageData findByUsername(PageData pd) {
		System.out.println("In Service: it the map1->");
		pd.itPageData();
		PageData retPd = loginDao.findForObject("findByUsername", pd);
		System.out.println("In Service: it the map2->");
		if (retPd == null) {
			System.out.println("Ret pd is null");
		} else {
			retPd.itPageData();
		}
		return retPd;
	}
}
