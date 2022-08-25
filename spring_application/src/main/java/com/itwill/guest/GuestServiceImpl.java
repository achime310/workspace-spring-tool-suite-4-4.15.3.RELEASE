package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service(value = "guestService")
public class GuestServiceImpl implements GuestService {
	
	private GuestDao guestDao;
	
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	
	@Autowired
	public GuestServiceImpl(@Qualifier(value = "guestDao") GuestDao guestDao) {
		System.out.println("1.#### GuestServiceImpl("+guestDao+") 생성자");
		this.guestDao = guestDao;
	}
	
	@Autowired(required = true)//default는 false ,true일때 injection이 안되면, error, 잘쓰지는 않음
	//@Qualifier(value = "guestDao")
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("  #### GuestServiceImpl : setGuestDao("+guestDao+") 호출");
		this.guestDao = guestDao;
	}

	@Override
	public List<Guest> selectAll()throws Exception{
		System.out.println("#### GuestServiceImpl : selectAll() 호출");
		return  guestDao.selectAll();
	}
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : selectByNo(int no) 호출");
		return guestDao.selectByNo(no);
	}
	@Override
	public int insertGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : insertGuest(Guest guest) 호출");
		return guestDao.insertGuest(guest);
	}
	@Override
	public int updateGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : updateGuest(Guest guest) 호출");
		return guestDao.updateGuest(guest);
	}
	@Override
	public int deleteGuest(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : deleteGuest(int no) 호출");
		return guestDao.deleteGuest(no);
	}
	
}
