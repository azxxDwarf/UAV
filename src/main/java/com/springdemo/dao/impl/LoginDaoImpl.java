package com.springdemo.dao.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.springdemo.dao.LoginDao;
import com.springdemo.db.DBAccess;
import com.springdemo.entity.User;
import com.springdemo.util.PageData;


/**DAO类，下面@Repository注解，作为Service的仓库
 * @author 矮纸斜行
 *
 */
@Repository("daoSupport")
public class LoginDaoImpl implements LoginDao {
	
	/**
	 * From spring-mybatis.xml中的会话模板
	 */
	@Resource(name = "sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	public User findByUsername(User user) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行sql语句
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		
		// 返回用户List，交给业务层处理
		return null;
	}
	
	public boolean hasUser(String username, String password) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<User> userList = new ArrayList<User>();
		try {
			sqlSession = dbAccess.getSqlSession();
			// 执行sql语句
			userList = sqlSession.selectList("UserMapper.getUserInfo");
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (sqlSession != null)
				sqlSession.close();
		}
		
		for (User user : userList) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;
		}
		
		return false;
	}
	
	/* 查找对象列表
	 * @see com.springdemo.dao.LoginDao#findForObject(java.lang.String, java.lang.Object)
	 */
	public Object findForList(String str, Object obj) throws Exception {
		return sqlSessionTemplate.selectList(str, obj);
	}
	
	public List<User> getUserList() {
		return sqlSessionTemplate.selectList("getUserInfo", new User());
	}

	public void update(User user) {
		sqlSessionTemplate.update("addUser", user);
	}
	
	public PageData findForObject(String str, Object obj) {
		PageData myPd = (PageData) obj;
		if (myPd != null) {
			System.out.println("In DAO");
			myPd.itPageData();
		} else {
			System.out.println("myPd is null!");
		}
		return sqlSessionTemplate.selectOne(str, obj);
	}
}
