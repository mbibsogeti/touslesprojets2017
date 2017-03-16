package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Coree {
	
	@Persist @Property private String text;
	private String[] texts={" Texte sur le pays", "Texte sur les sites à voir", "Texte sur votre voyage"};
	
	@InjectComponent private Zone textZone;
	
	public Object onAction(int i){
		text=texts[i];
		return textZone.getBody();
	}
	

}
