package fr.obodrel.travel.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.LocalizationSetter;

import fr.obodrel.travel.beans.Travel;
import fr.obodrel.travel.services.SEAsiaPriceService;

public class Cambodia {
	@Inject
	private Messages localizedMessages;

    @Inject
    @Property
    private Locale currentLocale;
    
    @Inject
    private LocalizationSetter _localizationSetter;
    
    @Inject
    private SEAsiaPriceService priceService;
    
    private double _price;
    
    @SetupRender
    public void init() {
    	_price = priceService.getCambodiaPrice();
    }
    
	public Travel getTravel() {
		return new Travel("Phnom Penh",_price,"Head City");
	}

	public void onSwitchLocale(String localeCode) {
        _localizationSetter.setLocaleFromLocaleName(localeCode);
    }
	

	
}
