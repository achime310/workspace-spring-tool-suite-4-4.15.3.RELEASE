package com.itwill.controller.annotation;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SpringModelController {
	@RequestMapping("/model_request.do")
	public String request(HttpServletRequest request) {
		request.setAttribute("req", "리퀘스트 데이타");
		return "forward:WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_model.do")
	public String model(Model model) {
		model.addAttribute("model","모델데이타");
		/*
			request.setAttribute("model","모델데이타");
			-> model에도 있고, request에도 있게됨
		 */
		
		return "forward:WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_map.do")
	public String model(Map map) {
		map.put("map", "맵데이타");
		/*
			request.setAttribute("map", "맵데이타");
			-> model에도 있고, request에도 있게됨
		 */
		
		return "forward:WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelmap.do")
	public String model(ModelMap modelMap) {
		modelMap.put("modelmap", "맵데이타");
		/*
			request.setAttribute("map", "맵데이타");
			-> model에도 있고, request에도 있게됨
		 */
		
		return "forward:WEB-INF/views/spring_model.jsp";
	}
	@RequestMapping("/model_modelandview.do")
	public ModelAndView	modelandview() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("modelandview","모델앤뷰데이타");
		/*
		 request.setAttribute("modelandview","모델앤뷰데이타");
		 */
		modelAndView.setViewName("forward:WEB-INF/views/spring_model.jsp");
		//내가생성해서 반환하는 유일한 객체가 modelAndView
		
		return modelAndView;
	}
	@RequestMapping("/model_all.do")
	public String model_all(HttpServletRequest request, Model model, Map map, ModelMap modelMap) {
		request.setAttribute("req", "리퀘스트데이타");
		model.addAttribute("model","모델데이타");
		map.put("map", "맵데이타");
		modelMap.addAttribute("modelmap","모델맵데이타");
		return "forward:WEB-INF/views/spring_model.jsp";
	}
	
	
}
