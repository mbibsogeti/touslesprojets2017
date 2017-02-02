package fr.ib.marcantoine.travel;

public class Destination {

	// ATTRIBUTS
	public static final int FIXED_DAYS = 7;
	private String name, state;
	private int days;

	// METHODES
	
	// CONSTRUCTEURS
	public Destination() {
		this (null, null, 0);
	}
	public Destination(String name, String state, int days) {
		this.name = name;
		this.state = state;
		this.days = days;
	}
	
	// effacer le nom de la destination
	public void emptyName() {
		name = "";
	}
	// augmenter le nombre de jours
	public void extend(int d) {
		System.out.println("De combien de jours voulez-vous allonger votre séjour ?");
		days += d ;
		System.out.println(days);
	}
	// renvoyer les caractéristiques de la destination
	public String toString() {
		return days + " jours, à " + name + " dans l'état "+ state;
	}
	
	//GETTERS AND SETTERS
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
		return days/7;
	}
	
}
