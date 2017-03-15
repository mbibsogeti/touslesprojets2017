package fr.ib.travel.tapestry.pages;

import javax.inject.Inject;

import org.apache.tapestry5.annotations.SetupRender;

import fr.ib.travel.tapestry.beans.Travel;
import fr.ib.travel.tapestry.services.SEAsiaPriceService;

public class Cambodge {
	
	private double price;
	
	@Inject SEAsiaPriceService pr;
	public Travel getTravel(){
		return new Travel("Angkor vat","Visite du site", price);
	}
	
	
	//appel cette fonction et donc l'appel au service avant l'affichage dans la fonction au-dessus
	@SetupRender 
	public void init(){
		price = pr.getCambodgePrice();
	}

}
