package com.itwill3.aop.java;

public class MemberServiceMain {

	public static void main(String[] args) {
		System.out.println("--------no weaving-------");
		MemberService memberService=new MemberServiceImpl();
		memberService.create();
		memberService.list();
		memberService.view();
		memberService.login();
		System.out.println("--------weaving-------");
		MemberService memberServiceProxy= 
				new MemberServiceSpringProxy(new MemberServiceImpl(),new LoggingBeforeAdvice());
		memberServiceProxy.create();	
		memberServiceProxy.list();	
		memberServiceProxy.view();	
		memberServiceProxy.login();	
		

	}

}
