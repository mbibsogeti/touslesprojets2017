package jk.travel.jersey;

public class Excursion {

	// ATTRIBUTS //
	private String _lieu;
	private int _dangerosite;

	// MÉTHODES //
	public Excursion(String lieu, int dangerosite) {
		_lieu = lieu;
		_dangerosite = dangerosite;
	}

	public String getLieu() {
		return _lieu;
	}

	public void setLieu(String lieu) {
		_lieu = lieu;
	}

	public int getDangerosite() {
		return _dangerosite;
	}

	public void setDangerosite(int dangerosite) {
		_dangerosite = dangerosite;
	}
} // end Excursion class