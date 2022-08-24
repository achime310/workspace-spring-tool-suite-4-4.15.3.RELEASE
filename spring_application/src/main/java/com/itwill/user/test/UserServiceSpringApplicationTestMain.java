package com.itwill.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserServiceSpringApplicationTestMain {

	public static void main(String[] args) throws Exception {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/user/test/user_service_spring_application.xml");
		
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		UserService userService = (UserService)applicationContext.getBean("userService");
		
		System.out.println("----------UserService----------");
		
		System.out.println("findUserList() >>> "+userService.findUserList());
		System.out.println("findUser() >>> "+userService.findUser("user1"));
		
		User user = new User("spring테스트", "1234", "스프링", "spring@bom.com");
		/*
		 * create() : 회원가입
		 * -1:아이디중복
		 *  1:회원가입성공
		 */
		System.out.println("create() >>> "+userService.create(user));
		
		user = new User("2", "1234", "(수정)스프링", "(수정)spring@bom.com");
		System.out.println("update() >>> "+userService.update(user));
		/*
		 * login() : 회원로그인
		 *  0:아이디존재안함
		 * 	1:패쓰워드 불일치
		 * 	2:로그인성공(세션)
		 */
		System.out.println("login() >>> "+userService.login("id","pw"));
		
		System.out.println("remove() >>> "+userService.remove("test111"));
		
	}

}
