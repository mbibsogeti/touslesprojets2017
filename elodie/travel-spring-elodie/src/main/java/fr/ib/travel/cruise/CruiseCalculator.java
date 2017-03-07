package fr.ib.travel.cruise;

public class CruiseCalculator {
	 private Location origin, destination;
	 private double prixBergenMalmo;
	 private double prixMalmoHelsinki;

	public double getPrixBergenMalmo() {
		return prixBergenMalmo;
	}

	public void setPrixBergenMalmo(double prixBergenMalmo) {
		this.prixBergenMalmo = prixBergenMalmo;
	}

	public double getPrixMalmoHelsinki() {
		return prixMalmoHelsinki;
	}

	public void setPrixMalmoHelsinki(double prixMalmoHelsinki) {
		this.prixMalmoHelsinki = prixMalmoHelsinki;
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
	
	public double getPrice(){
		double price = 0.0;
		if(origin == Location.BERGEN)
			if(destination == Location.MALMO)
				price=prixBergenMalmo;
			else price=prixMalmoHelsinki+prixBergenMalmo;
		else if (origin == Location.MALMO)
			if (destination == Location.BERGEN)
				price=prixBergenMalmo;
			else price=prixMalmoHelsinki;
		else
			if (destination == Location.BERGEN)
				price=prixMalmoHelsinki+prixBergenMalmo;
			else price=prixMalmoHelsinki;		
		return price;
	}

}
