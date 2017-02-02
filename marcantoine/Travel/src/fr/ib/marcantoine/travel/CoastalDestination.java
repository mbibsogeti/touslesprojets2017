package fr.ib.marcantoine.travel;

public class CoastalDestination extends Destination {

	private String boat;

	public CoastalDestination() {
		this(null, null, 0, null);
	}

	// APPEL DE CONSTRUCTEUR DE LA CLASSE MERE
	public CoastalDestination(String name, String state, int days, String boat) {
		super(name, state, days);
		this.boat = boat;
	}

	// GETTERS AND SETTERS
	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	// renvoyer les caractéristiques de la destination
	public String toString() {
		return super.toString() + " sur le bateau : " + getBoat();
	}
}
