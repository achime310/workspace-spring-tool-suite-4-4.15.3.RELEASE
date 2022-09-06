package com.itwill3.aop.spring.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;
public class AopAnnotationMain {
	public static void main(String[] args) throws Exception{
		System.out.println("------------Spring Container 초기화시작---------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext(
						"com/itwill3/aop/spring/annotation/3.aop-annotation.xml");
		System.out.println("------------Spring Container 초기화끝---------");
		UserService userService=(UserService)applicationContext.getBean("userService");
		System.out.println("------------before advice---------");
		userService.findUser("fff");
		userService.findUserList();
		
		System.out.println("------------around advice---------");
		userService.create(new User());
		userService.remove("aaa");
		
		System.out.println("------------after throwing advice---------");
		userService.update(new User());
	
	}
}
