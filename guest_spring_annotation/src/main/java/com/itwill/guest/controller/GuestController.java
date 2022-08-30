package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

@Controller
public class GuestController {
	/*
	 * <<요청 url(command)>> 
	 * /guest_main 			---forward--->/WEB-INF/views/guest_main.jsp 
	 * /guest_list 			---forward--->/WEB-INF/views/guest_list.jsp 
	 * /guest_view 			---forward--->/WEB-INF/views/guest_view.jsp
	 * /guest_write_form 	---forward--->/WEB-INF/views/guest_write_form.jsp 
	 * /guest_write_action 	---forward--->/WEB-INF/views/guest_write_action.jsp 
	 * /guest_modify_form 	---forward--->/WEB-INF/views/guest_modify_form.jsp 
	 * /guest_modify_action ---forward--->/WEB-INF/views/guest_modify_action.jsp 
	 * /guest_remove_action ---forward--->/WEB-INF/views/guest_remove_action.jsp 
	 * /guest_error 		---forward--->/WEB-INF/views/guest_error.jsp
	 */
	@Autowired
	private GuestService guestService;
	
	public GuestController() {
		System.out.println("### GuestController() 생성자");
	}
	
	@RequestMapping("/guest_main")
	public String guest_main() {
		return "forward:/WEB-INF/views/guest_main.jsp";
	}
	
	@RequestMapping("/guest_list")
	public String guest_list(Model model) throws Exception {
		List<Guest> guestList = guestService.selectAll();
		model.addAttribute("guestList",guestList);
		return "forward:/WEB-INF/views/guest_list.jsp";
	}
	
	@RequestMapping("/guest_view")
	public String guest_view(@RequestParam String guest_no,
								Model model) throws Exception {
		Guest guest = guestService.selectByNo(Integer.parseInt(guest_no));
		model.addAttribute("guest", guest);
		//request.setAttribute("guest", guest);
		return "forward:/WEB-INF/views/guest_view.jsp";
	}
	
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	
	@RequestMapping(value = "/guest_write_action",
						method = RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest) throws Exception {
		guestService.insertGuest(guest);
		return "redirect:guest_list";
	}
	//guest_write_action()에 GET방식접근 -> guest_main으로 redirect 
	@RequestMapping(value = "/guest_write_action",
						method = RequestMethod.GET)
	public String guest_write_action(){
		return "redirect:guest_main";
	}
	
	@RequestMapping(value = "/guest_modify_form",
						method = RequestMethod.POST)
	public String guest_modify_form(@RequestParam String guest_no,
														Model model) throws Exception {
		Guest guest=
		guestService.selectByNo(Integer.parseInt(guest_no));
		model.addAttribute("guest",guest);
		return "forward:/WEB-INF/views/guest_modify_form.jsp";
	}
	//guest_modify_form()에 GET방식접근 -> guest_main으로 redirect 
	@RequestMapping(value = "/guest_modify_form",
						method = RequestMethod.GET)
	public String guest_modify_form(){
		return "redirect:guest_main";
	}
	
	@RequestMapping(value = "/guest_modify_action",
						method = RequestMethod.POST)
	public String guest_modify_action(@ModelAttribute Guest guest) throws Exception {
		guestService.updateGuest(guest);
		return "redirect:guest_view.do?guest_no="+guest.getGuest_no();
	}
	@RequestMapping(value = "/guest_modify_action",
						method = RequestMethod.GET)
	public String guest_modify_action() {
		return "redirect:guest_main";
	}
	
	@RequestMapping(value = "/guest_remove_action",
						method = RequestMethod.POST)
	public String guest_remove_action(@RequestParam String guest_no) throws Exception {
		guestService.deleteGuest(Integer.parseInt(guest_no));
		return "redirect:guest_list";
	}
	@RequestMapping(value = "/guest_remove_action",
			method = RequestMethod.GET)
	public String guest_remove_action()  {
		return "redirect:guest_main";
	}
	
	@RequestMapping("/guest_error")
	public String guest_error() {
		return "forward:/WEB-INF/views/guest_error.jsp";
	}
	
}