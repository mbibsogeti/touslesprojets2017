package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.tapestry.services.SEAsiaPriceService;
import fr.ib.travel.tapestry.travel.Travel;

public class Cambodge {
	@Inject
	SEAsiaPriceService pr;

	public Travel getTravel() {
		// return new Travel("Siem Reap", "Temple, vie nocturne, cyclisme et
		// éléphant", 1800);
		return new Travel("Siem Reap", "Temple, vie nocturne, cyclisme et éléphant", pr.getCambodiaPrice());
	}
	@SetupRender public void init(){
		price=pr.getCambodiaPrice();
	}
	private double price;
}
