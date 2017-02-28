package fr.ib.travel.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class Excursion {
	String location;
	int dangerosity;
	
	public Excursion(String location, int dangerosity) {
		super();
		this.location = location;
		this.dangerosity = dangerosity;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getDangerosity() {
		return dangerosity;
	}
	public void setDangerosity(int dangerosity) {
		this.dangerosity = dangerosity;
	}

	
}
