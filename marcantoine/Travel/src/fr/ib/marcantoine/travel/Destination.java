package fr.ib.marcantoine.travel;

public class Destination {

	// ATTRIBUTS
	String name, state;
	int days;

	// METHODES
	
	// CONSTRUCTEURS
	Destination() {
		name = null;
		state = null;
		days = 0;
	}
	Destination(String n, String s, int d) {
		name = n;
		state = s;
		days = d;
	}
	
	// effacer le nom de la destination
	void emptyName() {
		name = "";
	}
	// augmenter le nombre de jours
	void extend(int d) {
		System.out.println("De combien de jours voulez-vous allonger votre séjour ?");
		days += d ;
		System.out.println(days);
	}
	// renvoyer les caractéristiques de la destination
	public String toString() {
		return days + " , " + name + " , "+ state;
	}
}
