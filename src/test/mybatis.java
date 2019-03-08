package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import dll_bean.user;
public class mybatis {
	
	@Test
	//通过id查询用户
	public void test1() throws IOException{
		//读取配置文件
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBuilder
		//创建sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//生产一个sqlSession
		SqlSession session=ssft.openSession();		
		//操作数据库
		//参数1 要操作的sql语句；参数2 sql语句中的参数（占位符）；
		user user1=session.selectOne("usermapper.selectUserByid", 2);
		System.out.println(user1);
		
	}
	@Test
	//模糊查询
	public void test2() throws IOException{
		//读取配置文件
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBuilder
		//创建sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//生产一个sqlSession
		SqlSession session=ssft.openSession();		
		//操作数据库
		//参数1 要操作的sql语句；参数2 sql语句中的参数（占位符）；
		List<user> list=session.selectList("usermapper.selectUserByname", "j");
		for(user u:list) {
			System.out.println(u);
		}
		
	}
	@Test
	//增加用户
	public void test3() throws IOException{
		//读取配置文件
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBuilder
		//创建sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//生产一个sqlSession
		SqlSession session=ssft.openSession();		
		//操作数据库
		//参数1 要操作的sql语句；参数2 sql语句中的参数（占位符）；
		user u1=new user();
		u1.setId(6);
		u1.setName("邓龙龙");
		u1.setSex("男");
		u1.setPassword("23");
		session.insert("usermapper.insertuser", u1);
		session.commit();//事务的结束
	}
	@Test
	//修改用户
	public void test4() throws IOException{
		//读取配置文件
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//需要sqlSessionFactoryBuilder
		//创建sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//生产一个sqlSession
		SqlSession session=ssft.openSession();		
		//操作数据库
		//参数1 要操作的sql语句；参数2 sql语句中的参数（占位符）；
		user u1=new user();
		u1.setId(4);
		u1.setName("小红");
		session.update("usermapper.updateuser", u1);//("usermapper.updateuser", u1);
		session.commit();//事务的结束
	}
}
	

	


