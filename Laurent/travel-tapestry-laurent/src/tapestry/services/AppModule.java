package tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

//Class indiquant à tapestry les différents composant du service SEAsiaPriceService
public class AppModule {

	public static void bind(ServiceBinder binder){
		binder.bind(SEAsiaPriceService.class, SEAsiaPriceServiceImpl.class);
	}
	
}
