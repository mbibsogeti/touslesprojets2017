package fr.ib.spring.travel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Nos voyages scandinaves");
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		// faire une fonction qui est équivalent à un close
		// ferme automatiquement quand la JVM s'arrête ;)
		ctx.registerShutdownHook();
		//afficher les beans disponible
		for(String n:ctx.getBeanDefinitionNames())
			System.out.println(n);
		//tester si le bean existe
		if(ctx.containsBean("cruiseSource")){
			System.out.println("true");
		}
		// id de spring.xml
		CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
		if (cs.getActive())
			System.out.println("Actif!");
		System.out.println(cs.getHelsinkiBergen());
	}
}