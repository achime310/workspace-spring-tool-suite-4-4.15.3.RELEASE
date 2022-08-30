package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itwill.exception.BusinessException1;
import com.itwill.exception.BusinessException2;

@Controller
public class LocalExceptionController {
	@RequestMapping("/business1.do")
	public String business_method1() throws BusinessException1 {
		boolean b = true;
		if (b) {
			throw new BusinessException1("업무예외1 발생");
		}
		return "forward:/WEB-INF/views/business_result1.jsp";
	}
	@RequestMapping("/business2.do")
	public String business_method2() throws BusinessException2 {
		boolean b = true;
		if (b) {
			throw new BusinessException2("업무예외1 발생");
		}
		return "forward:/WEB-INF/views/business_result2.jsp";
	}
	@RequestMapping("/business3.do")
	public String business_method3()  {
		String name=null;
		int length=name.length();
		return "forward:/WEB-INF/views/business_result3.jsp";
	}

	/* ########## @ExceptionHandler ########## */
	
	/* 공통Exception은 따로 처리
	@ExceptionHandler(NullPointerException.class)
	public String handle_business_exception3(NullPointerException e) {
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	*/
	
	
	//BusinessException1.class가 생성되면 아래의 메소드 실행
	@ExceptionHandler(BusinessException1.class)
	public String handle_business_exception1(BusinessException1 e) {
		
		return "forward:/WEB-INF/views/business_error_result.jsp";
	}
	@ExceptionHandler(BusinessException2.class)
	public ModelAndView handle_business_exception2(BusinessException2 e) {
		/*
		e(Exception객체)를 사용할때, request,map,mapmodel등등을 적어봤자, 전달이 안된다.
			-> 이때, modelAndView를 사용한다
		*/
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("error_msg",e.getMessage());
		modelAndView.setViewName("forward:/WEB-INF/views/business_result.jsp");
		return modelAndView;
	}

}
