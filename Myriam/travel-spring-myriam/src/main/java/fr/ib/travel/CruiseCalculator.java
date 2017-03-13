package fr.ib.travel;

public class CruiseCalculator {

	public enum Location {
		BERGEN, MALMO, HELSINKI
	}

	private Location origin, destination;

	private double p1,p2;
	private double p;

	public double getPrice() {

		if ((origin == Location.BERGEN && destination == Location.MALMO)
				|| (destination == Location.BERGEN && origin == Location.MALMO))
			p = p1;
		else if ((origin == Location.BERGEN && destination == Location.HELSINKI)
				|| (destination == Location.BERGEN && origin == Location.HELSINKI))
			p = p1+p2;
		else if ((origin == Location.MALMO && destination == Location.HELSINKI)
				|| (destination == Location.MALMO && origin == Location.HELSINKI))
			p = p2;
		else
			p = 0;

		return p;

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

	public double getP1() {
		return p1;
	}

	public void setP1(double p1) {
		this.p1 = p1;
	}

	public double getP2() {
		return p2;
	}

	public void setP2(double p2) {
		this.p2 = p2;
	}

	
}

