package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.tapestry.travel.Travel;

public class India {
	public Travel getTravel() {
		return new Travel("Bombay", "Bollywood, shopping, temple, mode et grotte", 1700);
	}
	@Inject private Messages messages;
	public String getMention(){
		return messages.format("mention", 2017);
	}
}