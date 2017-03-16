package fr.belto.travel.tapestry.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import fr.travel.java.bean.Travel;

public class India {
@Inject private Logger logger;
public Travel getTravel(){
	logger.info("travel");
return new Travel("Bonbay", 800, "Ville de l'ouest");
		}
@Inject private Messages messages;
@Log public String getMention(){
	return messages.format("mention",2017);
}
}
