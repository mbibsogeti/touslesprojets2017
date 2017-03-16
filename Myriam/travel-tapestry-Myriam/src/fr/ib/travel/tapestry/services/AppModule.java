package fr.ib.travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {
	/* Classe qui permet d'injecter le service dans l'application par la suite*/
	
	public static void bind(ServiceBinder binder){
		binder.bind(SEAsiaPriceService.class,SEAsiaPriceServiceImpl.class);
	}

}
