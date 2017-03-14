package fr.obodrel.travel.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.obodrel.travel.beans.Travel;

public class Iran {

	@Property
	private Travel currTravel;
	@Property(read=false)
	private int idx;

	public Travel getDiscount() {
		return new Travel("Teheran",150,"Head City");
	}
	
	public List<Travel> getTravels() {
		List<Travel> listToRet = new ArrayList<Travel>();
		listToRet.add(new Travel("Teharan",150,"Head City"));
		listToRet.add(new Travel("Persepolis",1500,"City"));
		listToRet.add(new Travel("Shiraz",500,"City"));
		listToRet.add(new Travel("Ispahan",900,"City"));
		
		return listToRet;
	}
	
	public double getRihalPrice() {
		return currTravel.getPrice()*34585;
	}
	
	public int getIdx() {
		return idx +1;
	}
	
}
