package fr.ib.elodie.travel;

public class CostalDestination extends Destination {
	private String boatName;
	

	public CostalDestination (String n, String s, int d, String bN){
		super(n, s, d);
		this.boatName = bN;
	}
	public CostalDestination() {
		this(null, null, 0, null);
	}
	

	public String getBoatName() {
		return boatName;
	}

	public void setBoatName(String boatName) {
		this.boatName = boatName;
	}
	
	public String toString(){
		return super.toString() + ". The boat name is " + boatName + ".";
	}
}
