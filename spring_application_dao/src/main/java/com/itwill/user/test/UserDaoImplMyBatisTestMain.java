package com.itwill.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.user.User;
import com.itwill.user.UserDao;

public class UserDaoImplMyBatisTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("/com/itwill/user/user_dao_mybatis.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		UserDao userDao= (UserDao)applicationContext.getBean("userDao");
		System.out.println("----findUser----");
		System.out.println("	"+userDao.findUser("user1"));
		System.out.println("----findUserList----");
		System.out.println("	"+userDao.findUserList());
		
		System.out.println("----create----");
		User user = new User("jdbc아이디2", "jdbc비번", "jdbc이름", "jdbc@dot.com");
		System.out.println("	"+userDao.create(user));
		
		System.out.println("----update----");
		user = userDao.findUser("test123");
		user.setPassword("1234");
		user.setName("update22");
		user.setEmail("update@dot.com");
		System.out.println("	"+userDao.update(user));
		
		System.out.println("----remove----");
		System.out.println("	"+userDao.remove("2"));
		
		System.out.println("----existedUser----");
		System.out.println("	"+userDao.existedUser("blue1"));
	}

}
