package fr.obodrel.travel.pages;

import java.util.Locale;

import org.apache.tapestry5.PersistenceConstants;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.LocalizationSetter;
import org.slf4j.Logger;

import fr.obodrel.travel.beans.Travel;
import fr.obodrel.travel.services.SEAsiaPriceService;

public class Birmania {
	@Inject
	private Messages localizedMessages;

    @Inject
    @Property
    private Locale currentLocale;
    
    @Inject
    private LocalizationSetter _localizationSetter;
    
    @Inject
    private SEAsiaPriceService priceService;
    
    @Inject
    private Logger logger;
    
    @Persist(PersistenceConstants.SESSION)
    private int hesitationCount;
    
    private double _price;
    
    @InjectPage
    private Cambodia cambodiaPage;
    
    @SetupRender
    public void init() {
    	_price = priceService.getBirmaniaPrice();
    }

    public void onAction(){
    	logger.error("+1 interested");
    }
    public void onActionFromBtn1(){
    	logger.error("yeah");
    }
    /*
    1 - public String onAction(){return "Index";}
    2 - public Class onAction(){return Index.class;}
    3 - @InjectPage 
    	Index pageIndex;
    	public Object onAction(){return pageIndex;}
    all make us go back to index like <a href="index">Index</a>
     */
    
    public void onHesitation(){
    	logger.error("ahem, maybe, hesitated "+(++hesitationCount)+" times");
    }
    
    public void onClick(){
    	logger.error("oh god noes");
    }
    
    public Object onTravelCambodia() {
    	return cambodiaPage;
    }
    
	public Travel getTravel() {
		return new Travel("Naypyidaw",_price,"Head City");
	}

	public void onSwitchLocale(String localeCode) {
        _localizationSetter.setLocaleFromLocaleName(localeCode);
    }
	

	
}
