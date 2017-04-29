package com.springdemo.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

public class DBAccess {
	// �ȼ��������Զ�װ�룬�����˵��۵��ǡ��������Զ�ע��
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public SqlSession getSqlSession() throws IOException {
		// ͨ�������ļ���ȡ���ݿ����������Ϣ
		Reader reader = Resources.getResourceAsReader("/config/sqlConfig.xml");
		
		// ͨ����Ϣ����SqlSessionFactory���ӹ���
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		// �ɹ�����һ�����ݿ�Ự
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		return sqlSession;
	}
}
