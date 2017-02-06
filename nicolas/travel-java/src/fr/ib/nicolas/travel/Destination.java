package fr.ib.nicolas.travel;

public class Destination {

	public static final int DEFAULT_DAYS = 1;
	private String name, state;
	private int days;

	public Destination() {
		name = state = ""; // de base si on met rien le constructeur de java met
							// a null 0 et falst
	 
	}

	public Destination(String n) {
		name = n;
	}

	public Destination(String n, String m, int o) {
		name = n;
		state = m;// pour une init autre rédaction dans le premier construcrteur
					// mettre this(null, null,5) permet d'avoir un constructeur
					// par défaut et de renvoyer
		days = o;// en fait dans le prmier constructeur on va appeller le
					// deuxieme avec this et les parametre du deuxieme ce qui va
					// dans le deuxieme.
	} // par contre le this() doit etre au début sinon le compilateur n'en tien
		// pas compte

	public void emptyName() {
		name = "";
	}

	public void extend(int d) {

		days = days + d; // days+=d est une autre ecriture

	}

	public String toString() {

		String nametout;
		nametout = name + state;
		return nametout;

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

	public int getweeks() {
		return days / 7;
	}

	public void setDays(int days) {
		this.days = days;
	}
}
