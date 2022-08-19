package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(10)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
 */

public class GuestDaoMyBatis {

	private SqlSessionFactory sqlSessionFactory;
	
	public static final String NAMESPACE="com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoMyBatis() {
		try {
			sqlSessionFactory=
					new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int insertGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.insert(NAMESPACE+"insertGuest",guest);
		sqlSession.close();

		return rowCount;
	}

	public Guest selectByNo(int no) throws Exception {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		Guest guest = 
		sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		
		sqlSession.close();
	
		return guest;
	}

	public List<Guest> selectAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		
		List<Guest> guestList =
		sqlSession.selectList(NAMESPACE+"selectAll");
		
		sqlSession.close();
		return guestList;
	}

	public int updateGuest(Guest guest) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.update(NAMESPACE+"updateGuest",guest);
		
		sqlSession.close();

		return rowCount;
	}

	public int deleteGuest(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int rowCount=
				sqlSession.delete(NAMESPACE+"deleteGuest",no);
		sqlSession.close();

		return rowCount;
	}
}
