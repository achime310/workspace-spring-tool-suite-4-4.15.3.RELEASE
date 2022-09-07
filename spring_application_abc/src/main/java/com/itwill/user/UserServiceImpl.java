package com.itwill.user;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service(value = "userService")
@Scope(value = "prototype")
public class UserServiceImpl implements UserService {
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("#### UserServiceImpl() : 디폴트생성자호출");
	}
	@Autowired
	public UserServiceImpl(@Qualifier(value = "userDao") UserDao userDao ) {
		System.out.println("#### UserServiceImpl("+userDao+") : 생성자호출");
	}
	@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("#### UserServiceImpl : setUserDao("+userDao+") 호출");
		this.userDao = userDao;
	}
	
	public int create(User user) throws Exception {
		System.out.println("#### UserServiceImpl : create() 호출");
		
		Thread.sleep(1234);
		
		return 0;
	}
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : findUser() 호출");
		return null;
	}
	public int login(String userId, String password) throws Exception {
		System.out.println("#### UserServiceImpl : login() 호출");
		return 0;
	}
	public int update(User user) throws Exception {
		System.out.println("#### UserServiceImpl : update() 호출");
		if(true) {
			throw new Exception("회원수정시 예외발생!!!!");
		}
		
		return 0;
	}
	public int remove(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : remove() 호출");
		return 0;
	}
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImpl : findUserList() 호출  ");
		return null;
	}
}
