package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository(value = "guestDao")
@Scope(value = "singleton")
public class GuestDaoImpl implements GuestDao {
	private DataSource dataSource;
	
	public GuestDaoImpl() {
		System.out.println("2.#### GuestDaoImpl() 기본생성자호출");
	}
	
	@Autowired
	public GuestDaoImpl(@Qualifier(value = "dataSource") DataSource dataSource) {
		System.out.println("2.#### GuestDaoImpl("+dataSource+") 생성자호출");
		this.dataSource = dataSource;
	}


	@Autowired
	@Qualifier(value = "dataSource")
	public void setDataSource(DataSource dataSource) {
		System.out.println("  #### GuestDaoImpl : setDataSource("+dataSource+") 호출");
		this.dataSource = dataSource;
	}

	@Override
	public List<Guest> selectAll()
			throws Exception{
		System.out.println("#### GuestDaoImpl : selectAll() 호출");
		
	List<Guest> guestList = new ArrayList<Guest>();
		
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
		ResultSet rs = pstmt.executeQuery();
		//"select * from guest";
		while (rs.next()) {
			guestList.add(new Guest(rs.getInt("guest_no"),
									rs.getString("guest_name"),
									rs.getString("guest_date"),/*sql.date는 상위(util.date)로 자동캐스팅*/
									rs.getString("guest_email"),
									rs.getString("guest_homepage"),
									rs.getString("guest_title"),
									rs.getString("guest_content")));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return guestList;
	}
	
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestDaoImpl : selectByNo(int no) 호출");
		System.out.println("#### GuestDaoImpl : selectByNo(int no) 호출");
		Guest guest=null;
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
		pstmt.setInt(1, no);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()) {
			guest=new Guest(rs.getInt("guest_no"),
							rs.getString("guest_name"),
							rs.getString("guest_date"),
							rs.getString("guest_email"),
							rs.getString("guest_homepage"),
							rs.getString("guest_title"),
							rs.getString("guest_content"));
		}
		
		return guest;
	}
	@Override
	public int insertGuest(Guest guest)throws Exception {
		System.out.println("#### GuestDaoImpl : insertGuest(Guest guest) 호출");
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_INSERT);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		int rowCount=pstmt.executeUpdate();
		con.close();
		
		return rowCount;
	}
	@Override
	public int updateGuest(Guest guest)throws Exception {
		System.out.println("#### GuestDaoImpl : updateGuest(Guest guest) 호출");
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
		pstmt.setString(1, guest.getGuest_name());
		pstmt.setString(2, guest.getGuest_email());
		pstmt.setString(3, guest.getGuest_homepage());
		pstmt.setString(4, guest.getGuest_title());
		pstmt.setString(5, guest.getGuest_content());
		pstmt.setInt(6, guest.getGuest_no());
		int rowCount=pstmt.executeUpdate();
		con.close();
		
		return rowCount;
	}
	@Override
	public int deleteGuest(int no)throws Exception {
		System.out.println("#### GuestDaoImpl : deleteGuest(int no) 호출");
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
		pstmt.setInt(1, no);
		int rowCount=pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	
	
	
}
