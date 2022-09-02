package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
@Service(value = "userService")
@Scope(value = "prototype")	//요청할때마다
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;

	public UserServiceImpl() {
		System.out.println("#### UserServiceImpl() : 디폴트생성자호출");
	}
	@Autowired
	public UserServiceImpl(@Qualifier(value = "userDao") UserDao userDao) {
		System.out.println("#### UserServiceImpl("+userDao+") : 생성자호출");
		this.userDao = userDao;
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("  #### UserServiceImpl : setUserDao("+userDao+") 호출");
		this.userDao = userDao;
	}

	public int create(User user) throws Exception {
		System.out.println("#### UserServiceImpl : create() 호출");
		Thread.sleep(1234);
		/*
		 * -1:아이디중복
		 *  1:회원가입성공
		 */
		//1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			System.out.println("#### UserServiceImpl : create() >>> existedUser() 호출");
			//아이디중복
			return -1;
		}else {
			//아이디안중복
			//2.회원가입
			int insertRowCount=userDao.create(user);
			return insertRowCount;
		}
		
	}

	/*
	 * User 상세보기
	 */
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : findUser() 호출");
		return userDao.findUser(userId);
	}

	/*
	 * 로그인
	 */
	public int login(String userId, String password) throws Exception {
		/*
		 * 회원로그인
		 *  0:아이디존재안함
		 * 	1:패쓰워드 불일치
		 * 	2:로그인성공(세션)
		 */
		System.out.println("#### UserServiceImpl : login() 호출");
		int result=-1;
		//1.아이디존재여부
		User user=userDao.findUser(userId);
		if(user==null) {
			//아이디존재안함
			result=0;
		}else {
			//아이디존재함
			if(user.isMatchPassword(password)) {
				//패쓰워드일치
				result=2;
			}else {
				//패스워드 불일치
				result=1;
			}
		}
		return result;
	}

	public int update(User user) throws Exception {
		System.out.println("#### UserServiceImpl : update() 호출");
		
		if (true) {
			throw new Exception("회원수정시 예외발생!!!");
		}
		
		return userDao.update(user);
	}

	public int remove(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : remove() 호출");
		return userDao.remove(userId);
	}

	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImpl : findUserList() 호출  ");
		return userDao.findUserList();
		//return null;
	}

}
