package fr.ib.spring.travel;

public class CruiseCalculator {
	// enum énumérateur.
	public enum Location {
		BERGEN, MALMO, HELSINKI
	}

	private Location origin, destination;
	private double bmPrice, mhPrice;

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

	/*
	 * public double getPrice() { double price = 0; if (origin ==
	 * Location.BERGEN) { if (destination == Location.MALMO) { price = 340; }
	 * else if (destination == Location.HELSINKI) { price = 340 + 220.90; } else
	 * { price = 0; } } if (origin == Location.MALMO) { if (destination ==
	 * Location.BERGEN) { price = 340; } else if (destination ==
	 * Location.HELSINKI) { price = 220.90; } else { price = 0; } } if (origin
	 * == Location.HELSINKI) { if (destination == Location.MALMO) { price =
	 * 220.90; } else if (destination == Location.BERGEN) { price = 340 +
	 * 220.90; } else { price = 0; } } return price; }
	 */
	public double getBmPrice() {
		return bmPrice;
	}

	public void setBmPrice(double bmPrice) {
		this.bmPrice = bmPrice;
	}

	public double getMhPrice() {
		return mhPrice;
	}

	public void setMhPrice(double mhPrice) {
		this.mhPrice = mhPrice;
	}

	public double getPrice() {
		double price = 0;
		if (origin == Location.BERGEN) {

			if (destination == Location.MALMO) {
				price = bmPrice;
			} else if (destination == Location.HELSINKI) {
				price = bmPrice + mhPrice;
			} else {
				price = 0;
			}
		}
		if (origin == Location.MALMO) {
			if (destination == Location.BERGEN) {
				price = bmPrice;
			} else if (destination == Location.HELSINKI) {
				price = mhPrice;
			} else {
				price = 0;
			}
		}
		if (origin == Location.HELSINKI) {
			if (destination == Location.MALMO) {
				price = mhPrice;
			} else if (destination == Location.BERGEN) {
				price = bmPrice + mhPrice;
			} else {
				price = 0;
			}
		}
		return price;
	}
}