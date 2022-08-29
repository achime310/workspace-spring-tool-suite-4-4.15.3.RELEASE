package com.itwill.guest;

import java.util.ArrayList;

public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	public GuestServiceImpl(GuestDao guestDao) {
		System.out.println("1.#### GuestServiceImpl("+guestDao+") 생성자");
		this.guestDao = guestDao;
	}
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("2.#### GuestServiceImpl.setGuestDao("+guestDao+") 메쏘드 호출");
		this.guestDao = guestDao;
	}
	@Override
	public ArrayList<Guest> selectAll()throws Exception{
		return guestDao.selectAll();
	}
	@Override
	public Guest selectByNo(int no)throws Exception{
		return guestDao.selectByNo(no);
	}
	@Override
	public int insertGuest(Guest guest)throws Exception{
		return guestDao.insertGuest(guest);
	}
	@Override
	public int updateGuest(Guest guest)throws Exception{
		return guestDao.updateGuest(guest);
	}
	@Override
	public int deleteGuest(int no)throws Exception{
		return guestDao.deleteGuest(no);
	}
	
}
