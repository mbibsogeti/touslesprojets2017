package fr.ib.travel.cruise;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
			System.out.println("Nos voyages scandinaves");
			@SuppressWarnings("resource")
			AbstractApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring.xml");
			ctx.registerShutdownHook();
			
			for(String n:ctx.getBeanDefinitionNames()){
				System.out.println(n);
			}
			
			CruiseSource cs = (CruiseSource) ctx.getBean("cruiseSource");
			if(cs.getActive()) System.out.println("Actif!");
			System.out.println(cs.getHelsinkiBergen());
			
			LakeSource ls = (LakeSource) ctx.getBean("lakeSource");
			ls.fillInfos();
			System.out.println(ls.getInfos());
	}

}
