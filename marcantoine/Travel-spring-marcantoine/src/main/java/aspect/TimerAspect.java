package aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {

	public Object showTime(ProceedingJoinPoint pjp) throws Throwable {
		long t1 = System.nanoTime();
		// On réalise avec le code suivant la fonction pjp.
		Object o = pjp.proceed();
		long t2 = System.nanoTime();
		// Cette différence entre t1 et t2 permet de mesurer le temps
		// d'exécution de la fonction pjp.
		System.out.println((t2 - t1) + " ns");
		return o;
	}

}
