package com.itwill2.bean.di;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationContextConstructorInjectionAnnotationMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]----");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("2.bean_constructor_injection_annotation.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]-------");
		
		System.out.println("------참조형데이타 Construtor Injection-----");
		GuestService guestService=
				(GuestService)applicationContext.getBean(GuestService.class);
		System.out.println(guestService.selectAll());
		
		UserService userService=(UserService)applicationContext.getBean("userService");
		System.out.println("userService:"+userService);
		
		
		System.out.println("------기본형데이타 Construtor Injection-----");
		Guest guest=(Guest)applicationContext.getBean("guest");
		System.out.println(guest);
		
	
		
	}

}
