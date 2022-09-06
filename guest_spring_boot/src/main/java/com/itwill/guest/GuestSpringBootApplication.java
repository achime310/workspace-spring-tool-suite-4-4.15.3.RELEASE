package com.itwill.guest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
public class GuestSpringBootApplication implements WebMvcConfigurer {
	public static void main(String[] args) {
		SpringApplication.run(GuestSpringBootApplication.class, args);
	}
	/** 
	 * Add Index Page
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	
	

}
