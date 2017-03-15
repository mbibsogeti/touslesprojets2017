package travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import travel.tapestry.beans.Travel;
import travel.tapestry.services.SEAsiaPriceService;

public class Cambodia {

	private double price;
	
	@Inject
	SEAsiaPriceService pr; 
	 
	public Travel getTravel() {
		return new Travel("Battambang","Let's go there! Let's go there! Let's go there! Let's go there! Let's go there! Let's go there! Let's go there! ",pr.getCambodiaPrice());
	}
	
	@SetupRender public void init() {
		price = pr.getCambodiaPrice();
	}
}
