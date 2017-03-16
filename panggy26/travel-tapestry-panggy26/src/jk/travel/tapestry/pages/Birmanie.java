package jk.travel.tapestry.pages;

import java.util.Locale;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Birmanie {
	
	// ATTRIBUTS //
	@Inject
	private Logger logger;
	@Persist
	// Les données disparaissent entre chaque requête. Avec @Persist, elles... persistent
	private int hesitationCounter;
	@Inject
	private PersistentLocale persiLocale;
	
	public void onInterested() {
	// Mettre log4j.rootLogger=info dans le fichier log4j.properties
		logger.info("1 personne intéressée de plus !");
	} // end onClick method
	
	public void onActionFromHesitation() {
		hesitationCounter++;
		logger.info("Hésitation n°" + hesitationCounter);
	} // end onClick method
	
	// Méthode 1 : avec Class 
	public Class<Cambodge> onActionFromGoCambodge() {
		return Cambodge.class;
	}
	// Méthode 2 : avec String
//	public String onActionFromGoCambodge() {
//		return "Cambodge";
//	}
	
	// Reçoit le 'fr' ou 'en' du fichier .tml
	public void onChangeLocale(String l) {
		persiLocale.set(new Locale(l));
	} // end onChangeLocale method
} // end Birmanie class