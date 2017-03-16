package fr.ib.travel.tapestry.pages.Birmanie;

import java.util.Locale;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Birmanie {
	@Inject Logger logger;
	
	@Inject private PersistentLocale pl;
	public void onChangeLocale(String l){
		pl.set(new Locale (l));
		logger.info("bonjour"+l);
	}

	@Persist
	private int hesitationCount;
	
	
	public void onSayInterested(){
		logger.info("+1 interseted");
	}
	
	public void onSayHesitated(){
		logger.info("Hésitation : "+(hesitationCount++));
	}
	
	public String onAction(){
		return "Cambodia/Cambodia";
	}

}
