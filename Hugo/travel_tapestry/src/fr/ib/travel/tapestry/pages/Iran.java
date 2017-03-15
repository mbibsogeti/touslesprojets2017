package fr.ib.travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.ib.travel.jbeans.Travel;

public class Iran {

	public Travel getDiscount() {

		return new Travel("Teheran", 60, "Viaje al corazon de Iran");

	}
	
	public List<Travel> getTravels(){
		ArrayList<Travel> viajes = new ArrayList<Travel>();
		viajes.add(new Travel("Persépolis",50,"Viaje a otra ciuda iranesa"));
		viajes.add(new Travel("Chiraz",80,"Viaje a otra ciuda iranesa2"));
		viajes.add(new Travel("Ispahan",54,"Viaje a otra ciuda iranesa3"));
		return viajes;
	}

	@Property private Travel travel;
	
	@Property private long i;
	
	public long getIPlus1(){
		return i+1;
	}
	
	public double getRialPrice(){
		return 34585*travel.getPrice();
	}
	
	//appel des fonctions booléennes toujours avec is...
	public boolean isCheap(){
		return travel.getPrice()<70;
	}
}
