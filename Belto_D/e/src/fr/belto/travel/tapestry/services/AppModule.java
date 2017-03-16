package fr.belto.travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

public class AppModule {
public static void bind(ServiceBinder binder){
	binder.bind(SEAsiaPriceService.class, SEAsiaPriceServiceImpl.class);
}
}
