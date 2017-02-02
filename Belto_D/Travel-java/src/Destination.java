/**
 * 
 */

/**
 * @author ib
 *
 */

public class Destination {
	// Declaration d'une constante dans Java (le jour fixé à 15 par
	// exemple)-permet d'éviter des valeurs en dur
	public static final int DEFAULT_DAYS = 15;
	private String name, state;
	private int days;
	// declaration du constructeur Destination vide, sans variable
	public Destination() {
	// apel a l'autre constructeur avec 3 paramètres
		this(null, null, DEFAULT_DAYS);
	/*
	 * String Name = null; String State = null; int days = 0;
	*/
	};

	// nouvelle declaration du destructeur, cette fois-ci avec des variables
	public Destination(String n, String s, int da) {
		name = n;
		state = s;
		days = da;
	};

	// fonction supprimer la fonction
	public void emptyName() {
		name = "";
	};

	// ajoute une fonction Augementer de "extend" exemple extend (6)=augementer
	// de 6 jours
	public void extend(int d) {
		days += d;
	};

	// Affichage du résultat apres extend
	public String toString() {
		return days + " " + state + " " + name;
	}

	// getters and setters(Les accesseurs)
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
	};

	// getters qui fait le calcul directement sans declaration au préalable
	public int getWeeks() {
		return days / 7;
	};
}
