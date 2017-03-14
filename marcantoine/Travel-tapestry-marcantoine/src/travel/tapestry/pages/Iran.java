package travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import beans.Travel;

public class Iran {

	// On crée cette propriété pour aider la machine à boucler dans l'affichage
	// du tableau.
	@Property
	private Travel travel;
	@Property
	private int i;

	public Travel getDiscount() {
		return new Travel("Persepolis",
				"A great place to experience the country, you do not have the slightest idea where you could run on unexpected tourists wandering around. Well, just let us sow you how much we like this place",
				1234);
	}

	public List<Travel> getTravels() {
		List<Travel> l = new ArrayList<>();
		l.add(new Travel("Ahar",
				"Let's travel here because it's so cool! Let's travel here because it's so cool! Let's travel here because it's so cool! Let's travel here because it's so cool! Let's travel here because it's so cool! Let's travel here because it's so cool! ",
				458486));
		l.add(new Travel("Aliabad",
				"Let's travel here because it's so nice! Let's travel here because it's so nice! Let's travel here because it's so nice! Let's travel here because it's so nice! Let's travel here because it's so nice! Let's travel here because it's so nice! ",
				4564));
		l.add(new Travel("Bijar",
				"Let's travel here because it's so bleak! Let's travel here because it's so bleak! Let's travel here because it's so bleak! Let's travel here because it's so bleak! Let's travel here because it's so bleak! Let's travel here because it's so bleak! ",
				657));
		l.add(new Travel("Gorgan",
				"Let's travel here because it's so beautiful! Let's travel here because it's so beautiful! Let's travel here because it's so beautiful! Let's travel here because it's so beautiful! Let's travel here because it's so beautiful! Let's travel here because it's so beautiful! ",
				8676));
		return l;
	}

	public double getRialPrice() {
		return 34585 * travel.getPrice();
	}
	public int getIPlusOne() {
		return i+1;
	}
}
