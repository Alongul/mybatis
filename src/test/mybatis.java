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
	//ͨ��id��ѯ�û�
	public void test1() throws IOException{
		//��ȡ�����ļ�
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//��ҪsqlSessionFactoryBuilder
		//����sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//����һ��sqlSession
		SqlSession session=ssft.openSession();		
		//�������ݿ�
		//����1 Ҫ������sql��䣻����2 sql����еĲ�����ռλ������
		user user1=session.selectOne("usermapper.selectUserByid", 2);
		System.out.println(user1);
		
	}
	@Test
	//ģ����ѯ
	public void test2() throws IOException{
		//��ȡ�����ļ�
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//��ҪsqlSessionFactoryBuilder
		//����sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//����һ��sqlSession
		SqlSession session=ssft.openSession();		
		//�������ݿ�
		//����1 Ҫ������sql��䣻����2 sql����еĲ�����ռλ������
		List<user> list=session.selectList("usermapper.selectUserByname", "j");
		for(user u:list) {
			System.out.println(u);
		}
		
	}
	@Test
	//�����û�
	public void test3() throws IOException{
		//��ȡ�����ļ�
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//��ҪsqlSessionFactoryBuilder
		//����sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//����һ��sqlSession
		SqlSession session=ssft.openSession();		
		//�������ݿ�
		//����1 Ҫ������sql��䣻����2 sql����еĲ�����ռλ������
		user u1=new user();
		u1.setId(6);
		u1.setName("������");
		u1.setSex("��");
		u1.setPassword("23");
		session.insert("usermapper.insertuser", u1);
		session.commit();//����Ľ���
	}
	@Test
	//�޸��û�
	public void test4() throws IOException{
		//��ȡ�����ļ�
		String resource = "sqlMappConfig.xml";
		InputStream inputStream=Resources.getResourceAsStream(resource);
		//��ҪsqlSessionFactoryBuilder
		//����sqlSessionfactory
		SqlSessionFactory ssft = new SqlSessionFactoryBuilder().build(inputStream);
		//����һ��sqlSession
		SqlSession session=ssft.openSession();		
		//�������ݿ�
		//����1 Ҫ������sql��䣻����2 sql����еĲ�����ռλ������
		user u1=new user();
		u1.setId(4);
		u1.setName("С��");
		session.update("usermapper.updateuser", u1);//("usermapper.updateuser", u1);
		session.commit();//����Ľ���
	}
}
	

	


