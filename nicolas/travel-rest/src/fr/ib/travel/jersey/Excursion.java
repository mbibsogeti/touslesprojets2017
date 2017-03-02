package fr.ib.travel.jersey;

public class Excursion {
	String location;
	int dangerosity;
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the dangerosity
	 */
	public int getDangerosity() {
		return dangerosity;
	}
	/**
	 * @param dangerosity the dangerosity to set
	 */
	public void setDangerosity(int dangerosity) {
		this.dangerosity = dangerosity;
	}
	public Excursion(String location, int dangerosity) {
		super();
		this.location = location;
		this.dangerosity = dangerosity;
	}
	
	
}


	