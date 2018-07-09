package cn.jansen.annotation;

import java.io.IOException;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jansen.mapper.UserMapper;
import cn.jansen.pojo.User;

public class AnnotationDemoTest {
	
	private static SqlSessionFactory sessionFactory = null;
	private static SqlSession session = null;
	private UserMapper userMapper = null;
	
	@Before
	public void before() throws IOException {
		// 指定使用哪一个mybatis的配置文件
		String resource = "mybatis-configuration.xml";
		sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		session = sessionFactory.openSession();
		userMapper = session.getMapper(UserMapper.class);
	}
	
	@Test
	public void testSelectUserById() {
		User user = userMapper.selectUserById(1);
		System.out.println(user);
	}
	
	@Test
	public void testInsertUser() {
		User newUser = new User();
		newUser.setUserName("Lily");
		newUser.setUserGender("female");
		newUser.setBirthdate(new Date());
		newUser.setAddress("beijing-China");
		userMapper.insertUser(newUser);
		System.out.println("insert ok");
	}
	
	@Test
	public void testUpdateUserById() {
		User newUser = new User();
		newUser.setUserName("Lucy");
		newUser.setUserGender("female");
		newUser.setBirthdate(new Date());
		newUser.setAddress("hangzhou-China");
		newUser.setUserId(4);
		userMapper.updateUserBuId(newUser);
		System.out.println("update ok");
	}
	
	@Test
	public void testDeleteUserById() {
		userMapper.deleteUserById(4);
		System.out.println("delete ok");
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}

}
