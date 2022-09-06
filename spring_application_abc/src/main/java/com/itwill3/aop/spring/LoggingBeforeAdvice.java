package com.itwill3.aop.spring;

import org.aspectj.lang.JoinPoint;

/*
 * 메쏘드실행전 로그출력
 */
public class LoggingBeforeAdvice {
	 public void beforeLog() {
		 System.out.println(""
		 		+ "###[사전충고]메쏘드가 호출되기전필요한 작업처리(log)");
		
		
	 }
}
