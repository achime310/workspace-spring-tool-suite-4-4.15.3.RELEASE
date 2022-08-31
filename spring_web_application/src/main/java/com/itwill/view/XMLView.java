package com.itwill.view;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

public class XMLView extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(
				"### DispatcherServlet이 XMLView.renderMergedOutputModel() 호출");
		List<String> friendList = (List<String>) model.get("friendList");

		/************** XML 출력 **************/
		// servlet과 유사한 형태
		response.setContentType("text/xml;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<?xml version='1.0' encoding='UTF-8'?>");
		// xml은 태그를 내마음대로 쓰는 mark-up언어
		out.println("<friends>");
		for (String friend : friendList) {
			out.println("<friend>" + friend + "</friend>");
		}
		out.println("</friends>");
		/************** XML 출력 **************/

	}

}
