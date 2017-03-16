package fr.belto.travel.tapestry.pages;

import org.apache.tapestry5.annotations.SetupRender;
import org.apache.tapestry5.ioc.annotations.Inject;

import fr.belto.travel.tapestry.services.SEAsiaPriceService;
import fr.travel.java.bean.Travel;

public class Cambodia {
@Inject SEAsiaPriceService pr;
public Travel getTravel(){
return new Travel("SihanoukVille", price, "Ville touristique");
}
//utilisation de SetupRender
@SetupRender public void init(){
price=pr.getCambodiaPrice();
}
private double price;

}