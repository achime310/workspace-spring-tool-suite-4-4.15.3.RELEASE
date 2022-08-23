package com.itwill0.context;

import com.itwill.product.ProductDao;
import com.itwill.product.ProductDaoImpl;
import com.itwill.product.ProductService;
import com.itwill.product.ProductServiceImpl;

public class JavaApplicationMain {

	public static void main(String[] args) {
		
		/******************* case1 *******************
		 1.ProductService객체를 생성한다.
		 2.ProductService객체메쏘드를 호출한다.
		   - ProductService객체메쏘드 호출시 GuestDaoImpl객체가 null 이므로 호출불가능하다.
		     (NullPointerException발생)  
		     
		ProductService productService = new ProductService();
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
		*********************************************/
		
		/******** case2 (constructor injection) ********
		 1.ProductDaoImp 객체를 생성한다
		 2.ProductServiceImpl에 생성자에 ProductDaoImp 객체의 주소를 넣어준다
			  (생성자를 통한 Injection)
		 3.ProductService객체메쏘드를 호출한다.
			 
		ProductDao productDao = new ProductDaoImpl();
		ProductService productService = new ProductService(productDao);
		//ProductService productService = new ProductService(ProductDaoImpl.class.newInstance());
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
		*********************************************/
		
		/******** case3 (setter method injection) *******
			 1. ProductDaoImple객체생성
			 2. ProductServiceImpl객체생성
			 3. ProductServiceImpl.setter 메쏘드를 사용해 ProductDaoImple객체 넣어준다
				  (setter 메쏘드 Injection)
			 4.ProductService객체메쏘드를 호출한다. 
		 */

		ProductDao productDao = new ProductDaoImpl();
		ProductService productService = new ProductServiceImpl();
		productService.setProductDao(productDao);
		
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
		
		
	}

}
