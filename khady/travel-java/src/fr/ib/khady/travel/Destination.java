package fr.ib.khady.travel;

public class Destination {
	public static final int DAYS = 21;// Constante
	private String name, state;
	private int days;

	public Destination() { // Constructeur 1
		this(null, null, DAYS);// constructeur 1 fait appel au constructeur 2
								// ci-dessous
	}

	public Destination(String n, String s, int d) { 
		days = d;
		name = n;
		state = s;

	}

	public void extend(int d) {
		days += d;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public int getWeeks() { // on a ajouté cet attribut sans l'avoir déclaré
							// plus haut
		return days / 7;
	}

	public String toString() {
		return "I want to go to this place: " + name + " in the" + " " + state + " for " + days + " days then "
				+ days / 7 + " " + "weeks with the boat";

	}
}
