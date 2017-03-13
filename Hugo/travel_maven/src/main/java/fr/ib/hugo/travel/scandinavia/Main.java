package fr.ib.hugo.travel.scandinavia;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	private static AbstractApplicationContext ctx;

	public static void main(String[] args) {
		System.out.println("Viajes a Escandinavia");
		// définition de la variable ctx qui contient la liste de beans
		// disponibles, ainsi que le path
		ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
		ctx.registerShutdownHook();
		// affichage des beans contenus dans ctx
		for (String n : ctx.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		if (ctx.containsBean("cruiseSource")) {
			// appel au bean CruiseSource, et stockage dans la viariable cs
			CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
			// exécution de la methode getHelsinkiBergen() contenu dans la
			// variable cs
			System.out.println(cs.getHelsinkiBergen());
			// appel au bean LakeSource, et stockage dans la variable l
			LakeSource l = (LakeSource) ctx.getBean("lakeSource");
			l.fillInfos();
			// exécution de la méthode getInfos() contenue dans la va
			System.out.println(l.getInfos());
			if (cs.getActive()) {
				System.out.println("Activo!");
			}
		}
	}
}