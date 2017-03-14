package travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import javabean.Travel;

public class Iran {

	public Travel getDiscount() {
		return new Travel("teheraan", "c pas cool mais on va mettre plus de caractère pour voir le description .substring marcher ", 12);
	} // création de la propriété discount

	public List<Travel> getTravels() {
		List<Travel> l = new ArrayList<Travel>();
		l.add(new Travel("téhéran", "cool", 14 ));
		l.add(new Travel("percepolis", "super cool", 11));
		l.add(new Travel("Chiraz", "uncool", 1));
		l.add(new Travel("téh", " pocool", 5));
		return l;
	}
//get travel et set travel march aussi.
	
	@Property
	private Travel travel;
	@Property
	private int i;
	
	public double getRialPrice(){return 34585*travel.getPrice();} //la fonction getRialPrice est appeler rialPrice
	public int getIplusone(){return i+1;}
	
	//en boolean on ne met pas de get ( c'est du bon anglais
	public boolean isCheap (){return getRialPrice()<300000;}
	
}