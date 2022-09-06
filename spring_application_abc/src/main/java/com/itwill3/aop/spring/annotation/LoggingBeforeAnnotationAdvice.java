package com.itwill3.aop.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * 메쏘드실행전 로그출력
 */
@Component
@Aspect
public class LoggingBeforeAnnotationAdvice {
	/*
	 <aop:pointcut 
		 	id="loggingBeforePointCut"
		 	expression="execution(public java.util.List com.itwill.user.UserService.findUserList())" />
		 	
	 <aop:aspect ref="loggingBeforeAdvice">
	 	<aop:before method="beforeLog" pointcut-ref="loggingBeforePointCut"/>
	 </aop:aspect>
	*/
	@Pointcut(value = "execution(public java.util.List com.itwill.user.UserService.findUserList())")
	public void loggingBeforePointCut() {}
	
	@Before(value = "loggingBeforePointCut()")
	public void beforeLog(JoinPoint jp) {
		 System.out.println(""
		 		+ "###[사전충고(Annotation)]메쏘드가 호출되기전필요한 작업처리(log)");
		
		 Object targetObject = jp.getTarget();
		 String className = targetObject.getClass().getName();
		 String methodName = jp.getSignature().getName();
		 Object[] argsObjects = jp.getArgs();
		 int argCount=0;
		 if(argsObjects!=null) {
			 argCount = argsObjects.length;
		 }
		 String args="";
		 for (int i = 0; i < argCount; i++) {
			String argClassName = argsObjects[i].getClass().getName();
			args+=argClassName;
			if(i != argCount-1)
				args+=",";
			
		}
		System.out.println("###[사전충고(Annotation)]"+
					className+"."+
					methodName+"("+args+")");
		
	 }
}
