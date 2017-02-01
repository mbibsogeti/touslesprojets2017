
public class CostalDestination extends Destination {

	private String boat;
	
	

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

	public String getBoat() {
		return boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}
	
	public String toString(){
		
		if(boat!=null && !boat.equals("")){
			return super.toString()+" Vous voguerez sur le "+boat+".";
		}else{
			return super.toString();
		}
		
	}
}
