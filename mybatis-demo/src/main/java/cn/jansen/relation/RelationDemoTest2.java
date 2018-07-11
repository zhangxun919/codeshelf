package cn.jansen.relation;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.jansen.pojo.RoleUser;
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
	
	@Test
	public void testManyToMany() {
		// 多对多需要借助中间关系表来存放相互之间的关联关系，而上面的一对一、一对多其实并不需要这样的中间表
		List<RoleUser> users = session.selectList("cn.jansen.relationMapper.getUserByRoleId");
		System.out.println(users.size());
		for (RoleUser roleUser : users) {
			System.out.println(roleUser);
		}
	}
	
	@After
	public void after() {
		session.commit();
		session.close();
		sessionFactory = null;
	}
	
}
