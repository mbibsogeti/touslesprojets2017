package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import fr.ib.travel.tapestry.travel.Travel;

public class India {
	@Inject private Logger logger;
	public Travel getTravel() {
		logger.info("travel");
		return new Travel("Bombay", "Bollywood, shopping, temple, mode et grotte", 1700);
	}
	@Inject private Messages messages;
	@Log public String getMention(){
		return messages.format("mention", 2017);
	}
}