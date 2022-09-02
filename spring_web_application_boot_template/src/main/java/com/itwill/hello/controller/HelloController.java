package com.itwill.hello.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.hello.HelloService;

@Controller
public class HelloController {
	@Autowired
	private HelloService helloService;
	@RequestMapping("/hello")
	public String hello(Model model) throws Exception {
		List<String> helloList=helloService.hello();
		model.addAttribute("helloList",helloList);
		return "forward:hello";
	}
}
