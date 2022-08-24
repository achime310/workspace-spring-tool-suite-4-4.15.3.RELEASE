package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class GuestDaoImplMyBatis implements GuestDao{

	private SqlSession sqlSession;
	
	public GuestDaoImplMyBatis() {
		System.out.println("#### GuestDaoImplMyBatis() 기본생성자");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### GuestDaoImplMyBatis : setSqlSession("+sqlSession+") 메소드 호출");
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		return sqlSession.selectList("com.itwill.guest.mapper.GuestMapper.selectAll");
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
