package com.itwill.guest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplMyBatisTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("/com/itwill/guest/guest_dao_mybatis.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		GuestDao guestDao = (GuestDao)applicationContext.getBean(GuestDao.class);
		System.out.println("1.selectAll: "+guestDao.selectAll());

	}

}
