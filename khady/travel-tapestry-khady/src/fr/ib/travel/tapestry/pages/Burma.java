package fr.ib.travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;

public class Burma {
	@Inject Logger logger;
	
	@Persist private int hesitationCount;

	public int getHesitationCount() {
		return hesitationCount;
	}

	public void setHesitationCount(int hesitationCount) {
		this.hesitationCount = hesitationCount;
	}

	public void onSayInterested() {
		logger.info("A person is interested in your offer");
	}
	
	public void onActionFromHesitation() {
		logger.info("A person is hesitating "+ (hesitationCount++));
	
	}
	
	public Class onActionFromNotNow(){
		return Cambodia.class;
	}
	
	@Inject private PersistentLocale pl;
	public void onChangeLocale(String l){
		pl.set(new Locale(l));
		
	}
	
}


