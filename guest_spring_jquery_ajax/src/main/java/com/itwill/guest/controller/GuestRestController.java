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


@RestController
public class GuestRestController {
	@Autowired
	private GuestService guestService;
	
	@RequestMapping(value = "/guest_list_json",produces = "application/json;charset=UTF-8")
	public Map guest_list() {
		Map resultMap = new HashMap();

		int code=1;
		String url="";
		String msg="";
		List<Guest> resultList = new ArrayList<Guest>();
		try {
			List<Guest> guestList = guestService.selectAll();
			code=1;
			url="guest_list";
			msg="성공";
			resultList=guestList;
		} catch (Exception e) {
			code=2;
			url="guest_main";
			msg="실패";
			e.printStackTrace();
		}
		//최종적으로는 아래의 data를 뿌려야한다. exception날리면 안됨.
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", resultList);
		
		return resultMap;
	}

}
