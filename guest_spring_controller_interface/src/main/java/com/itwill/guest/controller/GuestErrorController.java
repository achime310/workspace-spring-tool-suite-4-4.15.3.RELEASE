package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class GuestErrorController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		ModelAndView mv=new ModelAndView(forwardPath);
		return mv;
	}


}
