package com.itwill.user.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoImplTestMain {

	public static void main(String[] args)throws Exception {
		System.out.println("-----Spring Container초기화시작[ApplicationContext객체생성시작]------------------");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("user_dao_jdbc.xml");
		System.out.println("-----Spring Container초기화끝[ApplicationContext객체생성끝]--------------------");
		System.out.println("----findUser----");
		System.out.println("----findUserList----");
		
		System.out.println("----create----");
		
		System.out.println("----update----");
		System.out.println("----remove----");
		System.out.println("----existedUser----");
		
	}

}
