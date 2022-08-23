package com.itwill.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestServiceSpringApplicationTestMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill/guest/test/guest_service_spring_application.xml");

		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");

		System.out.println("----------GuestService----------");
		GuestService guestService = (GuestService) applicationContext.getBean("guestService");

		System.out.println(guestService.selectAll());
		System.out.println(guestService.selectByNo(65));

		System.out.println(guestService.insertGuest(
				new Guest(0, "스프링", "1991-03-10", "spring@dot.com", "http://spring.com", "(제목)봄봄봄", "(내용)봄이다")));

		System.out.println(guestService.updateGuest(
				new Guest(82, "썸머", "2001-03-10", "summer@dot.com", "http://summer.com", "(제목)여름", "(내용)여름이다")));
		System.out.println(guestService.deleteGuest(83));
	}

}
