package fr.ib.amine.travel;

public class Destination {
	String name, state;
	int days;

	/*Destination() {
		name = null;
		state = null;
		days = 0;
	}*/
	
	Destination(){
		this(null,null,5);
	}

	Destination(String n, String s, int d) {

		name = n;
		state = s;
		days = d;
	}

	public void extend(int d) {
		days += d;
	}

	public String toString() {
		return name + " au " + state + " pour une durée de: " + days + " jours";
	}

}
