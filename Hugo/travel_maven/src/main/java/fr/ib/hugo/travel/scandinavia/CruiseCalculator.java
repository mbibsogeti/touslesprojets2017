package fr.ib.hugo.travel.scandinavia;

public class CruiseCalculator {

	public enum Location {
		BERGEN, MALMO, HELSINKI;
	}

	private Location origin, destination;
	private double prix1,prix2;

	public double getPrix1() {
		return prix1;
	}

	public void setPrix1(double prix1) {
		this.prix1 = prix1;
	}

	public double getPrix2() {
		return prix2;
	}

	public void setPrix2(double prix2) {
		this.prix2 = prix2;
	}

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getDestination() {
		return destination;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public double getPrice() {
		if (origin == Location.BERGEN & destination == Location.MALMO) {
			return prix1;
		}
		
		if (origin == Location.BERGEN & destination == Location.HELSINKI) {
			return prix1+prix2;
		}
		
		if (origin == Location.MALMO & destination == Location.HELSINKI) {
			return prix2;
		}
		
		if (origin == Location.MALMO & destination == Location.BERGEN) {
			return prix1;
		}
		
		if (origin == Location.HELSINKI & destination == Location.MALMO) {
			return prix2;
		}
		
		if (origin == Location.HELSINKI & destination == Location.BERGEN) {
			return prix1+prix2;
		}
		
		else {
			return 0;
		}
	}	
}
