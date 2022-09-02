package com.itwill3.aop.java;
/*
 * Spring Container가 구현하는 Proxy객체
 */
public class MemberServiceSpringProxy implements MemberService {
	private MemberService targetObject;					//target클래스
	private LoggingBeforeAdvice loggingBeforeAdvice;	//aspect클래스
	
	public MemberServiceSpringProxy(MemberService memberService,LoggingBeforeAdvice loggingBeforeAdvice) {
		this.targetObject = memberService;
		this.loggingBeforeAdvice= loggingBeforeAdvice;
	}
	@Override
	public void create() {
		loggingBeforeAdvice.beforeLog();
		targetObject.create();
	}

	@Override
	public void login() {
		loggingBeforeAdvice.beforeLog();
		targetObject.login();
	}

	@Override
	public void list() {
		loggingBeforeAdvice.beforeLog();
		targetObject.list();
	}

	@Override
	public void view() {
		loggingBeforeAdvice.beforeLog();
		targetObject.view();
	}

}
