package com.itwill3.aop.java;

public class MemberServiceMain {

	public static void main(String[] args) {
		System.out.println("--------no weaving-------");
		MemberService memberService = new MemberServiceImpl();
		memberService.create();
		memberService.list();
		memberService.view();
		memberService.login();

		/*
		 * 클라이언트는 MemberService를 호출하는 줄 안다.
		 * 		그러나, proxy를 통해, MemberService를 호출한다
		 */
		System.out.println("--------weaving-------");
		MemberService memberServiceProxy1 = new MemberServiceSpringProxy(new MemberServiceImpl(),new LoggingBeforeAdvice());
		memberServiceProxy1.create();
		memberServiceProxy1.list();
		memberServiceProxy1.view();
		memberServiceProxy1.login();
		

	}

}
