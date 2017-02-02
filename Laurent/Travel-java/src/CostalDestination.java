
//Class permettant de définir une destination maritime au sein des offres de notre agence de voyage
public class CostalDestination extends Destination {

	// ATTRIBUTS
	private String boat;
	
	// CONSTRUCTEURS
	public CostalDestination(String b) {
		super();
		boat=b;
	}

	public CostalDestination(String n, String s, int d) {
		super(n, s, d);
		boat="";
	}
	
	public CostalDestination(String n, String s, int d,String b) {
		super(n, s, d);
		boat=b;
	}

	// ACCESSEURS
	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}
	
	// METHODES
	public String toString(){
		
		if(boat!=null && !boat.equals("")){
			return super.toString()+" Vous voguerez sur le "+boat+".";
		}else{
			return super.toString();
		}
		
	}
}
