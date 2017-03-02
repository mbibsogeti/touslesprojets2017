package fr.ib.hugo.travel.jersey;

public class Excursion {

	String location;
	int dangerosity;
	public String getLocation() {
		return location;
	}

	public Excursion(String location, int dangerosity) {
		super();
		this.location = location;
		this.dangerosity = dangerosity;
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
