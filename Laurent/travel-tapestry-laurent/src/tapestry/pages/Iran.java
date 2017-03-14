package tapestry.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.tapestry5.annotations.Property;

import tapestry.beans.Travel;

public class Iran {

	@Property
	private Travel travel;
	
	@Property
	private int i=1;
	
	//Crée un voyage
	public Travel getDiscount(){
		String desc="Téhéran est la capitale de l'Iran. Située au nord du pays, au pied des monts Elbourz, la ville donne son nom à la province dont elle est également la capitale. Téhéran a vu sa population multipliée par 40 depuis qu'elle est devenue la capitale à la suite du changement de dynastie de 1786. En 2015, la ville représente environ 9 000 000 habitants ; et l'agglomération plus de 15 000 000. La ville possède un métro (actuellement avec 5 lignes) et un dense réseau autoroutier.";
		return new Travel("Téhéran",1285.62,desc);
	}
	
	//Crée une liste de voyage
	public List<Travel> getTravels(){
		List<Travel> travels = new ArrayList<Travel>();
		travels.add(new Travel("Téhéran",1285.62,"Téhéran est la capitale de l'Iran. Située au nord du pays, au pied des monts Elbourz, la ville donne son nom à la province dont elle est également la capitale. Téhéran a vu sa population multipliée par 40 depuis qu'elle est devenue la capitale à la suite du changement de dynastie de 1786. En 2015, la ville représente environ 9 000 000 habitants ; et l'agglomération plus de 15 000 000. La ville possède un métro (actuellement avec 5 lignes) et un dense réseau autoroutier."));
		travels.add(new Travel("Persepolis",1112.69,"..."));
		travels.add(new Travel("Chiraz",1212.62,"..."));
		travels.add(new Travel("Ispahan",969.62,"..."));
		return travels;
	}
	
	//Renvoie le prix en rial
	public double getRialPrice(){
		return (34585*travel.getPrice()/(Math.pow(10, 6)));
	}
	
	//Test sur le prix
	public boolean getEcoStatus(){
		boolean eco=false;
		if(travel.getPrice()<=1000d)eco=true;
		return eco;
	}
}
