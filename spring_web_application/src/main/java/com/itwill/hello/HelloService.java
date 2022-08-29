package com.itwill.hello;

import java.util.List;

public class HelloService {

	private HelloDao helloDao;
	
	public HelloService() {
		System.out.println("2. ### HelloService() 생성자");
	}
	
	public void setHelloDao(HelloDao helloDao) {
		System.out.println("3. ### HelloService.setHelloDao("+helloDao+") 메소드 호출");
		this.helloDao = helloDao;
	}
	
	public List<Hello> helloList() {
		System.out.println("B. ### HelloService.helloList() 메소드 호출");
		return helloDao.helloList();
	}
	
}
