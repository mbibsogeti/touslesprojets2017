package fr.ib.travel.ireland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction extends ActionSupport {
	public String execute() {
		return ActionSupport.SUCCESS;
	}

	public List<Map<String, String>>

		getTravels() {
		List<Map<String, String>> liste = new ArrayList<>();
		
		Map<String, String> v1 = new HashMap<>();
		v1.put("location", "Dublin");// les 3 lignes v sont chacune des dictionnaires et liste est une BD contenant toutes ces données
		v1.put("days", "12");
		v1.put("accomodation", "hotel");
		liste.add(v1);
		
		Map<String, String> v2 = new HashMap<>();
		v2.put("location", "Cork");
		v2.put("days", "9");
		v2.put("accomodation", "chambre d'hotes");
		liste.add(v2);
		
		Map<String, String> v3 = new HashMap<>();
		v3.put("location", "Limerick");
		v3.put("days", "15");
		v3.put("accomodation", "hébergement gratuit");
		liste.add(v3);
		
		Map<String, String> v4 = new HashMap<>();
		v4.put("location", "Belfast");
		v4.put("days", "10");
		v4.put("accomodation", "Camping sauvage");
		liste.add(v4);
		
		return liste;
	}

}
