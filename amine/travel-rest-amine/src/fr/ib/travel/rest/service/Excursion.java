package fr.ib.travel.rest.service;

public class Excursion {
	
	public Excursion(String location, int dangerosity) {
		super();
		this.location = location;
		this.dangerosity = dangerosity;
	}
	String location;
	int dangerosity;
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
