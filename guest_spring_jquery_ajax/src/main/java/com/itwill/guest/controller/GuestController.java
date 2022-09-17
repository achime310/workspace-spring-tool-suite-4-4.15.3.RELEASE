package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;


@Controller
public class GuestController {
	@Autowired
	private GuestService guestService;
	@RequestMapping(value = "/guest_write_action", method = RequestMethod.GET)
	public String guest_write_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	@RequestMapping(value = "/guest_write_action", method = RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest, Model model) {
		String forwardPath = "";
		try {
			int insertRowCount = guestService.insertGuest(guest);
			forwardPath = "redirect:guest_list";
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "/guest_error";
		}
		return forwardPath;
	}

}
