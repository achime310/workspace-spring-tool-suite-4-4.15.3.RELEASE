package com.itwill.guest;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class GuestDaoImplJdbcTemplate implements GuestDao{
	
	private JdbcTemplate jdbcTemplate;

	public GuestDaoImplJdbcTemplate() {
		System.out.println("#### GuestDaoImplJdbcTemplate() 기본생성자");
	}
	
	public GuestDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### GuestDaoImplJdbcTemplate("+jdbcTemplate+") 생성자");
		this.jdbcTemplate = jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### GuestDaoImplJdbcTemplate: setJdbcTemplate("+jdbcTemplate+") 메소드 호출");
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, 
									new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, 
											new Object[] {no}, 
											new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		//="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT,guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content());
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		//"update guest set  guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,guest.getGuest_name(),guest.getGuest_email(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content(),guest.getGuest_no());
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		//="delete from guest where guest_no=?";
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,new Object[] {no});
	}

}
