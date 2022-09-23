package com.itwill.tomorrowHome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.tomorrowHome.controller.interceptor.LoginCheck;
import com.itwill.tomorrowHome.domain.Cart;
import com.itwill.tomorrowHome.domain.Member;
import com.itwill.tomorrowHome.service.CartService;
import com.itwill.tomorrowHome.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private CartService cartService;

	@RequestMapping("/login_form")
	public String login_form() {
		return "forward:/WEB-INF/views/login.jsp";
	}

	/*
	 * 회원가입
	 */
	@RequestMapping(value = "member_register_action")
	public String member_register_action(HttpServletRequest request) {
		String m_id = request.getParameter("m_id");
		String m_password = request.getParameter("m_password");
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		String m_address = request.getParameter("m_address");
		String m_post = request.getParameter("m_post");
		String m_phone = request.getParameter("m_phone");
		Member member = new Member(m_id, m_password, m_name, m_email, m_address, m_post, m_phone);
		try {
			int result = memberService.createMember(member);
			if (result == -1) {
				// result == -1이면 아이디 중복
				// 아이디 중복일 경우 정보 출력을 위해 member객체와 메세지를 request에 저장합니다
				request.setAttribute("fMember", member);
				request.setAttribute("r_msg", "이미 존재하는 ID입니다");
			} else if (result == 1) {
				// 가입 성공일 경우 성공메세지 저장
				request.setAttribute("r_msg", m_id + "님, 회원가입을 환영합니다 😃");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		// request에 저장된 데이터를 이용하기 위해 forward
		return "forward:/WEB-INF/views/login.jsp";
	}

	/*
	 * 멤버 로그인
	 */
	@RequestMapping(value = "member_login_action")
	public String member_login_action(HttpServletRequest request, HttpSession session) {
		String m_id = request.getParameter("id");
		String m_password = request.getParameter("password");
		String forwardPath = "forward:/WEB-INF/views/login.jsp";
		try {
			/*
			 * 1:성공 
			 * -1:비밀번호 불일치 
			 * -2:존재하지 않는 회원
			 */
			int result = memberService.loginMember(m_id, m_password);
			if (result == 1) {
				Member loginMember = memberService.findMember(m_id);
				session.setAttribute("sM_id", loginMember.getM_id()); 
				session.setAttribute("sMember", loginMember);
				forwardPath = "redirect:index";
			} else if (result == -1) {
				request.setAttribute("l_msg", "비밀번호가 일치하지 않습니다");
				request.setAttribute("l_id", m_id);
			} else if(result == -2) {
				request.setAttribute("l_msg", "존재하지 않는 ID입니다");
				request.setAttribute("l_id", m_id);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return forwardPath;
	}

	/*
	 * 회원정보 조회
	 */
	@LoginCheck
	@RequestMapping("/my_account")
	public String my_account(HttpSession session, Model model) {
		try {
			String sM_id = (String)session.getAttribute("sM_id");
			List<Cart> cartList = cartService.cartListAll(sM_id);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "forward:/WEB-INF/views/my-account.jsp";
	}

	@LoginCheck
	@RequestMapping("/account_details")
	public String account_details(HttpSession session, Model model) {
		try {
			String sM_id = (String)session.getAttribute("sM_id");
			List<Cart> cartList = cartService.cartListAll(sM_id);
			model.addAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "account-details";
	}

	/*
	 * 회원정보수정
	 */
	@LoginCheck
	@RequestMapping(value = "member_account_update_action")
	public String member_account_update_action(HttpServletRequest request,HttpSession session) {
		String sM_id=(String)session.getAttribute("sM_id");
		
		String m_name = request.getParameter("m_name");
		String m_email = request.getParameter("m_email");
		String m_address = request.getParameter("m_address");
		String m_post = request.getParameter("m_post");
		String m_phone = request.getParameter("m_phone"); 
		String m_password = request.getParameter("m_password"); 
		String new_password = request.getParameter("new_password"); 
		Member updateMember = new Member(sM_id,"",m_name, m_email, m_address, m_post, m_phone);
		if(new_password.equals("")) {
			updateMember.setM_password(m_password);
		}else {
			updateMember.setM_password(new_password);
		}
		System.out.println(updateMember);
		try {
			memberService.updateMember(updateMember);
			session.setAttribute("sMember", updateMember);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		System.out.println(m_name);
		return "redirect:account_details";
	}
	
	/*
	 * 회원 탈퇴
	 */
	@LoginCheck
	@RequestMapping(value = "member_account_delete_action")
	public String member_account_delete_action(HttpServletRequest request, HttpSession session) {
		String m_id= request.getParameter("m_id");
		try {
			memberService.deleteMember(m_id);
			session.invalidate();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "redirect:index";
	}

	/*
	 * 멤버 로그아웃
	 */
	@LoginCheck
	@RequestMapping("/member_logout")
	public String member_login_rest(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}

	
	
	
	/*
	 * 멤버 로그인 rest
	 */
	/*
	 * @ResponseBody
	 * 
	 * @PostMapping("/member_login_rest") public Map<String, Object>
	 * member_login_rest(HttpSession session, String id, String password) {
	 * Map<String, Object> resultMap = new HashMap<>(); try { int result =
	 * memberService.loginMember(id, password); if (result > 0) { Member loginMember
	 * = memberService.findMember(id); session.setAttribute("sM_id",
	 * loginMember.getM_id()); session.setAttribute("sMember", loginMember);
	 * resultMap.put("errorCode", 1); resultMap.put("errorMsg", "로그인 성공"); } else {
	 * if(result == -1) { resultMap.put("errorCode", -1); resultMap.put("errorMsg",
	 * "비밀번호가 일치하지 않습니다"); }else if(result == -2) { resultMap.put("errorCode", -2);
	 * resultMap.put("errorMsg", "존재하지 않는 ID입니다"); } } } catch (Exception e) {
	 * e.printStackTrace(); resultMap.put("errorCode", -3);
	 * resultMap.put("errorMsg", "관리자에게 문의하세요"); } return resultMap; }
	 */

}
