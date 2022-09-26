package com.itwill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.service.HelloService;

@Controller
public class HelloBootController {
	@Autowired
	private HelloService helloService;
	
	public HelloBootController() {
		System.out.println(">> HelloControllerBoot생성");
	}
	@RequestMapping(value = "main")
	public String main() {
		System.out.println(">>>>>>>HelloService:"+helloService);
		helloService.main();
		return "main";
	}
	
}