package com.itwill3.aop.java;
/*
메쏘드호출전에 필요한작업처리[log]를위한 클래스
 */
public class LoggingBeforeAdvice {
	public void beforeLog() {
		System.out.println("###[사전충고]메쏘드호출전에 필요한작업처리[log]");
	}
}
