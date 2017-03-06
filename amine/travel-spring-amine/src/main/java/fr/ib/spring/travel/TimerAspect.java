package fr.ib.spring.travel;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {
	public Object showTime(ProceedingJoinPoint pjp) throws Throwable{
		long t1=System.nanoTime();
		Object o=pjp.proceed();
		long t2=System.nanoTime();
		System.out.println((t2-t1)+"ns");
		return o;
	}
}
