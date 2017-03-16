package travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

//déclaration du service : bind
public abstract class AppModule {
	public static void bind(ServiceBinder binder){ binder.bind(SEAsiaPriceService.class,SEAsiaPriceServiceImpl.class);
	}
}
