package jk.travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

// Cette classe doit s'appeler comme le filtre dans web.xml : app
public class AppModule {
	
	public static void bind(ServiceBinder binder) {
		// Tel service est implémenté par telle interface
		binder.bind(SEAsiaPriceService.class, SEAsiaPriceServiceImpl.class);
	}
}