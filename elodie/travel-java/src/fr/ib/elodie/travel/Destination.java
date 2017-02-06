package fr.ib.elodie.travel;

/**
 * A travel destination for the USA
 * @author Elodie
 * @since 2017-02-02
 */
public class Destination {
	public static final int DEFAULT_DAYS = 7;
	
	//Variables d'instance
	protected String name, state; 
	protected int days;
	
	//Constructeurs
	public Destination() {
		this(null, null, DEFAULT_DAYS);
	}
	
	/**
	 * Constructor with<u> all fields</u>
	 * @param n Name of the new Destination
	 * @param s State of the new Destination
	 * @param d Number of days during the new Destination
	 */
	public Destination(String n, String s, int d) {
		this.name = n;
		this.state = s;
		this.days = d;
	}
	
	//Accesseurs
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
	
	public float getWeeks(){
		return days/7;
	}

	//Autres méthodes
	public void extend(int d) {
		days = days + d;
	}

	public String toString() {
		return name + " in " + state + " during " + days + " days";
	}

}
