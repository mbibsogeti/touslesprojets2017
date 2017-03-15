package fr.ib.travel.tapestry.pages;

import java.util.Calendar;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.slf4j.Logger;

import fr.ib.travel.tapestry.beans.Travel;

public class Inde {
	
	@Inject private Logger logger;
	public Travel getTravel(){
		logger.info("travel");
		return new Travel("Delhi","Visite de la capitale", 550.00);
	}
	
	@Inject private Messages messages;
	@Log
	public String getMention(){
		
		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		
		return messages.format("mention", year);
	}
}
