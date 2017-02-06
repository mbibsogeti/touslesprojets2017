package fr.ib.hugo.travel;

public class CoastalDestination extends Destination {

	private String boat;

	public CoastalDestination() {
		this(null, null, 5, null);
	}

	public CoastalDestination(String _name, String _state, int _days, String _boat) {
		super(_name, _state, _days);
		this.boat = _boat;
	}

	public String toString() {
		return (super.toString() + ". Le voyage sera fait en " + boat + ".");
	}

	public String getBoat() {
		return boat;
	}

	public void setBoat(String _boat){
		this.boat=_boat;
	}
}
