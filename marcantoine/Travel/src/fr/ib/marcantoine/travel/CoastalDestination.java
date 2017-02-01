package fr.ib.marcantoine.travel;

public class CoastalDestination extends Destination {

	private String boat;
	
	public CoastalDestination() {
	}

	public CoastalDestination(String name, String state, int days) {
		super(name, state, days);
	}

	public String getBoat() {
		return boat;
	}
	public void setBoat(String boat) {
		this.boat = boat;
	}
	// renvoyer les caractéristiques de la destination
	public String toString() {
		return super.toString()+" sur le bateau : "+getBoat();
	}
}
