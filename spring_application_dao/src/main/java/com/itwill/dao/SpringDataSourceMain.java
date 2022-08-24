package com.itwill.dao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDataSourceMain {

	public static void main(String[] args) throws SQLException {
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("com/itwill/dao/spring_datasource.xml");
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");

		DataSource apacheDataSource =
				(DataSource)applicationContext.getBean("apacheDataSource");
		DataSource springDataSource =
				(DataSource)applicationContext.getBean("springDataSource");
		
		System.out.println("#### 1.ApacheDataSource: "+apacheDataSource);
		System.out.println("#### 1.ApacheDataSource Connection: "+apacheDataSource.getConnection());
		
		System.out.println("#### 2.SpringDataSource: "+springDataSource);
		System.out.println("#### 2.SpringDataSource Connection: "+springDataSource.getConnection());
		
		
		
		
	}

}