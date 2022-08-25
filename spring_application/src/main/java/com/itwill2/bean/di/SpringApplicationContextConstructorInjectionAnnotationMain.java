package com.itwill2.bean.di;

import java.lang.reflect.Method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.user.UserService;

public class SpringApplicationContextConstructorInjectionAnnotationMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화 시작[ApplicationContext객체생성 시작]");

		ApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("2.bean_constructor_injection_annotation.xml");

		System.out.println("----Spring Container초기화   끝[ApplicationContext객체생성   끝]");
		System.out.println("----------GuestService----------");
		
		/* "guestService"이름으로 getBean하는 작업은 잘 하지 않는다.
		 * GuestService
		 * guestService=(GuestService)applicationContext.getBean("guestService");
		 */
		/*
		 * 상위타입으로 type베이스로 호출
		 * 하위가 2개이상 있다면 아래와 같이 할 수 없고, 자식객체에 이름을 주고 찾거나 해야 한다.
		 * GuestService.class = "com.itwill.guest.GuestService" 와 동일하다
		 * -> GuestService가 interface이므로 하위객체를 검색한다고????
		 */
		System.out.println("----------참조형데이타 Constructor Injection----------");
		GuestService guestService=
				(GuestService)applicationContext.getBean(GuestService.class);
		
		System.out.println(guestService.selectAll());
		/*
		System.out.println(guestService.selectByNo(2));
		
		System.out.println("----------기본형----------");
		Guest guest = (Guest)applicationContext.getBean(Guest.class);
		
		System.out.println(guest);
		*/
		//헷갈리지말자. 위의 실행결과는 DB에 저장하는 것이 아니다.
		
		
		
		
		/*********reflection api*********/
		// class의 이름을 통해, class의 모든 정보를 알 수 있다.
		// 'set+대문자' 으로 시작하는 메소드 검색+ 매개변수1개 이면 => setter
		Class guestClass1 = GuestService.class;
		Class guestClass2 = Class.forName("com.itwill.guest.GuestService");
		
		String className=guestClass1.getName();
		System.out.println(className);
		
		//VM 또는 Framework에서 하는 작업
		Method[] methods = guestClass2.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method);
		}
		
		
		
		
		  System.out.println("----------UserService----------"); UserService
		  userService =(UserService)applicationContext.getBean("userService");
		  System.out.println("userService: "+userService);
		  
			
			  System.out.println();
			  System.out.println("----------기본형,String 데이타 setter injection----------");
			  Guest guest=(Guest)applicationContext.getBean("guest");
			  //매개변수 생성자 호출되고 -> setter값이 적용되서 호출되어, setter에 value가 출력된다
			  System.out.println(guest);
			 
		 
	}

}
