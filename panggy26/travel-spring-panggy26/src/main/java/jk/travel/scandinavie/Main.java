package jk.travel.scandinavie;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Nos voyages scandinaves");
		// classpath: cherche dans le chemin des classes
		AbstractApplicationContext context = new FileSystemXmlApplicationContext("classpath:spring.xml");
		context.registerShutdownHook();
		// Afficher tous les noms des Beans
		for (String i : context.getBeanDefinitionNames()) {
			System.out.println(i);
		}
		// Vérification de l'existence du Bean (nom en minuscule)
		if (context.containsBean("cruiseSource")) {
			CruiseSource cs = (CruiseSource) context.getBean("cruiseSource");
			if (cs.getActive()) {
				System.out.println("Nos voyages sont actifs !");
				// Voir TimerAspect pour l'affichage du temps à l'exécution de cette ligne
				System.out.println(cs.getHelsinkiBergen());
				// // Dans spring.xml, :
				// <beans scope="singleton" : comportement par défaut. On instancie une fois, on garde en mémoire et on renvoie à chaque
				// appel. Booléen ci-dessous true.
				// <beans scope="prototype" : crée une nouvelle instance à chaque appel. Booléen ci-dessous false.
				// System.out.println(context.getBean("cruiseSource") == context.getBean("cruiseSource"));
			} // end if
		} // end if
		if (context.containsBean("lakeSource")) {
			LakeSource ls = (LakeSource) context.getBean("lakeSource");
			System.out.println(ls.getInfos());
			ls.fillInfos();
			// Ajout implicite de .toString() grâce à l'intelligence de System.out.println
			System.out.println(ls.getInfos());
		} // end if
		context.close();
	} // end main method
} // enc Main class