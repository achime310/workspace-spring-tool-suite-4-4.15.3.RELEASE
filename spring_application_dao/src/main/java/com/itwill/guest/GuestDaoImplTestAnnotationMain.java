package com.itwill.guest;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GuestDaoImplTestAnnotationMain {

	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("/com/itwill/guest/guest_dao_jdbc_annotation.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		
		GuestDao guestDao =
				(GuestDao)applicationContext.getBean("guestDaoImpl");
		
		/*
		 * GuestDao로부터 하위클래스는 못얻어도 super클래스는 얻을 수 있음.
		 * 상위타입을 검색해서~~~
		 * GuestDao를 imple한 자식객체의 참조값을 얻음
		 */
		
		System.out.println("### GuestDao.selectAll():"+guestDao.selectAll());
		Guest guest = guestDao.selectByNo(65);
		System.out.println("### GuestDao.selectByNo(65):"+guest);
		guest.setGuest_name("수정_바팁스");
		guest.setGuest_title("오늘은 수요일~~");
		System.out.println("### GuestDao.updateGuest():"+guestDao.updateGuest(guest));
		guest= guestDao.selectByNo(65);
		System.out.println(guest);
	

	}

}
