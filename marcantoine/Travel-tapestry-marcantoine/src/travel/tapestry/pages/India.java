package travel.tapestry.pages;

import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

import travel.tapestry.beans.Travel;

public class India {
	// On crée un attribut injectable.
	@Inject
	private Messages messages;
	
	@Inject
	private Logger logger;

	public Travel getTravel() {
		logger.info("travel");;
		return new Travel("New Delhi",
				"Although colloquially Delhi and New Delhi as names are used interchangeably to refer to the jurisdiction of the National Capital Territory (NCT) of Delhi, these are two distinct entities, and the latter is a small part of the former. The National Capital Region is a much larger entity comprising the entire National Capital Territory along with adjoining districts. New Delhi has been selected as one of the hundred Indian cities to be developed as a smart city under Prime Minister of India Narendra Modi's flagship Smart Cities Mission.",
				5434);
	}

	@Log public String getMention() {
		return messages.format("mention", 2017);
	}

}
