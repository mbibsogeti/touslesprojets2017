package fr.ib.myriam.travel;

public class Destination {
	
	public static final int DEFAULT_DAYS = 3 ;
	private String name;
	private Etat state;
	private int days;
	
	public Destination(){
		days = DEFAULT_DAYS;
	}
	
	public Destination(String _n, Etat _s, int _d){
		name = _n;
		state = _s;
		days = _d;
	}
	
	public void extend(int d){
		days = days+d;
	}
	
	public String toString(){
		String phrase = "Destination : "+name+" ("+String.valueOf(state)+"), nombre de jours : "+ String.valueOf(days);
		return phrase;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Etat getState() {
		return state;
	}

	public void setState(Etat state) {
		this.state = state;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}
	
	public int getWeeks(){
		return days/7;
	}
	
	
	


}
