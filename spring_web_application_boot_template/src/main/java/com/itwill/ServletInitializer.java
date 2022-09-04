package com.itwill;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("ServletInitializer클래스의 configure("+application+")실행시점 확인");
		return application.sources(SpringWebApplicationBootTemplateApplication.class);
	}
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
    	System.out.println("ServletInitializer클래스의 onStartup("+servletContext+")실행시점 확인");
    }
}