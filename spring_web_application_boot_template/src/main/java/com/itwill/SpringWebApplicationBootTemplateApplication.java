package com.itwill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.itwill.guest.mapper","com.itwill.user.mapper"})
public class SpringWebApplicationBootTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplicationBootTemplateApplication.class, args);
	}

}
