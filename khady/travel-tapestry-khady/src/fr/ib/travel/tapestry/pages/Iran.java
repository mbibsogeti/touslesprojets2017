package fr.ib.travel.tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import fr.ib.travel.tapestry.beans.Travel;

public class Iran {
	
	public boolean isCheap(){
		return travel.getPrice()< 600;
	}
	private Travel travel;
	
	public Travel getTravel() {
		return travel;
	}

	public void setTravel(Travel travel) {
		this.travel = travel;
	}

	
	public Travel getDiscount(){
		return new Travel ("Téhéran",650d,"Promenade");
	}
	


	public double getRialPrice(){
		return 34585*travel.getPrice();
	}
	private int i;

	public int getI() {
		return i;
	}
	
	public void setI(int i) {
		this.i = i+1; /* ou alors au lieu de rajouter "+1", faire public int getIPlus1(){return i+1;} pour afficher le numéro des voyages à partir de 1 et donc ajouter la ligne 
		${iPlus1} dans iran.tml*/
	}

public List<Travel> getTravels(){
	List<Travel> list = new ArrayList<>();
	 list.add(new Travel("Hamadan",650d,"Promenade"));
	 list.add(new Travel("Kerman",575d,"Balade en rollers"));
	 list.add(new Travel("Bandar Abbas",759d,"Visite musées"));
		 
	return list;
}





}
