package com.itwill.user;

public class UserDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception {
		UserDaoMyBatis userDaoMyBatis=new UserDaoMyBatis();
		System.out.println("------findUserList-----------");
		userDaoMyBatis.findUserList();

	}

}
