package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.jbeans.Travel;
import fr.ib.travel.tapestry.services.SEAsiaPriceService;

public class Cambodia {
	@Inject
	SEAsiaPriceService pr;

	private double price;

	@SetupRender
	public void init() {
		price = pr.getCambodiaPrice();
	}

	public Travel getTravel() {
		return new Travel("Phnom Phen", price, "Capital de Camboya");
	}
}
