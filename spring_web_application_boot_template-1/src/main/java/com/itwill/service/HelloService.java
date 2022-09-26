package com.itwill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.repository.HelloDao;

@Service
public class HelloService {
	@Autowired
	private HelloDao helloDao;
	
	public void main() {
		System.out.println(">>>>HelloDao:"+helloDao);
		helloDao.main();
	}
	
}