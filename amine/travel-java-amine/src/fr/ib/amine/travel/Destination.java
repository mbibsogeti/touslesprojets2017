package fr.ib.amine.travel;

class Destination {
	private String name, state;
	private int days;
	public static final int DEFAULT_DAYS=16;
	Destination() {
		setName(null);
		setState(null);
		//setDays(0);
		days=DEFAULT_DAYS;
	}

	/*
	 * Destination() { this(null, null, 5); }
	 */

	
	  Destination(String n, String s, int d) {
	  
	  name = n; state = s; days = d; }
	 

	public void extend(int d) {
		setDays(getDays() + d);
	}

	public String toString() {
		return getName() + " au " + getState() + " pour une durée de: " + getDays() + " jours";
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

	public int getWeeks() {
		return days / 7;
	}
}
