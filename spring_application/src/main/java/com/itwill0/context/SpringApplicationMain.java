package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductService;

public class SpringApplicationMain {

	public static void main(String[] args) {
		/*
		 * Spring Container객체생성 -> Servlet Container 와 비교하여 생각해보자
		 * 		- ApplicatioinContext[BeanFactory] 객체생성
		 * -> [javaApplication.java]의 case3와 같은 작업은 container가 알아서 해준다
		 * -> 설정파일이 필요하다. (위치: resources)
		 * 
		 */
		/*
		 * 1.Spring Bean의 설정파일을 읽어서 SpringContainer객체생성
		 */
		System.out.println("--------ApplicationContext생성시작--------");
		//ApplicationContext가 container객체이다
		ApplicationContext applicationContext=
				new ClassPathXmlApplicationContext("0.applicationContext.xml");
		//[0.applicationContext.xml]는 root에 위치한다.
		
		System.out.println("--------ApplicationContext생성  끝--------");
		
		/*
		 * 2.Spring Container객체[ApplicationContext객체]로부터
		 * 	 productService란 id객체참조얻기
		 */
		ProductService productService = 
				(ProductService)applicationContext.getBean("productService");
		System.out.println(productService);
		/*
		 * <bean>에 property를 설정함으로써, 아래의 코드를 없앨 수 있다.
		 * ProductDao productDao =
		 * (ProductDao)applicationContext.getBean("productDao");
		 * productService.setProductDao(productDao);
		 */
		
		
		System.out.println(productService.productList());
		//System.out.println(productService.productDetail(123));
	}

}
