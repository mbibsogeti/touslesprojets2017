package fr.ib.travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

import fr.ib.travel.jbeans.Travel;

public class Burma {

	@Inject
	private Logger logger;
	// @Persist permet de garder les valeurs attribuées à des variables dans le
	// passé. @Persist(PersistenceConstants.FLASH) ne garde les valeurs que
	// jusqu'à leur lecture
	@Persist
	private int hesitationCount;

	public Travel getTravel() {
		return new Travel("Nueva Dheli", 300, "La capital de la India");
	}

	public void onSayInterested() {
		logger.info("ouaip");
	}

	public void onActionFromHesitation() {
		logger.info("ouaip action" + (hesitationCount++));
	}

	public Class<Cambodia> onActionFromCambodia() {
		return Cambodia.class;
	}

	public String onActionFromIndia() {
		return "India";
	}

	@Inject
	private PersistentLocale pl;

	public void onChangeLocale(String l) {
		pl.set(new Locale(l));
	}

}
