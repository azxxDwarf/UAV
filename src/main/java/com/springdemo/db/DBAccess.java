package com.springdemo.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class DBAccess {
	// 先假设他会自动装入，但令人蛋疼的是——不能自动注入
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSession getSqlSession() throws IOException {
		// 通过配置文件获取数据库连接相关信息
		Reader reader = Resources.getResourceAsReader("/config/sqlConfig.xml");
		
		// 通过信息构建SqlSessionFactory连接工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// 由工厂打开一个数据库会话
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
