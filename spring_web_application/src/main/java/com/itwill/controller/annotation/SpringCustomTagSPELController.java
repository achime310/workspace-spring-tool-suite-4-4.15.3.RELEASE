package com.itwill.controller.annotation;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itwill.dto.Guest;

@Controller
public class SpringCustomTagSPELController {
	@RequestMapping("/jstl_fmt_i18n.do")
	public String jtl_fmt_i18n() {
		// return "foward:/WEB-INF/views/jstl_fmt_i18n.jsp";
		return "jstl_fmt_i18n";
	}
	@RequestMapping("/spring_customtag_spel.do")
	public String spring_cutomtag_spel(HttpServletRequest request,
			Model model) {
		request.setAttribute("price0", 123456);
		request.setAttribute("name0", "seo-young");
		request.setAttribute("married1", true);

		request.setAttribute("price1", 987456);
		request.setAttribute("name1", "young-seo");
		
		request.setAttribute("price2", 852963);
		request.setAttribute("name2", "choi");
		request.setAttribute("married2", false);
		
		request.setAttribute("guest",
				new Guest(1, "영서", "2022/08/31", "zero@dot.com", "zero.com","오늘은 수요일",
						"Spring Custom Tag,SPEL에 대해 공부합니다."));
		
		return "spring_customtag_spel";
	}
	
	/************Spring JSP에서 국제화*******************
	1. application-config.xml에 MessageSource빈설정
	 <bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
  		<property name="basenames" value="messages/messages,messages/user"/>
  	 </bean>
  	 *****************************************************/
	
	@RequestMapping("/spring_customtag_spel_i18n.do")
	public String spring_customtag_spel_i18n() {
		return "spring_customtag_spel_i18n";
	}
	
	
}
