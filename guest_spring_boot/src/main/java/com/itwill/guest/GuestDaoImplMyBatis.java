package com.itwill.guest;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//@Repository
public class GuestDaoImplMyBatis  implements GuestDao{
	@Autowired
	private SqlSession sqlSession;
	public final static String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	public GuestDaoImplMyBatis() throws Exception {
	}
	public GuestDaoImplMyBatis(SqlSession sqlSession) throws Exception {
		this.sqlSession=sqlSession;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/*
	 * READ ALL
	 */
	public List<Guest> selectAll() throws Exception {
		System.out.println(">>GuestDaoImplMyBatis");
		List<Guest> guestList = new ArrayList<Guest>();
		guestList = sqlSession.selectList(NAMESPACE+"selectAll");
		return guestList;
	}
	/*
	 * CREATE
	 */
	public int insertGuest(Guest guest) throws Exception {
		return sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		return guest;
	}
	/*
	 * DELETE
	 */
	public int deleteGuest(int guest_no) throws Exception{
		return sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		
	}
	/*
	 * UPDATE
	 */
	public int updateGuest(Guest updateGuest) throws Exception{
		int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		return updateRowCount;
	}
	

}










