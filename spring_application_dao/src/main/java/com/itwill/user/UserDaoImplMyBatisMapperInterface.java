package com.itwill.user;

import java.util.List;



import com.itwill.user.mapper.UserMapper;

public class UserDaoImplMyBatisMapperInterface implements UserDao {
	private UserMapper userMapper;

	public UserDaoImplMyBatisMapperInterface() {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : 디폴트생성자 호출  ");
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : create() 호출  ");

		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : update() 호출  ");

		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : remove() 호출  ");

		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUser() 호출  ");

		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUserList 호출  ");

		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : existedUser 호출  ");

		return true;
	}

}