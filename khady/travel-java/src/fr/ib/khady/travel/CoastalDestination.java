package fr.ib.khady.travel;

public class CoastalDestination extends Destination {
	private String boat;

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public String toString() {

		return super.toString() + " " + boat;
	}

	public CoastalDestination(String n, String s, int d, String b) {  // Constructeur 1

		super(n, s, d);
		boat = b;
	}

	public CoastalDestination( ){  // Constructeur 2
		this("SiliconValley", null, 21, null);
		
	}

}
