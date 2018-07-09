package cn.jansen.xml;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jansen.pojo.User;

public class XmlDemoTest {
	
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
	public void getUserById() {
		Integer userId = 1;
		User user = session.selectOne("cn.jansen.userMapper.getUserBuId", userId);
		System.out.println(user);
	}
	
	@Test
	public void getAllUsers() {
		List<User> userList = session.selectList("cn.jansen.userMapper.getAllUsers");
		System.out.println(userList.size());
		for (User user : userList) {
			System.out.println(user);
		}
	}
	
	@Test
	public void addUser() {
		User newUser = new User();
		newUser.setUserName("Lily");
		newUser.setUserGender("female");
		newUser.setBirthdate(new Date());
		newUser.setAddress("beijing-China");
		session.insert("cn.jansen.userMapper.addUser", newUser);
		System.out.println("insert user ok");
	}
	
	@Test
	public void updateUserById() {
		User newUser = new User();
		newUser.setUserName("Lucy");
		newUser.setUserGender("female");
		newUser.setBirthdate(new Date());
		newUser.setAddress("hangzhou-China");
		newUser.setUserId(3);
		session.update("cn.jansen.userMapper.updateUserById", newUser);
		System.out.println("update user ok");
	}
	
	@Test
	public void deleteUserById() {
		session.delete("cn.jansen.userMapper.deleteUserById", 3);
		System.out.println("delete user ok");
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}

}
