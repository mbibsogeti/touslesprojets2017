package travel.tapestry.pages;






import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import javabean.Travel;
import travel.tapestry.services.SEAsiaPriceService;

public class Cambodje {
@Inject SEAsiaPriceService pr;
	public Travel getTravel() {
	
		return new Travel("newcambodje",
				"c génial a que oui ", 1002);
	} // création de la propriété discount
@SetupRender public void init(){
	price = pr.getCambodjePrice();
}
private double price;
}