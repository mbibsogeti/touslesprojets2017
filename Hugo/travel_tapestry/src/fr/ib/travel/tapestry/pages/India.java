package fr.ib.travel.tapestry.pages;

import org.slf4j.Logger;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.jbeans.Travel;

public class India {

	@Inject private Logger logger;
	public Travel getTravel() {
		logger.info("log de viaje");
		return new Travel("Nueva Dheli", 300, "La capital de la India");
	}

	@Inject
	private Messages messages;

	//affiche [ENTER] et [EXIT] dans la console
	@Log public String getMention() {
		return messages.format("mention", 2017);
	}

}
