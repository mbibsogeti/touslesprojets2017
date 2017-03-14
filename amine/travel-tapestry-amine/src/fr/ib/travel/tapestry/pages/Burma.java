package fr.ib.travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Burma {
	@Inject
	Logger logger;
	@Persist
	private int hesitationCount;

	public void onSayInterested() {
		logger.info("+1 interested");
	}

	public void onActionFromLink() {
		// logger.info("-1 hesitation");
		logger.info("hesittion: " + (hesitationCount++));
	}

	@InjectPage
	Cambodge p;

	public Object onActionFromNotNow() {
		return p;
	}
	@Inject private PersistentLocale pl;
	public void onChangeLocale(String l){
		pl.set(new Locale(l));
	}
}
