package com.itwill.guest.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplMyBatisTestAnnotationMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_mybatis_annotation.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		GuestDao guestDao = 
				//(GuestDao)applicationContext.getBean(GuestDao.class);	//GuestDao를 Impl하는 Dao가 여러개이므로
				(GuestDao)applicationContext.getBean("guestDaoImplMyBatis");
		
		System.out.println("1.selectAll: "+guestDao.selectAll());
		
		System.out.println("2.selectByNo(): "+guestDao.selectByNo(82));
		
		Guest guest = new Guest(0, "최바팁", "1991.03.10", "email@dot.com", "http://homepage.com", "title01", "content01");
		System.out.println("3.insert(): "+guestDao.insertGuest(guest));
		
		guest = guestDao.selectByNo(82);
		guest.setGuest_name("Autumn");
		guest.setGuest_date("2020-02-02");
		guest.setGuest_email("fall@dot.com");
		guest.setGuest_homepage("http://fall.com");
		guest.setGuest_title("가을이 오고있어");
		guest.setGuest_content("가을-가을-가을-가을");
		guestDao.updateGuest(guest);
		System.out.println("4.updateGuest(): "+guest);
		
		System.out.println("5.deleteGuest(): "+guestDao.deleteGuest(88));
	}

}
