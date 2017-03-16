package fr.ib.travel.tapestry.pages.Iran;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.ib.travel.tapestry.beans.Travel;

public class Iran {
	
	@Property private int i;
	private Travel travel;

	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	public int getIPlusOne() {
		return i+1;
	}
	
	public Travel getDiscount(){
		return new Travel("Promo Persepolis", "4jours/3nuits", 860);
	}
	
	public List<Travel> getTravels(){
		List<Travel> l = new ArrayList<>();
		l.add(new Travel("Téhéran", "3jours/3nuits",840));
		l.add(new Travel("Persepolis", "4jours/3nuits",980));
		l.add(new Travel("Chiraz", "5jours/4nuits",1020));
		l.add(new Travel("Ispahan", "4jours/4nuits",990));
		return l;
	}
	
	public double getRialPrice(){
		return 34585*travel.getPrice();
	}
	
	public boolean isOpportunity(){
		if (travel.getPrice()<1000){
			return true;
		}
		else
			return false;
	}
}
