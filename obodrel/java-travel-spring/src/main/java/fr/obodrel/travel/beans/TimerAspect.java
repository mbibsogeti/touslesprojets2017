package fr.obodrel.travel.beans;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {
	public Object showTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long timeBefore = System.nanoTime();
		long timeAfter;
		Object toRet;
		
		toRet = proceedingJoinPoint.proceed();
		
		timeAfter = System.nanoTime();
		//System.out.println(proceedingJoinPoint.getSignature().toString() + " : " + (timeAfter-timeBefore) + " ns");
		
		return toRet;
	}
}
