package com.itwill.tomorrowHome.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itwill.tomorrowHome.controller.interceptor.LoginCheck;
import com.itwill.tomorrowHome.domain.Order;
import com.itwill.tomorrowHome.service.OrderService;

@RestController
public class OrderRestController {
	@Autowired
	private OrderService orderService;

	/*
	 * 주문리스트
	 */
	@RequestMapping(value = "order_list_count_rest", produces = "application/json;charset=UTF-8")
	public List<Order> order_list_count(@RequestParam int o_no, HttpSession session) throws Exception {
		String sM_id = (String) session.getAttribute("sM_id");
		List<Order> orderList = orderService.list(sM_id);
		return orderList;
	}

	/*
	 * 주문상세 
	 */
	@RequestMapping(value = "order_detail_rest", produces = "application/json;charset=UTF-8")
	public Map<String, Object> order_detail_rest(@RequestParam Integer o_no) {
		Map<String, Object> resultMap = new HashMap<>();
		if (o_no == null) {
			resultMap.put("errorCode", -1);
			resultMap.put("errorMsg", "잘못된 접근입니다");
		}
		try {
			Order order = orderService.detail(o_no);
			resultMap.put("errorCode", 1);
			resultMap.put("errorMsg", "성공");
			resultMap.put("data", order);
		} catch (Exception e) {
			e.printStackTrace();
			resultMap.put("errorCode", -2);
			resultMap.put("errorMsg", "관리자에게 문의하세요");
		}
		return resultMap;
	}

	/*
	 * 주문 1개 삭제
	 */
	@LoginCheck
	@PostMapping(value = "order_item_delete_action_rest", produces = "application/json;charset=UTF-8")
	public Map order_item_delete_action_rest(@RequestParam int o_no, HttpSession session) throws Exception {
		orderService.deleteByOrderNo(o_no);
		String sM_id = (String) session.getAttribute("sM_id");
		List<Order> orderList = orderService.list(sM_id);
		int order_count = orderList.size();

		Map map = new HashMap();
		map.put("rempve_order_no", o_no);
		map.put("order_count", order_count);
		return map;
	}

	/*
	 * 주문전체삭제
	 */
	@LoginCheck
	@PostMapping(value = "order_all_delete_action_rest", produces = "application/json;charset=UTF-8")
	public Map order_all_delete_action_rest(HttpSession session) throws Exception {
		String sM_id = (String) session.getAttribute("sM_id");
		orderService.delete(sM_id);
		List<Order> orderList = orderService.list(sM_id);
		int order_count = orderList.size();

		Map map = new HashMap();
		map.put("remove_order_no", -1);
		map.put("order_count", order_count);
		return map;
	}
}
