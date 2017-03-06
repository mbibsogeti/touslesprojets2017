package fr.ib.travel.irelande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction {
	
	public String execute(){
		return ActionSupport.SUCCESS;	
	}

	public List<Map<String,String>> getTravels() {
		List<Map<String,String>> l = new ArrayList<>();
		
		Map<String,String> m1 = new HashMap<>();
		m1.put("location", "Dublin");
		m1.put("days", "12");
		m1.put("accomodation", "hotel");
		l.add(m1);
		
		Map<String,String> m2 = new HashMap<>();
		m2.put("location", "Cork");
		m2.put("days", "15");
		m2.put("accomodation", "b&b");
		l.add(m2);
		
		Map<String,String> m3 = new HashMap<>();
		m3.put("location", "Galway");
		m3.put("days", "10");
		m3.put("accomodation", "campsite");
		l.add(m3);
		
		Map<String,String> m4 = new HashMap<>();
		m4.put("location", "Limerick");
		m4.put("days", "6");
		m4.put("accomodation", "out");
		l.add(m4);
		
		return l;
	}
	
}