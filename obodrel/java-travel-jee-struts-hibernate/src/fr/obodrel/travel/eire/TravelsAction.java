package fr.obodrel.travel.eire;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction {
	public List<Map<String, String>> getTravels() {
		List<Map<String, String>> travelList  = new ArrayList<Map<String, String>>();
		
		for(int i=0;i<4;i++) {
			HashMap<String,String> tmpTravel = new HashMap<String,String>();

			tmpTravel.put("location", "Dublin");
			tmpTravel.put("days", "12");
			tmpTravel.put("accomodation", "hotel");
			
			travelList.add(tmpTravel);
		}	

		travelList.get(1).put("location", "Cork");
		travelList.get(2).put("location", "Limericdk");
		travelList.get(3).put("location", "Belfast");
		
		
		return travelList;
	}
	public String execute() {
		return ActionSupport.SUCCESS;
	}
}
