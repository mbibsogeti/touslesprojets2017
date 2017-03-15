package tapestry.pages;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class Burma {

	//Logger
	@Inject private Logger logger;
	private int hesitationCount=0;
	
	//METHODES
	//listener par défaut
	public void onAction(){
		logger.info("You've been clicked !!");
	}
	
	//listener pour l'event click
	public void onClick(){
		logger.info("You've got clicked !!");
	}
	
	//listener de type click avec l'id "test3"
	public void onActionFromTest3(){
		logger.info("You've just clicked !!");
	}
	
	//listener de type click avec l'id "test3"
	public void onInteressted(){
		hesitationCount++;
		logger.info("You've just clicked "+hesitationCount+" times !!");
	}
	
	//Redirection vers une page
	public String onCambo(){
		return "Cambodia";
	}
}
