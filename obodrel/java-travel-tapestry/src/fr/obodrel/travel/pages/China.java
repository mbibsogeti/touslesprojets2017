package fr.obodrel.travel.pages;

import java.io.File;
import java.util.Locale;

import org.apache.tapestry5.ValidationException;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.LocalizationSetter;
import org.apache.tapestry5.upload.services.UploadedFile;

import fr.obodrel.travel.beans.Travel;
import fr.obodrel.travel.services.SEAsiaPriceService;

public class China {

	@Property
	private Travel currTravel;

    @Inject
    @Property
    private Locale currentLocale;
    
    @Inject
    private LocalizationSetter _localizationSetter;
    
    @Inject
    private SEAsiaPriceService priceService;
    
    private double _price;
    
    @Persist
    @Property
    private String name;
    @Persist
    @Property
    private String telephoneNumber;
    @Persist
    @Property
    private int travellers;
    @Property
    private UploadedFile visa;
    
    @InjectPage
    private Index indexPage;
    
    @SetupRender
    public void init() {
    	_price = priceService.getCambodiaPrice();
    }

	public Travel getTravel() {
		return new Travel("Beijing",_price,"Head City");
	}

	public void onSwitchLocale(String localeCode) {
        _localizationSetter.setLocaleFromLocaleName(localeCode);
    }
	
	public void onPrepare() {
		System.out.println("Preparation");
	}
	
	public void onValidate() {
		//System.out.println("Validation");
	}
	
	private boolean areAllNumberTheSame(String telNumber) {
		String currentChar = "";
		String tmpValue = telNumber;
		
		if(telNumber == null || telNumber.isEmpty() || telNumber.length() <2) {
			return true;
		}
		
		if(telNumber.startsWith("+")) {
			tmpValue = telNumber.substring(1);
		}
		
		currentChar = tmpValue.substring(0,1);
		
		for(int i = 1;i<tmpValue.length();i++) {
			if(tmpValue.substring(i,i+1).equals(" ")) {
				continue;
			}
			if(!tmpValue.substring(i,i+1).equals(currentChar)) {
				return false;
			}
		}
		return true;
	}
	
	public void onValidateFromTelephoneNumber(String value) throws ValidationException {
		if(areAllNumberTheSame(value)) {
			throw new ValidationException("All numbers are the same!");
		}
	}

	private boolean isExtensionNotSupported(UploadedFile value) {
		String extension = value.getFileName().substring(value.getFileName().lastIndexOf("."));
		
		if(extension.equals(".exe")) {
			return true;
		}
		return false;
	}
	
	public void onValidateFromVisa(UploadedFile value) throws ValidationException {
		if(value != null && isExtensionNotSupported(value)) {
			throw new ValidationException("Extension not supported : "+value.getFileName().substring(value.getFileName().lastIndexOf(".")));
		}
	}
	
	public Object onSuccess() {
		String extension = "";
		System.out.println("Success");
		System.out.println("Name = "+name);
		System.out.println("telephoneNumber = "+telephoneNumber);
		System.out.println("travellers = "+travellers);
		System.out.println("visa = "+visa);
		if(visa != null) {
			extension = visa.getFileName().substring(visa.getFileName().lastIndexOf("."));
			if(!extension.equals(".exe")) {
				visa.write(new File(new File("c:\\users\\ib\\desktop\\dl"),"visa_"+name+extension));
			} else {
				System.out.println("File not supported "+extension);
			}
		}
		
		return indexPage;
	}
	
	public void onFailure() {
		System.out.println("Fail");
	}
	
	public void onSubmit() {
		System.out.println("Submit");
	}
}
