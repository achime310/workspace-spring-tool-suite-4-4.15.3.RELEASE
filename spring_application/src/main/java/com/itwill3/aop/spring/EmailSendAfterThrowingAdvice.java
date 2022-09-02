package com.itwill3.aop.spring;

import org.aspectj.lang.JoinPoint;

public class EmailSendAfterThrowingAdvice {
	
	public void emailSend(JoinPoint jp,Exception exObj) {
		System.out.println("###[AfterThrowing]예외발생시 이메일전송("+exObj.getMessage()+")");
		Object targetObject = jp.getTarget();
		String className = targetObject.getClass().getName();
		String methodName = jp.getSignature().getName();
		Object[] argObjects = jp.getArgs();
		int argCounts=0;
		if(argObjects!=null) {
			argCounts=argObjects.length;
		}
		String profilingMsg = 
				className+"."+methodName+"("+argCounts+")"; 
		System.out.println("###[AfterThrowing]"+profilingMsg);
	}
}
