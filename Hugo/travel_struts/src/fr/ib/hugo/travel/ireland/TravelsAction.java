package fr.ib.hugo.travel.ireland;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

public class TravelsAction {

	public String execute() {
		return ActionSupport.SUCCESS;
	}

	// liste de dictionaires Map, contenant des objets string, string
	public List<Map<String, String>> getViajes() {
		List<Map<String, String>> lista = new ArrayList<>();
		Map<String, String> viaje1 = new HashMap<>();
		viaje1.put("lugar", "Dublin");
		viaje1.put("dias", "12");
		viaje1.put("hospedaje", "hotel");
		lista.add(viaje1);
		Map<String, String> viaje2 = new HashMap<>();
		viaje2.put("lugar", "Cork");
		viaje2.put("dias", "3");
		viaje2.put("hospedaje", "bajo el puente");
		lista.add(viaje2);
		Map<String, String> viaje3 = new HashMap<>();
		viaje3.put("lugar", "Limerick");
		viaje3.put("dias", "5");
		viaje3.put("hospedaje", "en el castillo");
		lista.add(viaje3);
		return lista;
	}
}
