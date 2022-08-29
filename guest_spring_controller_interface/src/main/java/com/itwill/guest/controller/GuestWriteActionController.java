package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	
	public GuestWriteActionController() {
		System.out.println("### GuestWriteActionController()생성자 호출");
	}

	public void setGuestService(GuestService guestService) {
		System.out.println("### GuestWriteActionController : setGuestService(" + guestService + ") 메쏘드 호출");
		this.guestService = guestService;
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				Guest guest=new Guest(0,
									  request.getParameter("guest_name"),
									  null,
									  request.getParameter("guest_email"),
									  request.getParameter("guest_homepage"),
									  request.getParameter("guest_title"),
									  request.getParameter("guest_content")
									  );
				int rowCount=guestService.insertGuest(guest);
				forwardPath="redirect:guest_list.do";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		ModelAndView mv=new ModelAndView(forwardPath);
		return mv;
	}

}
