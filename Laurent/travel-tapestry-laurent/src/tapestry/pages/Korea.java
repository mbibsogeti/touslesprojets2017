package tapestry.pages;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

@Import(module = "korea")
public class Korea {

	// Propriétés
	@Persist() @Property private String text;
	//Récupération d'un objet de ma page
	@InjectComponent private Zone textZone0;
	@InjectComponent private Zone textZone1;
	@InjectComponent private Zone textZone2;
	

	private String[] texts = {
			"La Corée du Sud, en forme longue la République de Corée, en coréen Daehan Minguk, 대한민국, 大韓民國, est un pays d'Asie de l'Est qui couvre la moitié sud de la péninsule coréenne. Sa capitale est Séoul.",
			"Gyeongbokgung, Changdeokgung, N Seoul Tower, Seoraksan National Park, Myeong-dong",
			"Pas de voyages prévu pour le moment !"
	};

	// Methode a fr lors d'une action par defaut
	public Object onAction(int value) {
		text=texts[value];
		Zone[] zones={textZone0,textZone1,textZone2};
		System.out.println(zones[0]);
		return zones[value].getBody();
	}
}
