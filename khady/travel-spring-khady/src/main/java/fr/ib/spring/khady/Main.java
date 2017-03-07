package fr.ib.spring.khady;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		System.out.println("Nos voyages scandinaves");
		@SuppressWarnings("resource")
		AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");// le ctx permet d'obtenir le Bean déclaré dans le fichier spring.xml
        ctx.registerShutdownHook(); // est une instruction de fermeture automatique c.a.d à la tte fin de l'exécution de l'application Java    
		for(String n:ctx.getBeanDefinitionNames()){// ce test liste tous les noms de Bean existants
			System.out.println(n);
		}
        if(ctx.containsBean("cruiseSource")) {//vérifier si le Bean avec l'Id "cruiseSource" existe
       CruiseSource cs = (CruiseSource)ctx.getBean("cruiseSource");//cette ligne permet de bénéficier des spécificités du Bean en indiquant son id qui est ici "cruiseSource"
        if(cs.getActive()){
        	System.out.println("Actif !! ");
        	
        	System.out.println(cs.getHelsinkiBergen());
        }
        
        LakeSource ls = (LakeSource)ctx.getBean("lakeSource");
            ls.fillInfos();      
        	System.out.println(ls.getInfos());
        }
        }
        	
	}

