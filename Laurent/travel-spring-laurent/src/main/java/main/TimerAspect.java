package main;
import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {

	
	public Object showTime(ProceedingJoinPoint pjp) {
		//recueil du tps de départ
		long t1=System.nanoTime();
		Object o=null;
		try {
			o=pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long t2=System.nanoTime();
		System.out.println(pjp.getSignature().toString()+" : "+((t2-t1)/1000)+"ms");

		return o;
	}

}
