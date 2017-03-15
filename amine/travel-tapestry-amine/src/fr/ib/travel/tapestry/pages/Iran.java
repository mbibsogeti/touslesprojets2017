package fr.ib.travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.ib.travel.tapestry.travel.Travel;

public class Iran {
	@Property
	private Travel travel;
	@Property
	private int i;

	public Travel getDiscount() {
		return new Travel("Chiraz", "Sud-Ouest", 1250);
	}

	public List<Travel> getTravels() {
		List<Travel> l = new ArrayList<Travel>();
		l.add(new Travel("Téhéran", "Capitale", 1500));
		l.add(new Travel("Persepolis", "ville", 999.99));
		l.add(new Travel("Chiraz", "ville", 1250));
		l.add(new Travel("Ispahan", "ville", 1999.99));
		return l;
	}

	// conversion du prix en monnaie iranienne
	public double getRialPrice() {
		return 34585 * travel.getPrice();
	}

	public int getIPlusOne() {
		return i + 1;
	}

	public boolean isCheap() {
		return travel.getPrice() < 1300;
	}
}
