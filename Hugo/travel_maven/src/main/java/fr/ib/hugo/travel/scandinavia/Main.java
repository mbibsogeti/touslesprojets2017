package fr.ib.hugo.travel.scandinavia;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	private static AbstractApplicationContext ctx;

	public static void main(String[] args) {
		System.out.println("Viajes a Escandinavia");
		ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		ctx.registerShutdownHook();
		for (String n : ctx.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		if (ctx.containsBean("cruiseSource")) {
			CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
			System.out.println(cs.getHelsinkiBergen());
			if (cs.getActive()) {
				System.out.println("Activo!");
			}
		}
	}
}