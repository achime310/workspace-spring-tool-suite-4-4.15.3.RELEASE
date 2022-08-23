package com.itwill.user;

public class UserDaoMyBatisTestMain {

	public static void main(String[] args) throws Exception {
		UserDaoMyBatis userDaoMyBatis=new UserDaoMyBatis();
		
		System.out.println("------findUserList-----------");
		System.out.println(userDaoMyBatis.findUserList());
		System.out.println("------findUser-----------");
		System.out.println(userDaoMyBatis.findUser("guard2"));
		System.out.println("------create(insert)-----------");
		User user = new User("id11", "pw", "이름", "이메일");
		System.out.println(userDaoMyBatis.create(user));
		System.out.println("------update-----------");
		user = new User("id2", "update", "업데이트", "업뎃@이트.com");
		System.out.println(userDaoMyBatis.update(user));
		System.out.println("------remove(delete)-----------");
		System.out.println(userDaoMyBatis.remove("id3"));
		System.out.println("------existedUser-----------");
		System.out.println(userDaoMyBatis.existedUser("id3"));
	}

}
