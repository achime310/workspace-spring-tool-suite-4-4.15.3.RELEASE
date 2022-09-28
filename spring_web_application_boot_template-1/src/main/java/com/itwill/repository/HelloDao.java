package com.itwill.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {
	@Autowired
	private HelloMapper helloMapper;
	public void main() {
		System.out.println(">>>HelloMapper:"+helloMapper);
	}
	
}