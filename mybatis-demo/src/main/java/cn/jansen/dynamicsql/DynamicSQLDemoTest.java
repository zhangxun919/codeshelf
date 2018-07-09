package cn.jansen.dynamicsql;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jansen.mapper.UserMapper;
import cn.jansen.pojo.User;

public class DynamicSQLDemoTest {
	
	private static SqlSessionFactory sessionFactory = null;
	private static SqlSession session = null;
	
	@Before
	public void before() throws IOException {
		// 指定使用哪一个mybatis的配置文件
		String resource = "mybatis-configuration.xml";
		sessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(resource));
		session = sessionFactory.openSession();
	}
	
	@Test
	public void testWhereAndIf() {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userName", "jack");
		paramMap.put("userGender", "male");
		List<User> userList = session.selectList("cn.jansen.dynamicUserMapper.getUser", paramMap);
		System.out.println(userList.size());
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testSetAndIf() {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userName", "Lisp");
		paramMap.put("userGender", "male");
		paramMap.put("userId", "5");
		session.update("cn.jansen.dynamicUserMapper.updateUser", paramMap);
		System.out.println("update ok");
	}
	
	@Test
	public void testWhenAndChoose() {
		Map<String,String> paramMap = new HashMap<>();
		paramMap.put("userName", "Lisp");
		paramMap.put("userGender", "male");
		paramMap.put("userId", "5");
		// select user_id userId, user_name userName, user_gender userGender, birthdate, address from user WHERE user_name = ? 
		List<User> userList = session.selectList("cn.jansen.dynamicUserMapper.getUser2", paramMap);
		System.out.println(userList.size());
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void testForeach() {
		List<Integer> ids = new ArrayList<>();
		ids.add(1);
		ids.add(2);
		List<User> userList = session.selectList("cn.jansen.dynamicUserMapper.getUser5", ids);
		System.out.println(userList.size());
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}

}
