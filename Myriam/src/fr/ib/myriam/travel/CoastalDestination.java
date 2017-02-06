package fr.ib.myriam.travel;

public class CoastalDestination extends Destination {
	
	private String boat;
	
	public CoastalDestination (){
		this(null,null,5,null);
	}
	
	public CoastalDestination (String _n, Etat _s, int _d, String _b){
		super (_n,_s,_d);
		boat = _b;
	}

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}
	
	public String toString(){
		return super.toString()+" le nom du bateau est : "+ boat;
	}
	

	
}
