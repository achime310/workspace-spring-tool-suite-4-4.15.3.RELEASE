package com.itwill3.aop.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class EmailSendAfterThrowingAnnotationAdvice {
	/*
	<bean id="emailSendAfterThrowingAdvice" 
		class="com.itwill4.aop.spring.EmailSendAfterThrowingAdvice"/>
	<aop:aspect ref="emailSendAfterThrowingAdvice">
			<aop:after-throwing
				pointcut="within(com.itwill.user.*)"
				method="emailSend"
				throwing="exObj"/>
	</aop:aspect>
	 */
	@AfterThrowing(value = "within(com.itwill.user.*)",throwing = "exObj")
	public void emailSend(JoinPoint jp,Exception exObj) {
		System.out.println("###[AfterThrowing(Annotation)]예외발생시 이메일전송("+exObj.getMessage()+")");
		
	}
	
}
