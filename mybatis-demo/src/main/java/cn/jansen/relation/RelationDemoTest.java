package cn.jansen.relation;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jansen.pojo.Order;

public class RelationDemoTest {

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
	public void testOneToOne() {
		Integer orderId = 1;
		Order order = session.selectOne("cn.jansen.relationMapper.getOrderById", orderId);
		System.out.println(order);
	}
	
	@Test
	public void testOneToOne2() {
		Integer orderId = 1;
		Order order = session.selectOne("cn.jansen.relationMapper.getOrderById2", orderId);
		System.out.println(order);
	}
	
	@Test
	public void testOneToOne3() {
		Integer orderId = 1;
		Order order = session.selectOne("cn.jansen.relationMapper.getOrderById3", orderId);
		System.out.println(order);
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}
	
}
