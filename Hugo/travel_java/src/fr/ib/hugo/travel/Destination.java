package fr.ib.hugo.travel;

public class Destination {

	public static final int D_DAYS = 3;
	public static final String D_NAME = "no destination";
	public static final String D_STATE = "no where";
	private String name;
	private String state;
	private int days;
 
	public Destination() {
		this(D_NAME, D_STATE, D_DAYS);
	}

	public Destination(String _name, String _state, int _days) {
		name = _name;
		state = _state;
		days = _days;
	}

	public void extend(int _days) {
		days = days + _days;
	}

	public String toString() {
		return ("Destination: " + name + " dans l'état du " + state + ". Durée conseillée du séjour: " + days
				+ " jours");
	}

	public int getWeeks() {
		return days / 7;
	}

	public String getName() {
		return name;
	}

	public void setName(String _name) {
		this.name = _name;
	}

	public String getState() {
		return state;
	}

	public void setState(String _state) {
		this.state = _state;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int _days) {
		this.days = _days;
	}

}
