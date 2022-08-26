package com.itwill.guest.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoImplMyBatisMapperInterfaceTestMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/guest/guest_dao_mybatis_mapper_interface.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		/*										
		GuestDao guestDao=
				(GuestDao)applicationContext.getBean(GuestDao.class);
		System.out.println("1.selectAll:"+guestDao.selectAll());
		System.out.println("2.selectByNo:"+guestDao.selectByNo(150));
		Guest newGuest=new Guest(0, "name", null, "email@korea.com", "www.naver.com", "제목", "내용");
		System.out.println("3.insertGuest:"+guestDao.insertGuest(newGuest));
		System.out.println(newGuest);
		Guest guest=guestDao.selectByNo(250);
		guest.setGuest_name("김수정");
		guest.setGuest_email("sujung@gmail.com");
		guest.setGuest_date("2022/05/11");
		System.out.println("4.updateGuest:"+guestDao.updateGuest(guest));
		System.out.println("5.deleteGuest:"+guestDao.deleteGuest(240));
		*/
	}

}
