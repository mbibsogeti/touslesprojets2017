package jk.travel.irlande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction {

	// MÉTHODES //
	// Ce nom de fonction est obligatoire
	public String execute() {
		// On prévient Struts que tout s'est bien déroulé
		return ActionSupport.SUCCESS;
	} // end execute method

	public List<Map<String, String>> getTravels() {
		// Initialisation de la liste de dictionnaires
		List<Map<String, String>> listeActions = new ArrayList<>();
		// Dictionnaire 1
		Map<String, String> dict1 = new HashMap<>();
		dict1.put("location", "Dublin");
		dict1.put("days", "12");
		dict1.put("accomodation", "hotel");
		listeActions.add(dict1);
		// Dictionnaire 2
		Map<String, String> dict2 = new HashMap<>();
		dict2.put("location", "Cork");
		dict2.put("days", "5");
		dict2.put("accomodation", "house");
		listeActions.add(dict2);
		// Dictionnaire 3
		Map<String, String> dict3 = new HashMap<>();
		dict3.put("location", "Limerick");
		dict3.put("days", "3");
		dict3.put("accomodation", "park");
		listeActions.add(dict3);
		// Dictionnaire 4
		Map<String, String> dict4 = new HashMap<>();
		dict4.put("location", "Galway");
		dict4.put("days", "26");
		dict4.put("accomodation", "flat");
		listeActions.add(dict4);
		// Dictionnaire 5
		Map<String, String> dict5 = new HashMap<>();
		dict5.put("location", "Waterford");
		dict5.put("days", "9");
		dict5.put("accomodation", "bed and breakfast");
		listeActions.add(dict5);
		return listeActions;
	} // end getTravels method
} // end TravelsAction class