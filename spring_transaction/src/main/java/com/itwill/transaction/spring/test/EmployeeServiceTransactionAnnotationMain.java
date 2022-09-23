package com.itwill.transaction.spring.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.transaction.spring.Employee;
import com.itwill.transaction.spring.EmployeeService;

public class EmployeeServiceTransactionAnnotationMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("com/itwill/transaction/spring/test/spring-transaction-by-annotation.xml");
		EmployeeService service = (EmployeeService) context.getBean("empService");
		System.out.println("=============update전====================");
		List<Employee> emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}
		try {

			service.increaseSalaryForAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=============update후==============");

		emps = service.getEmps();
		for (Employee emp : emps) {
			System.out.println(emp.toString());
		}

	}

}
