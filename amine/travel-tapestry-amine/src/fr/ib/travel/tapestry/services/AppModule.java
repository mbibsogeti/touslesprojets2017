package fr.ib.travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {
	public static void bind(ServiceBinder binder) {
		//déclaration à tapestry des services additionnel de mon application
		binder.bind(SEAsiaPriceService.class, SEAsiaPriceServiceImpl.class);
	}
}
