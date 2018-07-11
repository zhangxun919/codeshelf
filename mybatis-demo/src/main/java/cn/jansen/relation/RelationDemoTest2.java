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
import cn.jansen.pojo.SuperUser;

public class RelationDemoTest2 {

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
	public void testOneToMany() {
		Integer userId = 1;
		// 本次查询结果是两条，而对于用户SuperUser来说，是一条记录，里面包含多个订单，所以使用selectOne
		SuperUser su = session.selectOne("cn.jansen.relationMapper.getUserAndOrdersByUserId", userId);
		System.out.println(su);
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}
	
}
