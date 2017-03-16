package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Korea {

	@Property
	private String text;
	private String[] texts = { "Corea del Sur: tierra de Starcraft", "Seoul", "Viajes a Seoul" };

	public Object onAction(int i) {

		text = texts[i];
		// requête js qui neutralise la page et ne met à jour que la zone
		// désignée.s Cela évite de recharger toute la page
		return textZone.getBody();
	}

	@InjectComponent
	private Zone textZone;

}
