package jersey;

public class Excursion {
	String location;
	int dangerosity;

//	on utilise Eclipse pour générer le constructeur
	public Excursion(String location, int dangerosity) {
		super();
		this.location = location;
		this.dangerosity = dangerosity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getDangerosity() {
		return dangerosity;
	}

	public void setDangerosity(int dangerosity) {
		this.dangerosity = dangerosity;
	}

}
