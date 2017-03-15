package travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Korea {

	// On met cette annotation car lorsqu'on clique sur actionlink, la page est
	// rechargée ce qui fait oublier à la machine la valeur de 'text'.
	@Property
	@Persist
	private String text;

	@InjectComponent
	private Zone textZone;

	private String[] texts = {
			"Korea is a historical state in East Asia, since 1945 divided into two distinct sovereign states: North Korea (officially the 'Democratic People's Republic of Korea') and South Korea (officially the 'Republic of Korea'). Located on the Korean Peninsula, Korea is bordered by China to the northwest and Russia to the northeast. It is separated from Japan to the east by the Korea Strait and the Sea of Japan (East Sea}.",
			"Tourism in South Korea refers to the tourist industry in the Republic of Korea. In 2012, 11.1 million foreign tourists visited South Korea, making it the 20th most visited country in the world, and the 6th most visited in Asia.[1][2] Most non-Korean tourists come from Japan, China, Taiwan and Hong Kong. The recent popularity of Korean popular culture",
			"Votre voyage" };

	// Fonction pour afficher un texte en fonction du lien cliqué.
	// ***** Comment fonctionne Tapestry : il regarde le lien cliqué
	// (actionlink) et
	// cherche s'il existe une fonction onAction dans notre classe. S'il la
	// trouve, il
	// considère que la valeur à prendre en compte pour i est celle de context.
	public Object onAction(int i) {
		text = texts[i];
		return textZone.getBody();
	}
}
