package travel.tapestry.services;

import org.apache.tapestry5.ioc.ServiceBinder;

// Cette classe sert à déclarer les services dans le projet Tapestry. Elle doit porter le nom AppModule où app est le nom du filter
// donné en web.xml.
public class AppModule {

	// Méthode qui sera appelée automatiquement car reconnue par Tapestry :
	// Sert à déclarer à Tapestry l'existence d'un nouveau Service en liant
	// l'interface et l'implémentation choisies.
	// Les services déclarés de la sorte sont ensuite utilisables dans d'autres
	// pages.
	public static void bind(ServiceBinder binder) {
		binder.bind(SEAsiaPriceService.class, SEAsiaPriceServiceImpl.class);
	}

}
