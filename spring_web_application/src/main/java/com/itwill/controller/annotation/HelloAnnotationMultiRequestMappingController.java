package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationMultiRequestMappingController {
	public HelloAnnotationMultiRequestMappingController() {
		System.out.println("### HelloAnnotationController3() 생성자 호출");
	}
	@RequestMapping(value = "/hello3.do")
	public String hello3() {
		System.out.println("### HelloAnnotationMultiRequestMappingController.hello3() 메소드 호출");
		return "forward:/WEB-INF/views/hello3.jsp";
	}
	@RequestMapping(value = "/hello4.do")
	public String hello4() {
		System.out.println("### HelloAnnotationMultiRequestMappingController.hello4() 메소드 호출");
		return "forward:/WEB-INF/views/hello4.jsp";
	}
	@RequestMapping(value = "/hello5.do")
	public String hello5() {
		System.out.println("### HelloAnnotationMultiRequestMappingController.hello5() 메소드 호출");
		return "forward:/WEB-INF/views/hello5.jsp";
	}
	@RequestMapping("/hello_redirect_servlet.do")
	public String hello_redirect_servlet() {
		System.out.println("### HelloAnnotationMultiRequestMappingController.hello_redirect_servlet() 메소드 호출");
		return "redirect:hello_redirected_servlet.do";
	}
	@RequestMapping("/hello_redirected_servlet.do")
	public String hello_redirected_servlet() {
		System.out.println("### HelloAnnotationMultiRequestMappingController.hello_redirect_servlet() 메소드 호출");
		return "forward:/WEB-INF/views/hello_redirected_servlet.jsp";
	}

	@RequestMapping("/hello_servlet_forward")
	public String hello_servlet_forward() {
		return "forward:hello_servlet_forwarded.do";
	}
	@RequestMapping("/hello_servlet_forwarded")
	public String hello_servlet_forwarded() {
		return "forward:/WEB-INF/views/hello_servlet_forwarded.jsp";
	}
	
	
}
