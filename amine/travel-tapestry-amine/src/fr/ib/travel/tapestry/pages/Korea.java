package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Korea {
	@Property
	private String text;
	private String[] texts = { "Corée du sud", "site de samsung", "voyage dans le pays des ninjas" };

	public Object onAction(int i) {
		text = texts[i];
		return textZone.getBody();
	}
	@InjectComponent private Zone textZone;
}