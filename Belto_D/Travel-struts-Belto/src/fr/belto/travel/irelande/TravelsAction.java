package fr.belto.travel.irelande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
// la classe d'action hérite de Action support pour les paramètre de langue
public class TravelsAction extends ActionSupport {
 public String execute(){
	 return ActionSupport.SUCCESS;
 						}
	 public List<Map<String,String>> getTravels(){// une liste de dictionnaire, Liste de Map dans java
		 List<Map<String,String>>l=new ArrayList<>();// nouvelle fonctionnalité dans java, cette liste de dictionnaire
		 Map<String,String> V1=new HashMap<>();// on crée notre dictionnaire
		 V1.put("Location","Dublin");
		 V1.put("Days", "12");
		 V1.put("Accomodation","hotel");
		 l.add(V1);// on l'ajoute à notre liste et ainsi de suite pour les autres dictionnaires!
		 
		 Map<String,String> V2=new HashMap<>();
		 V2.put("Location","Galway");
		 V2.put("Days", "15");
		 V2.put("Accomodation","ApartHotel");
		 l.add(V2);
		 
		 Map<String,String> V3=new HashMap<>();
		 V3.put("Location","Wateford");
		 V3.put("Days", "10");
		 V3.put("Accomodation","Chez l'habitant");
		 l.add(V3);
		 
		 Map<String,String> V4=new HashMap<>();
		 V4.put("Location","Cork");
		 V4.put("Days", "5");
		 V4.put("Accomodation","Auberges de Jeunesse");
		 l.add(V4);
		 return l;
 	}
}
