package com.itwill2.bean.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationContextSetterInjectionAnnotationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화 시작[ApplicationContext객체생성 시작]");

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("2.bean_setter_injection_annotation.xml");

		System.out.println("----Spring Container초기화   끝[ApplicationContext객체생성   끝]");
		
		System.out.println("----------GuestService----------");
		GuestService guestService=(GuestService)applicationContext.getBean("guestService");
		
		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(2));
		
		System.out.println("----------UserService----------");
		UserService userService =(UserService)applicationContext.getBean("userService");
		System.out.println(userService.findUserList());
		
		System.out.println("----------기본형,String 데이타 setter injection----------");
		Guest guest=(Guest)applicationContext.getBean("guest");
		System.out.println(guest);
	}

}
