package cruise;

public class CruiseCalculator {

	public enum Location {
		BERGEN, MALMÖ, HELSINKI
	}

	private double P1;
	private double P2;
	private double p;
	private Location origin, destination;

	public double getPrice() {
		if (origin == destination) {
			p = 0;
		} else {
			if (origin == Location.BERGEN) {
				if (destination == Location.HELSINKI) {
					p=P1+P2;
				} else {
					p=P1;
				}
			} else {
				if (origin == Location.MALMÖ) {
					if (destination == Location.HELSINKI) {
						p=P2;
					} else {
						p=P1;
					}
				} else {
					if (origin == Location.HELSINKI) {
						if (destination == Location.MALMÖ) {
							p=P1;
						} else {
							p = P1+P2;
						}
					}
				}
			}
		}
		return p ;
	}

	public double getP1() {
		return P1;
	}

	public void setP1(double p1) {
		P1 = p1;
	}

	public double getP2() {
		return P2;
	}

	public void setP2(double p2) {
		P2 = p2;
	}

	public double getP() {
		return p;
	}

	public void setP(double p) {
		this.p = p;
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

}
