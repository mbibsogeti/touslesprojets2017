package fr.ib.spring.khady;

public class CruiseCalculator {
	
    private double priceBM ;
    private double priceMH ;
    
	public enum Location {
		BERGEN, MALMO, HELSINKI
	}
 
	public double getPriceBM() {
		return priceBM;
	}

	public void setPriceBM(double priceBM) {
		this.priceBM = priceBM;
	}

	public double getPriceMH() {
		return priceMH;
	}

	public void setPriceMH(double priceMH) {
		this.priceMH = priceMH;
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
		double priceBH = priceBM + priceMH ;
		if(origin == Location.BERGEN && destination == Location.MALMO)
		   return priceBM;
		
		if(origin == Location.BERGEN && destination == Location.HELSINKI)
			return priceBH;
			
		if(origin == Location.MALMO && destination == Location.HELSINKI)
			return priceMH;
		
		if(origin == Location.HELSINKI && destination == Location.MALMO)
			return priceMH;

		if(origin == Location.HELSINKI && destination == Location.BERGEN)
			return priceBH;
		
		if(origin == Location.MALMO && destination == Location.BERGEN)
			return priceBM;
		return 0;
		
	}
	
	
	
}
