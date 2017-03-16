package tapestry.pages;

import org.slf4j.Logger;
import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import tapestry.beans.Travel;

public class India {

	@Property
	private Travel travel;
	
	//Obtenir la liste des messages (cf India.properties)
	@Inject private Messages message;
	
	//Obtenir un loggeur
	@Inject private Logger logger;
	
	//Création d'un voyage
	public Travel getIndianTravel(){
		logger.info("travel");
		String desc="Un itinéraire concocté pour une découverte d’exception : réserve animalière, montagnes et plages, sites bouddhiques et nature éblouissante…toute la diversité de la perle de l’Orient agrémentée de balades à pied, en bateau, en train, ou en charrette à bœufs.";
		return new Travel("Sri Lanka",1670d,desc);
	}

	//Exploiter un des messages contenus dans les fichiers properties
	@Log public String getMention(){
		return message.format("mention", 2017);
	}
}
