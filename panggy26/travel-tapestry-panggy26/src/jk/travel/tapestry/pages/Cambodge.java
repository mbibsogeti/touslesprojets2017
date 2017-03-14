package jk.travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;
import jk.travel.beans.Travel;
import jk.travel.tapestry.services.SEAsiaPriceService;

public class Cambodge {
	
	// ATTRIBUTS //
	@Inject
	SEAsiaPriceService priceService;
	private double price;

	// MÉTHODES //
	public Travel getTravel() {
		// L'attribut price est initialisé par la méthode init
		return new Travel("Angkor Wat", price, "Construit par Suryavarman II au début du XIIe siècle.");
	} // end getTravel method
	
	// @SetupRender : Appelle la méthode au moment de préparation du rendu, avant de faire l'affichage
	@SetupRender
	public void init() {
		price = priceService.getCambodgePrice();
	} // end init method
} // end Cambodge class