package fr.ib.travel.tapestry.pages.India;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import fr.ib.travel.tapestry.beans.Travel;

public class India {
	
	@Inject private Logger logger;
	public Travel getTravel(){
		return new Travel ("Bombay","6jours/5nuits",1020);
	}
	
	@Inject private Messages messages;
	@Log public String getMention(){
		return messages.format("mention", 2017);
	}

}
