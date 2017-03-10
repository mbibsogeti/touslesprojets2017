package fr.belto.travel.aop;

import org.aspectj.lang.ProceedingJoinPoint;
 
public class TimerAspect {
// throws throwable est ajouté par eclipse pour recuperer des exceptions
public Object showTime (ProceedingJoinPoint pjp) throws Throwable{
// recuperer le temps ecoulé de manière precise dans Java
// faut ensuite déclarer le bean dans spring.xml
	long t1=System.nanoTime();
	Object o=pjp.proceed();
	long t2=System.nanoTime();
	System.out.println((t2-t1)+"ns");
	return o; 
}
}
