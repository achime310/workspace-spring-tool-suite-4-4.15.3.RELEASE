package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.GuestService;

public class GuestMainController implements Controller{
	public GuestMainController() {
		System.out.println("### GuestMainController()생성자 호출");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="forward:/WEB-INF/views/guest_main.jsp";
		ModelAndView mv=new ModelAndView(forwardPath);
		return mv;
	}

}
