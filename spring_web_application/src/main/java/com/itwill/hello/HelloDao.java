package com.itwill.hello;

import java.util.ArrayList;
import java.util.List;

public class HelloDao {

	
	public HelloDao() {
		System.out.println("1.### HelloDao()생성자");
	}
	
	public List<Hello> helloList(){
		System.out.println("C.### HelloDao.helloList()메소드호출");
		List<Hello> helloList=new ArrayList<Hello>();
		helloList.add(new Hello("안녕"));
		helloList.add(new Hello("Hello"));
		helloList.add(new Hello("Bonjour"));
		helloList.add(new Hello("Hola"));
		return helloList;
	}
	
}
