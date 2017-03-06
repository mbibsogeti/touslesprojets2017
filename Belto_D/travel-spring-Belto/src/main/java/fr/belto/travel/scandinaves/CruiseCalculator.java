package fr.belto.travel.scandinaves;

public class CruiseCalculator {
// ces deux prix sont déjà initialisés dans spring.xlm property du Cruisecalculator
// prix1=340 euros
// prix2=220.90 euros
	double prix1;
	double prix2;
	 
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

	// on déclare une énumération dans java (1er utilisation)
	public enum Location {
		Bergen, Malmo, Helsinki
	}

	// on utilise location comme un type
	private Location origin, destination;

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
		double prix = 0;
		if (origin == Location.Bergen) {
			if (destination == Location.Bergen)
				prix += 0;
			else if (destination == Location.Malmo)
				prix = prix1;
			else
				prix =prix1+prix2;
			}
		if (origin == Location.Malmo) {
			if (destination == Location.Malmo)
				prix += 0;
			else if (destination == Location.Bergen)
				prix = prix1;
			else
				prix = prix2;
		}
		if (origin == Location.Helsinki) {
			if (destination == Location.Malmo)
				prix = prix2;
			else if (destination == Location.Bergen)
				prix = prix1+prix2;
			else
				prix += 0.00;
		}
		return prix;
	}
}
