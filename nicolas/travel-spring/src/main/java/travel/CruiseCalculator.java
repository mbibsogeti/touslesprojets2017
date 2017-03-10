package travel;

public class CruiseCalculator {
	
	private double prixbm, prixmh;
	

	public double getPrixbm() {
		return prixbm;
	}

	
	public void setPrixbm(double prixbm) {
		this.prixbm = prixbm;
	}

	public double getPrixmh() {
		return prixmh;
	}

	public void setPrixmh(double prixmh) {
		this.prixmh = prixmh;
	}

	public enum Location {
		BERGEN, MALMO, HELSINKI
	}

	private Location origin, destination;

	public Location getOrigin() {
		return origin;
	}

	public void setOrigin(Location origin) {
		this.origin = origin;
	}

	public Location getDestination() {
		return destination;
	}

	
	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public double getPrice(){

	 double price;

	if(origin==Location.BERGEN)
	{
		if (destination == Location.HELSINKI) {
			price=prixbm+prixmh;
			
		} else {
			price=prixbm;
			return price;
		}
	}
	if(origin==Location.MALMO){
		if (destination == Location.BERGEN) {
			price = prixbm;
			return price;
		} else {
			price = prixmh;
			return price;
		}
	}if(origin==Location.HELSINKI){
		if (destination == Location.BERGEN) {
			price=prixbm+prixmh;
			return price;
		}else {
			price=prixmh;
			return price;
		}
	}else {price =0;
	return price;}
}




}

