package com.itwill.guest.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/guest_detail_json",produces = "application/json;charset=UTF-8")
	public Map guest_detail(@RequestParam(required = true, defaultValue = "") String guest_no) {
		Map resultMap = new HashMap();
		
		int code = 1;
		String url = "";
		String msg = "";
		Guest guest = null;
		
		if (guest_no == null || guest_no.equals("")){
			code = 2;
			url = "";
			msg = "잘못된요청방식입니다.";
		}else{
			try {
				guest = guestService.selectByNo(Integer.parseInt(guest_no));
				code=1;
				url="guest_detail";
				msg="성공";
			} catch (Exception e) {
				code=2;
				url="guest_main";
				msg="실패";
				e.printStackTrace();
			}    
		}
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", guest);
		//System.out.println(resultMap);
		return resultMap;
	}
	/*
	@RequestMapping(value = "/guest_write_action_json",produces = "text/plain;charset=UTF-8",method = RequestMethod.POST)
	public String guest_write_action(@ModelAttribute Guest guest, Model model) {
		String forwardPath = "";
		try {
			int insertRowCount = guestService.insertGuest(guest);
			forwardPath = "guest_list";
			model.addAttribute("MSG", "여기서 model은 어떻게 쓸까??");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("MSG", "잘모르는실패!!!");
			forwardPath = "guest_error";
		}
		return forwardPath;
	}
	*/
	/*
	@RequestMapping(value = "/guest_write_action_json",produces = "application/json;charset=UTF-8",method = RequestMethod.GET)
	public Map guest_write_action() {
		Map resultMap = new HashMap();
		int code=2;
		String url="guest_main_content";
		String msg="잘못된요청방식입니다.";
		//System.out.println(resultMap);
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", "");
		return resultMap;
	}
	*/
	@RequestMapping(value = "/guest_write_action_json",produces = "application/json;charset=UTF-8",method = RequestMethod.POST)
	public Map guest_write_action(@ModelAttribute Guest guest) {
		Map resultMap = new HashMap();
		int code = 0;
		String url = "";
		String msg = "";
		
		try {
			int insertRowCount = guestService.insertGuest(guest);
			code=1;
			url="guest_list";
			msg="쓰기성공";
		} catch (Exception e) {
			e.printStackTrace();
			code=2;
			url="guest_main";
			msg="쓰기실패";
		}
		//System.out.println(resultMap);
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", "");
		return resultMap;
	}

	
	
	@RequestMapping(value = "/guest_modify_form_json",produces = "application/json;charset=UTF-8")
	public Map guest_modify_form(@RequestParam(required = true, defaultValue = "") String guest_no) {
		Map resultMap = new HashMap();
		
		int code = 0;
		String url = "";
		String msg = "";
		Guest guest = null;
		if (guest_no == null || guest_no.equals("")){
			code=2;
			url="guest_list";
			msg="guest_no 파라메타가존재하지 않습니다";
		}else{
			try {
				guest = guestService.selectByNo(Integer.parseInt(guest_no));
				code=1;
				url="guest_modify_form";
				msg="성공";
			} catch (Exception e) {
				e.printStackTrace();
				code=2;
				url="guest_main";
				msg="RestController_error";
			}
		}
		System.out.println(resultMap);
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", guest);
		return resultMap;
	}
	@RequestMapping(value = "/guest_modify_action_json",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public Map guest_modify_action(@ModelAttribute Guest guest) {
		Map resultMap = new HashMap();
		int code = 0;
		String url = "";
		String msg = "";
		Guest updateGuest = null;
		
		try {
			int rowCount= guestService.updateGuest(guest);
			updateGuest=guestService.selectByNo(guest.getGuest_no());
			code=1;
			url="guest_view_content";
			msg="성공";
		} catch (Exception e) {
			e.printStackTrace();
			code=2;
			url="guest_main";
			msg="RestController_error";
		}
		
		System.out.println(resultMap);
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", updateGuest);
		return resultMap;
	}
	@RequestMapping(value = "/guest_remove_action_json",produces = "application/json;charset=UTF-8", method = RequestMethod.POST)
	public Map guest_remove_action(@RequestParam String guest_no) {
		Map resultMap = new HashMap();
		int code = 0;
		String url = "";
		String msg = "";
		try {
			int rowCount=guestService.deleteGuest(Integer.parseInt(guest_no));
			code=1;
			url="guest_list_content";
			msg="삭제성공";
			System.out.println("###"+msg);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			code=2;
			url="guest_main";
			msg="RestController_error";
		} catch (Exception e) {
			e.printStackTrace();
			code=2;
			url="guest_main";
			msg="RestController_error";
		}
		
		System.out.println(resultMap);
		resultMap.put("code", code);
		resultMap.put("url", url);
		resultMap.put("msg", msg);
		resultMap.put("data", "");
		return resultMap;
	}
	/*
	 * GET방식
	 */
	//guest_spring_jquery_ajax_get_json

	
}

