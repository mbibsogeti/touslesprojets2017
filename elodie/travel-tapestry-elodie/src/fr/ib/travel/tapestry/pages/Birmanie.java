package fr.ib.travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Birmanie {
	@Inject private Logger logger;
	
	@Persist
	private int hesitationCount;

	public void onActionFromLink1(){
		logger.warn("It's OK");
	}
	
	
	public void onActionFromLink2(){
		logger.warn("Je sais pas - " + (hesitationCount++));
	}
	
	public Class onActionFromBackCambodge(){
		return Cambodge.class;
	}
	
	@Inject private PersistentLocale pl;
	public void onActionFromChargeLocale(String l){
		pl.set(new Locale(l)); 
	}
	
	public void onActionFromChargeLocale2(String l){
		pl.set(new Locale(l)); 
	}

}
