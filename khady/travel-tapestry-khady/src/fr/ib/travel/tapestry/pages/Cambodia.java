package fr.ib.travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.ib.travel.tapestry.beans.Travel;
import fr.ib.travel.tapestry.services.SEAsiaPriceService;

public class Cambodia {
	private Travel travel;

@Inject SEAsiaPriceService pr;	
public Travel getTravel(){
	return new Travel("Ankor Vat", price,"Promenade en Bâteau");
}

/* @SetupRender public void init() veut dire appelle cette fonction avant de faire le rendu*/
@SetupRender public void init(){	
	price = pr.getCambodiaPrice();
}
private double price;

}
