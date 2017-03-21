package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cruise.CruiseSource;
import lake.LakeSource;

public class Main {

	public static void main(String[] args) {
		System.out.println("Our scandinavian trips");
		// On crée notre outil de lecture des beans (instance de classe Java).
		// Cette classe est une interface (ou classe abstraite).
		// On lui donne l'endroit où chercher les infos concernant nos beans :
		// "spring.xml". Les gens de Spring ont prévu qu'on puisse travailler
		// sur plusieurs projets. En ajoutant classpath:spring.xml, on dit au
		// compilateur de chercher directement dans notre projet.
		@SuppressWarnings("resource") // sert à enlever l'erreur "ctx never
										// closed d'Eclipse. Ici, c'est l'IDE
										// qui a tort !"
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");

		// Cette fonction inscrira une fin automatique fermera notre ctx à la
		// fin de notre application. On peut l'écrire n'importe où.
		ctx.registerShutdownHook();
		// Lecture d'un bean en utilisant ctx
		CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
		// On utilise notre instance avec sa fonction getActive.
		// NB : on pourrait utiliser if (ctx.containsBean("cruiseSource")) {};
		if (cs.getActive()) {
			System.out.println("cs is Active!");
		}
		if (ctx.containsBean("cruiseSource")) {
			System.out.println("ctx contains cruiseSource");
		}
		//La fonction getBeanDefinitionNames renvoie le nom du bean.
		for (String n : ctx.getBeanDefinitionNames()) {
			System.out.println(n);
		}
		System.out.println(cs.getHelsinkiBergen());
		// L'exemple suivant crée une erreur de spring : même si on a défini le
		// bean,
		// cette classe "calendar" ne possède pas de constructeur pas défaut !
		// CruiseSource cs2 = (CruiseSource) ctx.getBean("calendar");
		// if (ctx.containsBean("calendar")) {   
		// System.out.println("ctx contains calendar");
		// }
		LakeSource ls = (LakeSource) ctx.getBean("lakeSource");
		ls.fillInfo();
		System.out.println(ls.getInfo());
	}

}
