package travel.tapestry.pages;


import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;



import javabean.Travel;

public class Inde {
	@Inject 
	private Messages messages;
//@Inject private Logger logger;
	public Travel getTravel() {
		//logger.info("travel");
		return new Travel("newdelhy",
				"c pas cool mais on va mettre plus de caractère pour voir le description .substring marcher ", 1002);
	} // création de la propriété discount

//@Log
public String getMention() {

		return messages.format("mention", 2017);
	}

}