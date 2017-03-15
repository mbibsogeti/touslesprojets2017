package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;


public class Korea {
	
	 @Property private String text;	
	private String [] texts = {
	"C'est l'un des pays d'Asie", "L'un des principaux sites est Baekje","Votre voyage commencera par une courte visite de la vieille ville"		
	};
	
	
	public Object onAction(int i){
	text = texts[i];
	return textZone.getBody();
	}
	@InjectComponent private Zone textZone;
	
}
