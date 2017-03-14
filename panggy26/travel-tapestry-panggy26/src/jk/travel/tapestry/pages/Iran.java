package jk.travel.tapestry.pages;

import java.util.ArrayList;
import org.apache.tapestry5.annotations.Property;
import jk.travel.beans.Travel;

public class Iran {
	
	// ATTRIBUTS //
	// Pour la boucle dans le fichier .tml
	@Property
	private Travel i;
	
	@Property
	private int ind;
	
	public Travel getDiscount() {
		return new Travel("Téhéran", 600, "capitale iranienne");
	} // end getTravels method
	
	public ArrayList<Travel> getTravels() {
		ArrayList<Travel> listeVoyages = new ArrayList<Travel>();
		listeVoyages.add(new Travel("Téhéran", 1200, "capitale iranienne"));
		listeVoyages.add(new Travel("Chiraz", 800, "viiiiens ! On est bienbienbien"));
		listeVoyages.add(new Travel("Ispahan", 950, "trop beau"));
		return listeVoyages;
	} // end getTravels method
	
	public int getIndPlusUn() {
		return ind + 1;
	}
	public double getRialPrice() {
		return 34585 * i.getPrice();
	}
} // end Iran class