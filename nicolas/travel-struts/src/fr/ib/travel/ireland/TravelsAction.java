package fr.ib.travel.ireland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

//Action support est une classe défini dans struts, succes est une
// constante , et l'ensemble renvoi une chainre de caratèrere
public class TravelsAction {
	public String execute() {
		return ActionSupport.SUCCESS;
	}

	// javascript on aurai [{...,......}] enfin des objets

	public List<Map<String, String>> //
			getTravels() {

		List<Map<String, String>> l = new ArrayList<>(); // création de liste en
															// java (ici de map
															// : dico du dessous
															// )
		Map<String, String> V1 = new HashMap<>(); // création de dictionnaire en
													// java

		V1.put("location", "dublin");
		V1.put("days", "12");
		V1.put("accomodation", "hotel");
		l.add(V1);

		Map<String, String> V2 = new HashMap<>(); // création de dictionnaire en
													// java

		V2.put("location", "doublin");
		V2.put("days", "24");
		V2.put("accomodation", "camping");
		l.add(V2);

		// création de dictionnaire en
		// java
		Map<String, String> V3 = new HashMap<>(); //

		V3.put("location", "triplelin");
		V3.put("days", "36");
		V3.put("accomodation", "tente");
		l.add(V3);
		return l;
	}

}
