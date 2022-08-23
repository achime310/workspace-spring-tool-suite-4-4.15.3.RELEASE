package com.itwill.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class UserDaoImpl implements UserDao {
	private DataSource dataSource;

	public UserDaoImpl() {
		System.out.println("#### UserDaoImpl() : 디폴트생성자 호출  ");
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("  #### UserDaoImpl : setDataSource("+dataSource+") 호출  ");
		this.dataSource = dataSource;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImpl : create() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			/*
			 * 예외발생 예상코드
			 */
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_INSERT);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			insertRowCount = pstmt.executeUpdate();
		} finally {
			/*
			 * 예외발생과 관계없이 반듯시 실행되는 코드
			 */
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return insertRowCount;
	}

	
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImpl : update() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			/*
			 * 예외발생 예상코드
			 */
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_UPDATE);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
			updateRowCount = pstmt.executeUpdate();
		} finally {
			/*
			 * 예외발생과 관계없이 반듯시 실행되는 코드
			 */
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return updateRowCount;
	}

	
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : remove() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		int removeRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_REMOVE);
			pstmt.setString(1, userId);
			removeRowCount = pstmt.executeUpdate();

		} finally {
			/*
			 * 예외발생과 관계없이 반듯시 실행되는 코드
			 */
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		}
		return removeRowCount;
	}
	
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : findUser() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User findUser = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				findUser = new User(rs.getString("userid"), 
									rs.getString("password"), 
									rs.getString("name"),
									rs.getString("email"));

			}
		} finally {
			/*
			 * 예외발생과 관계없이 반듯시 실행되는 코드
			 */
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return findUser;
	}
	
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl : findUserList 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<User> findUserList = new ArrayList<User>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				findUserList.add(new User(	rs.getString("userid"),
											rs.getString("password"), 
											rs.getString("name"),
											rs.getString("email")));

			}
		} finally {
			/*
			 * 예외발생과 관계없이 반듯시 실행되는 코드
			 */
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return findUserList;
	}
	
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImpl : existedUser() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isExist = false;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID_COUNT);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			//count는 적어도 0이상이 무조건 나옴
			rs.next();
			int count = rs.getInt("cnt");
			if (count == 1) {
				isExist = true;
			}
		} finally {
			/*
			 * 예외발생과 관계없이 반드시 실행되는 코드
			 */
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return isExist;
	}
	
}














