package jk.travel.scandinavie;

import org.aspectj.lang.ProceedingJoinPoint;

public class TimerAspect {

	public Object showTime(ProceedingJoinPoint pjp) throws Throwable {
		long t1 = System.nanoTime();
		// Provoque l'appel de la fonction (voir struts.xml)
		Object objet = pjp.proceed();
		long t2 = System.nanoTime();
		// Vitesse d'exécution de la fonction getPrice (voir le fichier spring.xml)
		System.out.println((t2 - t1) + " ns");
		return objet;
	} // end showTime method
} // end TimerAspect class
