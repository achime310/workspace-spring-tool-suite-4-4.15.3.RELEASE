package com.itwill3.aop.java;

public class MemberServiceImpl implements MemberService{
	
	@Override
	public void create() {
		
		System.out.println("### MemberServiceImpl.create()");
	}

	@Override
	public void login() {
		
		System.out.println("### MemberServiceImpl.login()");
		
	}

	@Override
	public void list() {
		
		System.out.println("### MemberServiceImpl.list()");
	}

	@Override
	public void view() {
		
		System.out.println("### MemberServiceImpl.view()");
	}

}
