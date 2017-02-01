package fr.ib.amine.travel;

public class CoastalDestination extends Destination {
	private String boat;

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	public String toString() {
		return super.toString() + "\nLe nom du Bâteau est " + getBoat();

	}
	
	public CoastalDestination(String n, String s, int d, String b){
		super(n,s,d);
		boat=b;
	}
	public CoastalDestination(){
		this(null,null,5,null);
	}

}
