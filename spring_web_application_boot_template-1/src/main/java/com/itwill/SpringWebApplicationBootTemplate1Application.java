package com.itwill;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * SpringWebApplicationBootTemplate1Application클래스를 기준으로 
 * 하위모든디렉토리에있는 클래스들의 annotation을 읽어서 빈을생성
 */
//@MapperScan(basePackages = {"com.itwill.guest.mapper","com.itwill.user.mapper","com.itwill.repository"})
@SpringBootApplication
public class SpringWebApplicationBootTemplate1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplicationBootTemplate1Application.class, args);
	}

}
