package fr.obodrel.travel.pages;

import java.util.Locale;

import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.InjectComponent;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.corelib.components.Zone;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.LocalizationSetter;

import fr.obodrel.travel.beans.Travel;
import fr.obodrel.travel.services.SEAsiaPriceService;

@Import(module="korea")
public class Korea {

	@Property
	private int idx;
	@Property
	private String currText;
	
    @Inject
    @Property
    private Locale currentLocale;
    
    @Inject
    private LocalizationSetter _localizationSetter;

    @InjectComponent
    @Property
    private Zone zoneRefreshed;
    
    @Property
    private String zoneText;

    @Property
    private String [] allTexts;

    @Property
    private String [] allTextsHeaders;
    
    public Korea() {
    	allTextsHeaders = new String[]{"country","areas","travel","register","foobar"};
    	allTexts = new String[]{"The Country","Touristicals Areas","Your Travel","Register on website","Toto tata"};
    	zoneText = "The Country";
    }
    
    @Inject
    private SEAsiaPriceService priceService;
    
    private double _price;
    
    @SetupRender
    public void init() {
    	_price = priceService.getKoreaPrice();
    }
    
	public Travel getTravelHead() {
		return new Travel("Seoul",_price,"Head City");
	}

	public void onSwitchLocale(String localeCode) {
        _localizationSetter.setLocaleFromLocaleName(localeCode);
    }

	public Object onRefreshZone(String zoneNumber){
//		System.out.println(allTexts[0]);
		zoneText = allTexts[Integer.parseInt(zoneNumber)];
		return zoneRefreshed.getBody();
	}
	
	public String getPrimary(String btnName) {
		System.out.println(btnName);
		if(zoneText.toLowerCase().contains(btnName.toLowerCase())) {
			return "btn-primary";
		}
		return "";
	}
	
	public String getTextByNumber(int number) {
		return allTexts[number];
	}
}
