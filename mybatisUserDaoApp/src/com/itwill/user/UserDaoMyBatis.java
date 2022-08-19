package com.itwill.user;


import java.util.List;


public class UserDaoMyBatis {
	
	

	public UserDaoMyBatis() throws Exception {
		

	}

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	public int create(User user) throws Exception {
		
		int insertRowCount = 0;
		
		return insertRowCount;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	public int update(User user) throws Exception {
		
		int updateRowCount = 0;
		
		return updateRowCount;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	public int remove(String userId) throws Exception {
		
		int removeRowCount = 0;
		
		return removeRowCount;
	}

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서 User 도메인클래스에 저장하여 반환
	 */
	public User findUser(String userId) throws Exception {
		
		User findUser = null;
		
		return findUser;
	}

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 List<User> 콜렉션 에 저장하여 반환
	 */
	public List<User> findUserList() throws Exception {
		List<User> findUserList =null;
		return findUserList;
	}

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	public boolean existedUser(String userId) throws Exception {
		boolean isExist = false;
		return isExist;
	}

}
