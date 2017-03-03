package ireland;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction extends ActionSupport{
	public String execute(){
		
		return ActionSupport.SUCCESS;
	}
	
	public List<Map<String,String>> getTravels(){
		//Déclaration de ma liste de dictionnaire
		List<Map<String,String>> listTravels = new ArrayList<>();
		
		Map<String,String> dicTravel = new TreeMap<>();
		
		dicTravel.put("location", "Dublin");
		dicTravel.put("days", "12");
		dicTravel.put("accomodation", "Hotel");
		listTravels.add(dicTravel);
		dicTravel= new TreeMap<>();
		dicTravel.put("location", "Cork");
		dicTravel.put("days", "12");
		dicTravel.put("accomodation", "Hotel");
		listTravels.add(dicTravel);
		dicTravel= new TreeMap<>();
		dicTravel.put("location", "Galway");
		dicTravel.put("days", "12");
		dicTravel.put("accomodation", "Chez l'habitant");
		listTravels.add(dicTravel);
		dicTravel= new TreeMap<>();
		dicTravel.put("location", "Limerick");
		dicTravel.put("days", "12");
		dicTravel.put("accomodation", "Camping Sauvage");
		listTravels.add(dicTravel);
		dicTravel= new TreeMap<>();
		dicTravel.put("location", "Belfast");
		dicTravel.put("days", "12");
		dicTravel.put("accomodation", "Hotel");
		listTravels.add(dicTravel);
		System.out.println("test");
		return listTravels;
	}
}
