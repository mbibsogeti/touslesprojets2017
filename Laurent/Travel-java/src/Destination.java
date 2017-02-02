
//Class permettant de définir une destination au sein des offres de notre agence de voyage
public class Destination {

	// ATTRIBUTS
	public static final int DEFAULT_DAYS=7;
	private String name,state;
	private int days;
	
	// CONSTRUCTEURS
	public Destination(){
		
		this(null,null,DEFAULT_DAYS);
	}
	
	public Destination(String n, String s, int d){
		
		name=n;
		state=s;
		days=d;
	}
	
	// ACCESSEURS
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

	public int getWeeks(){
		return days/DEFAULT_DAYS;
	}

	// METHODES
	public void extendDays(int d){
		
		days+=d;
	}
	
	public String toString(){
		
		String tempText = "Voyager a "+name+" de l'état "+state+" ne peut se faire que pour un séjour de "+days+" jours, soit "+getWeeks()+" semaines.";
		return tempText;
	}
}
