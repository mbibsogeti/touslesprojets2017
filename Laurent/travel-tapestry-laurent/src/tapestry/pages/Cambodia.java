package tapestry.pages;

import org.slf4j.Logger;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

import tapestry.beans.Travel;
import tapestry.services.SEAsiaPriceService;

public class Cambodia {

	@Property
	private Travel travel;
	@Inject SEAsiaPriceService pr;
	private double price;
	
	//Obtenir la liste des messages (cf India.properties)
	@Inject private Messages message;
	
	//Obtenir un loggeur
	@Inject private Logger logger;
	
	//Fonction d'initialisation de la page
	@SetupRender 
	public void init(){
		price = pr.getCambodiaPrice();
	}
	
	//Création d'un voyage
	public Travel getCambodiaTravel(){
		logger.info("travel");
		String desc="Le Cambodge est l’État successeur de l’Empire khmer hindouiste et bouddhiste qui régna sur pratiquement toute la péninsule d’Indochine entre le XIe et le XIVe siècles. Le Cambodge a des frontières communes avec la Thaïlande à l'ouest et au nord-ouest, avec le Laos au nord-est et avec le Viêt Nam à l'est et au sud-est.";
		return new Travel("Phnom Penh",price,desc);
	}

	
}
