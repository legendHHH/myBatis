package com.myBaits.test;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import com.myBaits.po.User;

public class Test1 {
	//定义工厂对象
	private SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void testCreateSqlsessionFactory()throws Exception {
		//创建sqlsession工厂
		//sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("SqlMapConfig.xml"));
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 使用SqlSessionFactoryBuilder从xml配置文件中创建SqlSessionFactory
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}
	
	@Test
	public void testFindUserById() {
		System.out.println("sqlSessionFactory:"+sqlSessionFactory);
		//通过工厂对象生成sqlsession对象
		SqlSession session = sqlSessionFactory.openSession();
		User user = session.selectOne("test.findUserById",10);//只能查询一条记录
		System.out.println(user);
		
	}
}
