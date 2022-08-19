package com.itwill.guest;

public class GuestDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception{
		GuestDaoMyBatis guestDaoMyBatis=new GuestDaoMyBatis();
		System.out.println("----selectAll---");
		System.out.println(guestDaoMyBatis.selectAll());
		System.out.println("----selectByNo---");
		System.out.println(guestDaoMyBatis.selectByNo(1));
		System.out.println("----insertGuest---");
		System.out.println(guestDaoMyBatis.insertGuest(new Guest(0, "최이름", null, "email@dot.com", "http://homepage.com", "title01", "content01")));
		System.out.println("----updateGuest---");
		Guest guest = guestDaoMyBatis.selectByNo(26);
		guest.setGuest_name("바티스");
		guest.setGuest_email("batis@dot.com");
		guest.setGuest_homepage("http://batis.com");
		guest.setGuest_title("제목_바티스");
		guest.setGuest_content("내용-바티스");
		System.out.println(guestDaoMyBatis.updateGuest(guest));
		System.out.println("----deleteGuest---");
		System.out.println(guestDaoMyBatis.deleteGuest(63));
	}

}
