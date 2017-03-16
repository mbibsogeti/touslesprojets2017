package fr.ib.travel.tapestry.pages.Cambodia;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.tapestry.beans.Travel;
import fr.ib.travel.tapestry.services.SEAsiaPriceService;

public class Cambodia {
	
	private double price;
	
	@Inject SEAsiaPriceService pr; /*injection du service pour le réutiliser. Injection possible grâce à AppModule*/
	public Travel getTravel(){
		return new Travel("Cambodge Tour", "15 jours - 7 villes étapes",(float)(price));
	}

	@SetupRender public void init(){
		price=pr.getCambodiaPrice();
	}
	
}
