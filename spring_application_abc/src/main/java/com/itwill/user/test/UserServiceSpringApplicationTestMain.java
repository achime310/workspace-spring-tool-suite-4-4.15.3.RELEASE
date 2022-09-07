package com.itwill.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceSpringApplicationTestMain {

	public static void main(String[] args) {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/user/test/user_service_spring_application.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		System.out.println("UserService.findUserList()");
	}

}
