package jk.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Vietnam {

	// ATTRIBUTS //
	private String[] textes = {
		"Pour les historiens vietnamiens, le Viêt Nam fut fondé en 2877 av. J.-C.. La capitale de l'époque se situait à l'emplacement de l'actuelle Canton en Chine"
		+ " méridionale. L'histoire du pays, dont les origines sont semi-légendaires, se confond en grande partie avec celle du peuple Việt, aussi appelé Kinh,"
		+ " qui, de son berceau primitif du Văn Lang, aurait ensuite essaimé vers le delta du fleuve rouge Đồng bằng sông Hồng.",
		"Baie de Hạ Long, Parc national de Phong Nha-Kẻ Bàng, Le Mékong et son delta, les îles de Phú Quốc",
		"Votre voyage est puissant"
	};
	
	// @Property : construit getText
	@Property
	private String text;
	
	@InjectComponent
	private Zone textZone;
	
	// MÉTHODES //
	public Object onAction(int i) {
		// On change l'intérieur de la zone
		text = textes[i];
		// On retourne l'intérieur de la zone
		return textZone.getBody();
	} // end onAction method
} // end Vietnam class