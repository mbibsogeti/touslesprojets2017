package fr.belto.travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.slf4j.Logger;


public class Burma {
@Inject Logger logger;
// nom de l'évenement declarer dans t:event
@Persist private int hesitationCount;
public void onSayInterested(){
	logger.info("+1 interested");
	
}
public void onActionFromHesitation(){
	//compter le nombre de fois qu'on click
	logger.info("hesitation"+(hesitationCount++));
}
public void onActionFromGocambodia(){
	logger.info("+1 traveller");
}
@Inject private PersistentLocale pl;
public void onChargeLocale(String  l){
	pl.set(new Locale(l));
	
}
}
