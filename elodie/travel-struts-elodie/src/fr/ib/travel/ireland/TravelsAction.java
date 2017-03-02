package fr.ib.travel.ireland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;


public class TravelsAction {
	
	public String execute(){
		return ActionSupport.SUCCESS;
	}
	
	public List<Map<String,String>> getTravels(){
		List<Map<String,String>> l = new ArrayList<>();
		
		Map<String,String> v1 = new HashMap<>();
		v1.put("location", "Dublin");
		v1.put("days", "12");
		v1.put("accomodation", "hotel");
		l.add(v1);
		
		Map<String,String> v2 = new HashMap<>();
		v2.put("location", "Cork");
		v2.put("days", "10");
		v2.put("accomodation", "Campsite");
		l.add(v2);
		
		Map<String,String> v3 = new HashMap<>();
		v3.put("location", "Limerick");
		v3.put("days", "7");
		v3.put("accomodation", "B&B");
		l.add(v3);
		
		Map<String,String> v4 = new HashMap<>();
		v4.put("location", "Belfast");
		v4.put("days", "9");
		v4.put("accomodation", "out");
		l.add(v4);
		
		return l;
	}
}
