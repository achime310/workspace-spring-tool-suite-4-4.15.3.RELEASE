package com.itwill3.aop.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class AopAnnotationMain {
	public static void main(String[] args) throws Exception {
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill3/aop/spring/annotation/3.aop-annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService = (UserService) applicationContext.getBean("userService");

		System.out.println("------------before advice---------");
		userService.findUserList();
		userService.findUser("fff");

		System.out.println("------------around advice---------");
		//userService.create(new User("Aop", "1234", "에이오피", "aop@dot.com"));
		//userService.create(new User());
		userService.remove("test");
		
		  System.out.println("------------after throwing advice---------");
		  userService.update(new User());
		 
	}
}
