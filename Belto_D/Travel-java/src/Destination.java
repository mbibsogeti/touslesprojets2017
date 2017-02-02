/**
 * 
 */

/**
 * @author ib
 *
 */

public class Destination {
	// Declaration d'une constante dans Java (le jour fixé à 15 par exemple)-permet d'éviter des valeurs en dur
	public static final int Default_days=15;
	// declaration du constructeur Destination vide, sans variable
	Destination() {
	// apel a l'autre constructeur avec 3 paramètres
		this(null,null,Default_days);
	/*	String Name = null;
		String State = null;
		int days = 0;*/
	};

	// nouvelle declaration du destructeur, cette fois-ci avec des variables
	Destination(String n, String s, int da) {
		Name = n;
		State = s;
		days = da;
	};

	 private String Name, State;
	 private int days;
// fonction supprimer la fonction
	public void emptyName() {
		Name = "";
	};
	// ajoute une fonction Augementer de "extend" exemple extend (6)=augementer
	// de 6 jours
	public void extend(int d) {
		days += d;
	};
	// Affichage du résultat apres extend
	public String toString() {
		return days + " " + State + " " + Name;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	};
	public int getWeeks(){
	return days/7;	
	};
}
