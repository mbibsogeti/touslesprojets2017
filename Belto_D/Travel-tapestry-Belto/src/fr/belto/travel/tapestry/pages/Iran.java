package fr.belto.travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import fr.travel.java.bean.Travel;

public class Iran {
	public Travel getDiscount(){
	 	return new Travel("Téhéran",400,"Capitale");	 	
	};
// une fonction retournant un boolean
	public boolean isCheap(){
		return travel.getPrice()<600;
	}

public List<Travel> getTravels(){
 		List<Travel> l= new ArrayList<>();
 		l.add(new Travel("Perpolis",600, "Ville du nord"));
 		l.add(new Travel("Chiraz",550, "Ville du sud"));
 		l.add(new Travel("Ispahan",800, "Ville du sud"));
 		l.add(new Travel("Kashan",650, "Ville du centre"));
 		l.add(new Travel("Quom",700, "Ville du centre"));
 		return l;
 		
	}

// pour lui permettre de trouver travel, cette synthaxe remplace les getters et setters
// travel est un attribut de type Travel
// on crée une propriété Travel
@Property private Travel travel;
@Property private int i;
public int getIplus1(){
	return i+1;
}
public double getRialPrice(){
return 34585*travel.getPrice();
}
}


