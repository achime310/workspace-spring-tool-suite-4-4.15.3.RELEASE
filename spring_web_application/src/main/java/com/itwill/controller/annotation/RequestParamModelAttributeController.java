package com.itwill.controller.annotation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.itwill.dto.Guest;

@Controller
public class RequestParamModelAttributeController {
	
	@RequestMapping(value = "parameter_guest_write_form.do")
	public String parameter_guest_write_form() {

		return "forward:/WEB-INF/views/guest_write_form.jsp";
	}
	@RequestMapping(value = "parameter_guest_write_action.do",method = RequestMethod.POST)
	public String parameter_guest_write_action(@RequestParam(value = "guest_name",defaultValue="aa",required = true) String name,
												@RequestParam("guest_email") String email,
												@RequestParam String guest_homepage,
												@RequestParam String guest_title,
												@RequestParam String guest_content) {
		
		//spring이 annotation으로 reflection해서 나오는 결과~~~~~
		//spring은 표현법에 불과하다..
		/*
		<< 방명록쓰기 >>
		  << @RequestParam("guest_name") String name >>
		      String name = request.getParameter("guest_name");
		  << @RequestParam String guest_email >>     
			  String guest_email = request.getParameter("guest_email");
			  String guest_homepage = request.getParameter("guest_homepage");
			  String guest_title = request.getParameter("guest_title");
			  String guest_content = request.getParameter("guest_content");
		 */
		 
		Guest insertGuest = new Guest(0, name, null, email, guest_homepage, guest_title, guest_content);
		System.out.println("### @RequestParam ###");
		System.out.println("### insertGuest: "+insertGuest+" ###");
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	@RequestMapping(value = "/model_attribute_guest_write_action.do",
					method = RequestMethod.POST)
	public String model_attribute_guest_write_action(@ModelAttribute Guest guest) {
		/*
		 * [Rule]
		 * Guest는 default기본생성자를 가져야함
		 * getter안의 property이름은 parameter와 일치해야함
		 * 
		 */
		/*
		 << 방명록쓰기 >>
		   1. Guest guest=new Guest();
		 
		   2. String guest_name = request.getParameter("guest_name");
			  String guest_email = request.getParameter("guest_email");
			  String guest_homepage = request.getParameter("guest_homepage");
			  String guest_title = request.getParameter("guest_title");
			  String guest_content = request.getParameter("guest_content");
		   
		   3. guest.setGuest_name(guest_name);
		      guest.setGuest_email(guest_email);
		      guest.setGuest_homepage(guest_homepage);
		      guest.setGuest_title(guest_title);
		      guest.setGuest_content(guest_content);
		   
		   4. request.setAttribute("guest",guest);    
		 */
		/*
		   1. 인자로선언된DTO객체[Guest]생성(기본생성자)
		   2. 모든 파라메타 받기
		   3. 받은파라메타 데이타를 파라메타이름과 일치하는
		      Guest객체의 속성메쏘드(setter method)호출해서대입
		   4. Guest클래스이름 첫글자를 소문자로변경한이름(guest)으로
		      request객체에 속성(attribute)등록
		      request.setAttribute("guest",guest);
		 */
		System.out.println("### @ModelAttribute ###");
		System.out.println("guest: "+guest);
		return "forward:/WEB-INF/views/guest_write_result.jsp";
	}
	
}
