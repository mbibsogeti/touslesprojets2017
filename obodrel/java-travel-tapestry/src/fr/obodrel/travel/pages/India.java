package fr.obodrel.travel.pages;

import java.util.Calendar;
import java.util.Locale;

//import org.apache.tapestry5.annotations.Log;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.LocalizationSetter;
import org.slf4j.Logger;

import fr.obodrel.travel.beans.Travel;

public class India {
	@Inject
	private Messages localizedMessages;

    @Inject
    @Property
    private Locale currentLocale;
    
    @Inject
    private Logger logger;
    
    @Inject
    private LocalizationSetter _localizationSetter;

	public Travel getTravel() {
//		logger.info("travel");
		return new Travel("New Delhi",150,"Head City");
	}

	public void onSwitchLocale(String localeCode) {
        _localizationSetter.setLocaleFromLocaleName(localeCode);
    }
	
//	@Log
	public String getMention() {
		return localizedMessages.format("mention", Calendar.getInstance().get(Calendar.YEAR));
	}

	
}
