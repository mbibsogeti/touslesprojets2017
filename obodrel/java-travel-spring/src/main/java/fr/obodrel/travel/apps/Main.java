package fr.obodrel.travel.apps;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import fr.obodrel.travel.beans.CruiseSource;
import fr.obodrel.travel.beans.LakeSource;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		AbstractApplicationContext springContext = new FileSystemXmlApplicationContext("classpath:spring.xml");
		CruiseSource cruiseBean = null;
		LakeSource lakeBean = null;
		System.out.println("Our scandinavians trips!");

		for(String beanAvailable : springContext.getBeanDefinitionNames()) {
			System.out.println(beanAvailable);
		}
	
		if( springContext.containsBean("cruiseSource")) {
			cruiseBean = springContext.getBean(CruiseSource.class, "cruiseSource");
			if(cruiseBean.getActive()) {
				System.out.println("Cruises active! "+cruiseBean.getActive());
			}
		}
		System.out.println(cruiseBean.getHelsinkiBergen());
		
		if(springContext.containsBean("lakeSource")) {
			lakeBean = springContext.getBean(LakeSource.class, "lakeSource");
		}
		
		System.out.println(lakeBean.getInfos());	
		
		springContext.registerShutdownHook();
	}

}
