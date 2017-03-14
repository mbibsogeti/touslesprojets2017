package fr.ib.travel;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Nos voyages en Scandinavie");

		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		ctx.registerShutdownHook();

		for (String n : ctx.getBeanDefinitionNames()) { // ctx.getBeanDefinitionNames
														// correspond à la
														// listes des bean
														// défini dans
														// spring.xml
			System.out.println(n);
		}

		if (ctx.containsBean("cruiseSource")) { // on test l'existence de
												// "cruiseSource" avant de
												// lancer la suite

			CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");

			if (cs.getActive()){
				System.out.println("Actif !");
				String rep = cs.getHelsinkiBergen();
				System.out.println(rep);
			}
			
			LakeSource ls = (LakeSource) ctx.getBean("lakeSource");
			ls.fillInfos();
			System.out.println(ls.getInfos());
			System.out.println(ls.getInfos(2L));
			System.out.println(ls.getGrandsLacs());
		}
	}
}
