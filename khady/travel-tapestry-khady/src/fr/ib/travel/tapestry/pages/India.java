package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import fr.ib.travel.tapestry.beans.Travel;


public class India {
	
	@Inject private Logger logger;
	private Travel travel;

	public Travel getTravel() {
		logger.info("travel");
		return new Travel("Bombay",750d,"Promenade en ville");
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}
	
	@Inject private Messages messages;
	@Log
	public String getMention(){
		return messages.format("mention", 2017);/* au lieu de mettre 2017 en dur, on aurait pu utiliser la fonction Calendar pour afficher l'année 2017
		cf TravelsAction dans package fr.ib.travel.england de STRUTS*/
	}
	
}
