package com.itwill.hello.controller;

import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.hello.Hello;
import com.itwill.hello.HelloService;

public class HelloController implements Controller {
	/*
	 * Service객체를 멤버필드로 가짐
	 */
	private HelloService helloService;

	public HelloController() {
		// [mvc-config] - BeanFactory에 등록되어야한다.
		System.out.println("4.#### HelloController 기본생성자");
	}
	
	public void setHelloService(HelloService helloService) {
		System.out.println("5.#### HelloController.setHelloService("+helloService+") 메소드호출");
		this.helloService = helloService;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("A.### HelloController.handleRequest() 메쏘드호출");
		
		List<Hello> helloList=
		helloService.helloList();
		
		request.setAttribute("helloList", helloList);
		
		String forwardPath="forward:/WEB-INF/views/hello.jsp";
		ModelAndView mv = new ModelAndView();
		mv.setViewName(forwardPath);
		
		return mv;
	}

}
