package com.itwill.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserDaoImplMyBatis implements UserDao{

	private SqlSession sqlSession;
	
	public static final String NAMESPACE="com.itwill.user.mapper.UserMapper.";
	
	public UserDaoImplMyBatis() {
		System.out.println("#### UserDaoImplMyBatis() 기본생성자");
	}

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis : setSqlSession("+sqlSession+") 메소드 호출");
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(User user) throws Exception {
		return sqlSession.insert(NAMESPACE + "create", user);
	}

	@Override
	public int update(User user) throws Exception {
		return sqlSession.update(NAMESPACE + "update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		return sqlSession.delete(NAMESPACE + "remove", userId);
	}

	@Override
	public User findUser(String userId) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "findUser", userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		return sqlSession.selectList(NAMESPACE + "findUserList");
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		int rowCount = sqlSession.selectOne(NAMESPACE + "existedUser", userId);
		if (rowCount > 0) {
			return true;
		}else {
			return false;
		}
	}

}
