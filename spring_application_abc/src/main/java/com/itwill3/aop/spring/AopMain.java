package com.itwill3.aop.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;

public class AopMain {

	public static void main(String[] args) throws Exception {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("com/itwill3/aop/spring/3.aop.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService = (UserService) applicationContext.getBean("userService");
		System.out.println("------------before advice---------");
		//userService.findUserList();
		//userService.findUser(null);
		//userService.create(null);

		System.out.println("------------around advice---------");
		userService.create(null);
		userService.remove(null);
		userService.login("userId", "password");

		 System.out.println("------------after throwing advice---------");
		 userService.update(null);

	}

}
