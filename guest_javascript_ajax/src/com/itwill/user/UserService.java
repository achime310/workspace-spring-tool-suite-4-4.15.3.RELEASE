package com.itwill.user;

/*
 * - 회원관리 업무(비즈니스로직,예외처리,트랜젝션,보안,로깅)을 수행하는 클래스
 * - 웹컴포넌트(서블릿,JSP)에서 직접접근(메쏘드호출)하는 클래스(객체)
 * - Dao를 이용해서 데이타베이스를 조작작업(CRUD)하는 클래스
 */
public class UserService {
	private UserDao userDao;

	// jsp에서 Exception처리
	public UserService() throws Exception {
		userDao = new UserDao();
	}

	/*
	 * 회원가입 -> 요구사항명세표에서 확인가능한 서비스
	 */
	public int create(User user) throws Exception {
		/*
		 * -1: 아이디중복
		 *  1: 회원가입성공
		 */
		// 1.아이디중복체크
		if(userDao.existedUser(user.getUserId())) {
			//아이디 중복
			return -1;
		}else {
			//아이디 중복X
			//2. 회원가입
			int insertRowCount = userDao.create(user);
			return insertRowCount;	//0또는 1이 반환
		}
	}
	
	/*
	 * 회원로그인
	 *   0:아이디존재안함
	 *   1:패쓰워드 불일치
	 *   2:로그인성공(세션)
	 */
	public int login(String userId, String password) throws Exception {
		int result =-1;
		//1.아이디존재여부
		User user = userDao.findUser(userId);
		if(user==null) {
			//아이디 존재 안함
			return 0;
		}else {
			//아이디 존재함
			//2.패스워드일치여부
			if(user.isMatchPassword(password)) {
				//패스워드 일치
				return 2;
			}else {
				//패스워드 불일치
				return 1;
			}
		}
	}
	
	/*
	 * 회원상세보기
	 */
	public User findUser(String userId) throws Exception {
		return userDao.findUser(userId);
	}
	/*
	 * 회원수정
	 */
	public int updateUser(User user) throws Exception {
		return userDao.update(user);
	}
	/*
	 * 회원탈퇴
	 */
	public int removeUser(String userId) throws Exception {
		return userDao.remove(userId);
	}

}
