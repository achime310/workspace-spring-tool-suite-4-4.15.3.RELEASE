package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/*
 * @Service("아이디")
 *  - Service class에사용
 *  - Service객체를 생성(기본생성자)하고 guestService란 아이디로 객체를 등록한다.
 *  - <bean id="guestService" class="com.itwill.guest.GuestServiceImpl"/>
 */
@Service
public class GuestServiceImpl implements GuestService {
	@Autowired
	@Qualifier("guestDaoImplMyBatisMapperInterface")
	private GuestDao guestDao;
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	public GuestServiceImpl(GuestDao guestDao) {
		System.out.println("1.#### GuestServiceImpl(GuestDao guestDao) 생성자");
		this.guestDao = guestDao;
	}
	/*
	 * @Autowired
	 *  - Injection시에사용
	 *  - setter메쏘드위에기술할경우 setter메쏘드호출
	 *  - @Qualifier("userDao") : userDao 아이디를 가진빈객체참조를 인자로넣어서 호출
	 *  - <bean id="guestService" class="com.itwill.guest.GuestServiceImpl">
				<property name="guestDao" ref="guestDao"/>
		  </bean>
	 */
	
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("2.#### GuestServiceImpl.setGuestDao(GuestDao guestDao) 메쏘드 호출");
		this.guestDao = guestDao;
	}
	@Override
	public List<Guest> selectAll()throws Exception{
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
