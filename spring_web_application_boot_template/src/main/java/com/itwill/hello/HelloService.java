package com.itwill.hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	@Autowired
	private HelloDao helloDao;
	
	public List<String> hello() throws Exception {
		return helloDao.hello();
	}
}
