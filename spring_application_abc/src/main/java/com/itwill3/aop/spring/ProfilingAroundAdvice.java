package com.itwill3.aop.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

/*
 * 메쏘드 실행시간측정 메쏘드실행전후
 */
public class ProfilingAroundAdvice {
	
	public Object aroundProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("###[AroundAdvice]메쏘드호출전 필요한작업기술");
		
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();
		
		Object returnObj=pjp.proceed();//target객체메쏘드호출
		
		stopWatch.stop();
		long duration=stopWatch.getTotalTimeMillis();
		
		Object targetObject = pjp.getTarget();
		String className = targetObject.getClass().getName();
		String methodName = pjp.getSignature().getName();
		Object[] argObjects = pjp.getArgs();
		int argCounts=0;
		if(argObjects!=null) {
			argCounts=argObjects.length;
		}
		String profilingMsg = 
				className+"."+methodName+"("+argCounts+") "+duration+" took..."; 
		System.out.println("###[AroundAdvice]"+profilingMsg);
		
		System.out.println("###[AroundAdvice]메쏘드호출후 필요한작업기술");
		return returnObj;
	}
}
