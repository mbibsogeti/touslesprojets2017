package travel.tapestry.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.corelib.components.LocalDate;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PersistentLocale;
import org.jboss.logging.Logger;



public class Burma {
	@Inject Logger logger;
	
	@Persist private int hesitationCount;  //persiste perme t de conservé la variable , car sinon elle peut disparaitre 

	@Inject private PersistentLocale pl;
	
public void onChangeLocale(String l){
	pl.set(new Locale (l));
	
	
}
public void onSayInterested(){ logger.info("+1 interested"+ (hesitationCount++));}

public void onActionFromHesitation(){}

public Class onActionFromNotNow(){return Cambodje.class;}
	
	
	
	
}


