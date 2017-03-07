package cruise;

public class CruiseCalculator {

	public enum Location{
		BERGEN, MALMO, HELSINKI, OSLO, STOCKHOLM 
	}
	
	private Location origin, destination;
	private double trajetBM;
	private double trajetMH;
	private double trajetHO;
	private double trajetOS;

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
	
	public double getTrajetBM() {
		return trajetBM;
	}

	public void setTrajetBM(double trajetBM) {
		this.trajetBM = trajetBM;
	}

	public double getTrajetMH() {
		return trajetMH;
	}

	public void setTrajetMH(double trajetMH) {
		this.trajetMH = trajetMH;
	}

	public double getTrajetHO() {
		return trajetHO;
	}

	public void setTrajetHO(double trajetHO) {
		this.trajetHO = trajetHO;
	}

	public double getTrajetOS() {
		return trajetOS;
	}

	public void setTrajetOS(double trajetOS) {
		this.trajetOS = trajetOS;
	}

	public double getPrice(){
		
		switch (origin){
			case BERGEN:
				if(destination==Location.MALMO) return trajetBM;
				if(destination==Location.HELSINKI) return trajetBM+trajetMH;
				if(destination==Location.OSLO) return trajetBM+trajetMH+trajetHO;
				if(destination==Location.STOCKHOLM) return trajetBM+trajetMH+trajetHO+trajetOS;
				break;
			case MALMO:
				if(destination==Location.BERGEN) return trajetBM;
				if(destination==Location.HELSINKI) return trajetMH;
				if(destination==Location.OSLO) return trajetMH+trajetHO;
				if(destination==Location.STOCKHOLM) return trajetMH+trajetHO+trajetOS;
				break;
			case HELSINKI:
				if(destination==Location.MALMO) return trajetMH;
				if(destination==Location.BERGEN) return trajetBM+trajetMH;
				if(destination==Location.OSLO) return trajetHO;
				if(destination==Location.STOCKHOLM) return trajetHO+trajetOS;
				break;
			case OSLO:
				if(destination==Location.MALMO) return trajetMH+trajetHO;
				if(destination==Location.HELSINKI) return trajetHO;
				if(destination==Location.BERGEN) return trajetBM+trajetMH+trajetHO;
				if(destination==Location.STOCKHOLM) return trajetOS;
				break;
			case STOCKHOLM:
				if(destination==Location.MALMO) return trajetMH+trajetHO+trajetOS;
				if(destination==Location.HELSINKI) return trajetOS+trajetHO;
				if(destination==Location.OSLO) return trajetOS;
				if(destination==Location.BERGEN) return trajetBM+trajetMH+trajetHO+trajetOS;
				break;
			default:
				return 0;
		}
		return 0;
	}

}
