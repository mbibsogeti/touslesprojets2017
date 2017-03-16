package fr.ib.travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.ib.travel.tapestry.beans.Travel;

public class Iran {
	@Property
	private Travel travel;
	
	private int i=1;
	
	public boolean isComparaison(){
		return travel.getPrice()<300;
	}
	
	public int getCompter(){
		return i++;
	}
	
	public double getRialPrice(){
		return 34585*travel.getPrice();
	}
	
	public Travel getDiscount(){
		return new Travel("Téhéran","Visite de la ville", 400.0);	
	}
	public List<Travel> getTravels(){
		List<Travel> l = new ArrayList<>();
		l.add(new Travel("Téhéran","Visite de la ville", 400.0));
		l.add(new Travel("Persepolis","Visite de la mosquée", 150.0));
		l.add(new Travel("Chiraz","Temps libre", 300.0));
		return l;
	}
}
