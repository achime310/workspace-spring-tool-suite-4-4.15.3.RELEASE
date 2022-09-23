package com.itwill.tomorrowHome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.tomorrowHome.controller.interceptor.LoginCheck;
import com.itwill.tomorrowHome.domain.Cart;
import com.itwill.tomorrowHome.service.CartService;

@Controller
public class CartController {
	@Autowired
	private CartService cartService;

	@LoginCheck
	@RequestMapping("/cart_view")
	public String cart_view(HttpServletRequest request, HttpSession session) {
		String sM_Id = (String) session.getAttribute("sM_id");
		try {
			List<Cart> cartList = cartService.cartListAll(sM_Id);
			request.setAttribute("cartList", cartList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "cart";
	}
	
	@RequestMapping(value = {"cart_update_qty"})
	public String cart_update_qty(HttpServletRequest request,@RequestParam int c_no,@RequestParam int c_qty){
		String sM_id = (String) request.getSession().getAttribute("sM_id");
		try {
			cartService.updateQty(c_no, c_qty);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "cart";
	}
	// 카트아이템 1개삭제
	@PostMapping(value = "cart_remove_action")
	public String cart_remove_action_rest() throws Exception {
		return "";
	}

	// 카트 전체 삭제
	@PostMapping(value = "cart_delete_all_item_action")
	public String cart_remove_all_action() throws Exception {
		return "";
	}

	

	/*
	 * 카트 추가
	 */
	@LoginCheck
	@RequestMapping("/add_cart")
	public String add_cart() {
		return "";
	}
}
