package com.itwill.user;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface UserService{
	@Transactional
	public int create(User user) throws Exception;
	public int update(User user)throws Exception;
	public int remove(String userId)throws Exception;
	public User findUser(String userId)	throws Exception;
	public List<User> findUserList()throws Exception;
	public int login(String userId, String password)throws Exception;
}