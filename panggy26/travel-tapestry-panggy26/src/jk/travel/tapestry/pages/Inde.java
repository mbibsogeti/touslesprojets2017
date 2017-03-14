package jk.travel.tapestry.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;
import jk.travel.beans.Travel;

public class Inde {

	// ATTRIBUTS //
	// @Inject : On injecte l'objet de l'interface Messages dans l'attribut mess
	@Inject
	private Messages mess;
	@Inject
	// Pour le log, soit on fait comme ça, soit on utilise @Log sur une méthode;
	private Logger logger;

	// MÉTHODES //
	public Travel getTravel() {
		logger.info("Je suis dans la méthode getTravel de la classe Inde");
		return new Travel("New Delhi", 750, "capitale indienne");
	} // end getTravel method

	// @Log : indique les moments d'entrée et de sortie de la méthode getMention. Permet de voir le temps d'exécution.
	// Pour le log, soit on fait comme ça, soit on utilise @Inject private Logger logger;
	@Log
	public String getMention() {
		return mess.format("mention", 2017);
	} // end getMention method
} // end Inde class