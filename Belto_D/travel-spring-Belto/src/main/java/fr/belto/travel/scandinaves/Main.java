package fr.belto.travel.scandinaves;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// on affiche quelque chose
      System.out.println("Nos voyages en scandinavie");
// on lui dit de nous fournir des beans, createur de beans
// C'est une classe abstraite (AbstractApplicationContext), creation d'un fichier contenant tous les beans
      AbstractApplicationContext ctx= new FileSystemXmlApplicationContext("classpath:spring.xml");
      ctx.registerShutdownHook();
// aller chercher tous les beans présents avec leur nom
for (String n: ctx.getBeanDefinitionNames()){
		System.out.println(n);
		}
// si ce bean est présent alors....
	if (ctx.containsBean("cruiseSource")){
// creation d'un bean, On recupère l'objet
//CruiseSource cs=(CruiseSource)
// on crée un objet cruise (cs)/ instance de classe, // création d'un bean(avec l'id donnée dans le fichier spring.xml)
	CruiseSource cs = (CruiseSource)ctx.getBean("cruiseSource");
// on lui dit d'executer la fonction getActive décrite dans Cruise source
			if (cs.getActive())
				System.out.println("Actif!");
			System.out.println(cs.getHelsinkiBergen());
	}
	}

}
