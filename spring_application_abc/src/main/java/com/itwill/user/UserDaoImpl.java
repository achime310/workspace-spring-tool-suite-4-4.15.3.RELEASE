package com.itwill.user;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "userDao")
public class UserDaoImpl implements UserDao {
	
	private DataSource dataSource;
	
	public UserDaoImpl() {
		System.out.println("#### UserDaoImpl() : 디폴트생성자 호출  ");
	}
	@Autowired
	public UserDaoImpl(@Qualifier(value = "dataSource") DataSource dataSource) {
		System.out.println("#### UserDaoImpl("+dataSource+") : 생성자 호출  ");
		this.dataSource=dataSource;
	}
	

	@Autowired
	public void setDataSource(DataSource dataSource) {
		System.out.println("#### UserDaoImpl : setDataSource("+dataSource+") 호출  ");
		this.dataSource = dataSource;
	}



	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImpl : create() 호출  ");
		return 0;
	}

	
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImpl : update() 호출  ");
		return 0;
	}

	
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : remove() 호출  ");
		return 0;
	}
	
	
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImpl : findUser() 호출  ");
		return null;
	}
	
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImpl : findUserList 호출  ");
		return null;
	}
	
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImpl : existedUser() 호출  ");
		return true;
	}
	
}














