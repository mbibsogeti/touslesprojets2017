package cap.jklein.travel;

public class Destination {

	// Attributs
	private String _name;
	private String _state;
	private int _days;

	// Constante
	public static final int DEFAULT_DAYS = 5;
	
	// Méthodes constructeurs
	public Destination() {
		this(null, null, DEFAULT_DAYS); // Syntaxe seulement autorisée à la 1ère ligne
	}

	public Destination(String nom, String etat, int jours) {
		_name = nom;
		_state = etat;
		_days = jours;
	}

	// Méthodes accesseurs
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public int getDays() {
		return _days;
	}

	public void setDays(int days) {
		_days = days;
	}

	// Autres méthodes
	public int getWeeks() {
		return _days / 7;
	}

	public void extend(int d) { // Ajoute d jour(s) au voyage
		_days += d;
	}

	public String toString() {
		return "Voyage de " + _days + " jours à destination de " + _name + " dans l'état du " + _state;
	}

}