package fr.belto.travel.tapestry.pages;

import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Zone;

public class Corea {
@Persist @Property private String text;
private String[] texts={
		"Un beau pays","Gyeongbokgung","Un forfait de 10 jours à 800 euros, tout compris"
};
// on aurait pu mettre void si il y a pas de retour
// on utilise object pour permettre d'aller lire le contenu de textZone et ne recharge pas la page completement
// onAction est maintenant dedier à AJAX car on a ecrit zone
// on a une zone et c'est le contenu qui change
// du coup on ne met plus @persist
public Object onAction(int i){
	text=texts[i];
	return textZone.getBody();
}
@InjectComponent private Zone textZone;
}
