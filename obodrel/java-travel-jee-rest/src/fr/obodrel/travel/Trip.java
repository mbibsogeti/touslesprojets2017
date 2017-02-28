package fr.obodrel.travel;

public class Trip {
	private String _location;
	private int _dangerosity;
	
	/************************************************/
	/******** CONSTRUCTORS GETTERS SETTERS **********/
	/************************************************/
	
	public Trip(String location, int dangerosity) {
		_location = location;
		_dangerosity = dangerosity;
	}
	
	public Trip(String location) {
		_location = location;
		_dangerosity = 0;
	}
	
	public Trip(int dangerosity) {
		_location = "";
		_dangerosity = dangerosity;
	}
	
	public Trip() {
		_location = "";
		_dangerosity = 0;
	}
	
	public String getLocation() {
		return _location;
	}
	
	public void setLocation(String location) {
		_location = location;
	}
	
	public int getDangerosity() {
		return _dangerosity;
	}
	
	public void setDangerosity(int dangerosity) {
		_dangerosity = dangerosity;
	}
	
	/************************************************/
	/****** END CONSTRUCTORS GETTERS SETTERS ********/
	/************************************************/
}
