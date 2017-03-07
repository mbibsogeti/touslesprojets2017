package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import cruise.CruiseSource;
import lake.LakeSource;

public class Main {

	public static void main(String[] args) {
				
		//Création de l'objet Context permettant d'obtenir les beans répertoriés
		@SuppressWarnings("resource")
		AbstractApplicationContext ctx= new FileSystemXmlApplicationContext("classpath:spring.xml");
		ctx.registerShutdownHook(); //Indique à l'usine a bean de fermer une fois le shutdown de notre application instancié
		
		//Outils de débug : Affichage de tous les beans renseignés dans spring.xml
		for(String n: ctx.getBeanDefinitionNames()) System.out.println(n);
		
		//Test de l'existance d'un bean désiré
		if(ctx.containsBean("cruiseSource")){
			System.out.println("Nos voyages scandinaves");
			
			//Création de l'objet associé au bean désiré
			CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
		
			//Exploitation du bean "CruiseSource"
			if(cs.getActive() ){
				System.out.println("It's alive !!!!");
				System.out.println(cs.getHelsinkiBergen());
			}
			
		}
		
		if(ctx.containsBean("lakeSource")){
			LakeSource ls= (LakeSource) ctx.getBean("lakeSource");
			ls.fillInfos();
			System.out.println("\n"+ls.getInfos());
			System.out.println("\n"+ls.getInfos(2L));
			System.out.println("\n"+ls.getInfos(1000f));
		}
	}

}
