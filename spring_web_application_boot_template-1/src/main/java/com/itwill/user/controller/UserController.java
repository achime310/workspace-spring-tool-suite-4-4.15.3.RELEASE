package com.itwill.user.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.Address;
import com.itwill.user.User;
import com.itwill.user.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		System.out
				.println("user_write_form 컨트롤러 호출-userService: " + userService);
		return "user_write_form";
	}

	@RequestMapping(value = "/user_write_action", method = RequestMethod.POST)
	public String user_write_action_post(@ModelAttribute(value = "fuser") User user, Model model)
			throws Exception {
		System.out.println(
				"user_write_action 컨트롤러 호출-userService: " + userService);
		String forward_path = "";
		/*
		 * -1:아이디중복 1:회원가입성공
		 */

		//user = new User("TEST1", "1111", "김당근", "carrot1@brown.com","010-1111-1111", 36.5, 0, "image.jpg", null);
		System.out.println(user);
		int result = userService.create(user);
		System.out.println(result);
		if (result == -1) {
			model.addAttribute("msg",
					user.getUser_id() + " 는 이미 존재하는 아이디 입니다.");
			model.addAttribute("fuser", user);
			forward_path = "user_write_form";
		} else if (result == 1) {
			forward_path = "redirect:user_main";
		}
		return forward_path;
	}

	@RequestMapping("/user_login_form")
	public String user_login_form() {
		return "user_login_form";
	}

	@RequestMapping(value = "/user_login_action", method = RequestMethod.POST)
	public String user_login_action_post(
			@ModelAttribute(value = "fuser") User user,
			HttpServletRequest request) throws Exception {
		String forwardPath = "";

		int result = userService.login(user.getUser_id(), user.getUser_pw());
		/*
		 * 회원로그인 0:아이디존재안함 1:패쓰워드 불일치 2:로그인성공(세션)
		 */
		switch (result) {
			case 0 :
				request.setAttribute("msg1",
						user.getUser_id() + " 는 존재하지않는 아이디 입니다.");
				forwardPath = "user_login_form";
				break;
			case 1 :
				request.setAttribute("msg2", "패쓰워드가 일치하지 않습니다.");
				forwardPath = "user_login_form";
				break;
			case 2 :
				request.getSession().setAttribute("sUserId", user.getUser_id());
				forwardPath = "redirect:user_main";
				break;
		}
		return forwardPath;
	}

	@RequestMapping(value = {"/user_modify_form",
							 "/user_login_action",
							 "/user_write_action",
							 "/user_modify_action",
							 "/user_remove_action"},
					method = RequestMethod.GET)
	public String user_action_get() {
	return "redirect:user_main";
	}

	@ExceptionHandler(Exception.class)
	public String handle_exception(Exception e) {
		return "user_error";
	}

}