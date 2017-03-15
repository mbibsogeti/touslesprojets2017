package travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Burma {

	@Inject
	private Logger logger;

	@Persist
	private int hesitationCount;

	// Utilisation d'un service de Tapestry : PersistentLocale.
	@Inject
	private PersistentLocale pl;

	public void onClick() {
		logger.info("the guy is very EVENT interested in our trips.");
	}

	public void onAction() {
		logger.info("the guy is very ACTION interested in our trips.");
	}

	public void onActionFromHesitation() {
		logger.info("this guy is hot and cold... for " + (hesitationCount++) + " time(s)");
	}

	// On crée ici une fonction permettant de créer un lien vers une autre page,
	// ici vers 'Cambodia'. La machine regarde le package 'pages' pour trouver
	// la page avec le nom correspondant.
	public Class onActionFromCambodia() {
		return Cambodia.class;
	}
	
	public void onChangeLocale (String l) {
		pl.set(new Locale(l));
	}
}
