/** 
 * Class permettant de définir une destination au sein des offres de notre agence de voyage
 * @author ANTOINETTE Laurent
 * @since 2017-01-31
 *
 */
public class Destination {

	// ATTRIBUTS
	public static final int DEFAULT_DAYS=7;
	private String name,state;
	private int days;
	
	// CONSTRUCTEURS
	/**
	 * Basic constructor for this class
	 */
	public Destination(){
		
		this(null,null,DEFAULT_DAYS);
	}
	/**
	 * Constructor with <u>all fields</u>
	 * @param n Name of the destination with uppercases
	 * @param s Name of the state where the destination is localise
	 * @param d Number of days of the stay to the destination
	 */
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
	/**
	 * Incrementation or decrementation of the number of days in the stay for this destination
	 * @param d Number of days which should be added to the define number of days of the stay
	 */
	public void extendDays(int d){
		
		days+=d;
	}
	
	public String toString(){
		
		String tempText = "Voyager a "+name+" de l'état "+state+" ne peut se faire que pour un séjour de "+days+" jours, soit "+getWeeks()+" semaines.";
		return tempText;
	}
}
