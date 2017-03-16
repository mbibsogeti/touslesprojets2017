package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.slf4j.Logger;

public class Coree {
	

	@Property @Persist private String text;
	private String[] texts = {"Bienvenue en corée","Coree.com","Aller-retour pour 1200.00€"};
	
	@Inject private Logger logger;
	public Object onAction(int x){
		text=texts[x];
		return textZone.getBody();
	}
	@InjectComponent private Zone textZone;

}
