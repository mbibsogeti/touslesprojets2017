package ireland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction extends ActionSupport {
	
	public List<Map<String, String>> getTravels() {
		// interface (List, Map) qui déclare, puis implémentation avec HashMap
		// et ArrayList.
		// création d'une liste de dictionnaires :
		List<Map<String, String>> l = new ArrayList<>();
		// création dictionnaire (NB : pour mettre un chiffre au nbr de jours,
		// il aurait fallu remplacer String par Object)
		Map<String, String> v1 = new HashMap<>();
		v1.put("location", "Dublin");
		v1.put("days", "7");
		v1.put("accomodation", "hotel");
		l.add(v1);
		Map<String, String> v2 = new HashMap<>();
		v2.put("location", "Cork");
		v2.put("days", "12");
		v2.put("accomodation", "boat");
		l.add(v2);
		Map<String, String> v3 = new HashMap<>();
		v3.put("location", "Limerick");
		v3.put("days", "10");
		v3.put("accomodation", "hotel");
		l.add(v3);
		Map<String, String> v4 = new HashMap<>();
		v4.put("location", "Belfast");
		v4.put("days", "9");
		v4.put("accomodation", "out");
		l.add(v4);
		Map<String, String> v5 = new HashMap<>();
		v5.put("location", "Galway");
		v5.put("days", "6");
		v5.put("accomodation", "boat");
		l.add(v5);
		Map<String, String> v6 = new HashMap<>();
		v6.put("location", "Waterford");
		v6.put("days", "15");
		v6.put("accomodation", "B&B");
		l.add(v6);
		return l;

	}

	public String execute() {
		// ActionSupport est une classe, SUCCESS est une constante dans cette
		// classe
		return ActionSupport.SUCCESS;
	}

}
