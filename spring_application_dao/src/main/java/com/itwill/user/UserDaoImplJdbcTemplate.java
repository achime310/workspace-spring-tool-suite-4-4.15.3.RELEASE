package com.itwill.user;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImplJdbcTemplate implements UserDao{
	
	private JdbcTemplate jdbcTemplate;

	public UserDaoImplJdbcTemplate() {
		System.out.println("#### UserDaoImplJdbcTemplate() 기본생성자");
	}
	public UserDaoImplJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### UserDaoImplJdbcTemplate("+jdbcTemplate+") 생성자");
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### UserDaoImplJdbcTemplate: setJdbcTemplate("+jdbcTemplate+") 메소드 호출");
		this.jdbcTemplate = jdbcTemplate;
	}
	@Override
	public int create(User user) throws Exception {
		// "insert into userinfo(userid,password,name,email) values(?,?,?,?)";
		return jdbcTemplate.update(UserSQL.USER_INSERT,user.getUserId(), user.getPassword(),user.getName(),user.getEmail());
	}

	@Override
	public int update(User user) throws Exception {
		// "update  userinfo set password=?,name=?,email=? where userid=?";
		return jdbcTemplate.update(UserSQL.USER_UPDATE,user.getPassword(),user.getName(),user.getEmail(),user.getUserId());
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return jdbcTemplate.update(UserSQL.USER_REMOVE,new Object[] {userId});
	}

	@Override
	public User findUser(String userId) throws Exception {
		return jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID,
											new Object[] {userId},
											new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public List<User> findUserList() throws Exception {
		
		//List<User> userList = jdbcTemplate.query(UserSQL.USER_SELECT_ALL,new BeanPropertyRowMapper<User>(User.class));
		//return userList;
		
		return jdbcTemplate.query(UserSQL.USER_SELECT_ALL, new BeanPropertyRowMapper<User>(User.class));
		
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		
		boolean isExist = false;
		
		int count = 
		jdbcTemplate.queryForObject(UserSQL.USER_SELECT_BY_ID_COUNT, new Object[] {userId}, Integer.class);
		//"select count(*) cnt from userinfo where userid=?";
		
		
		if (count == 1) {
			isExist = true;
		}
		
		return isExist;
	}

}