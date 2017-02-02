package cap.jklein.travel;

public class CoastalDestination extends Destination {

	// ATTRIBUTS //
	private String _boat;

	// CONSTRUCTEURS //
	public CoastalDestination(String nom, String etat, int jours, String bateau) {
		super(nom, etat, jours);
		_boat = bateau;
	}

	public CoastalDestination() {
		this(null, null, 5, null);
	}

	// MÉTHODES
	public String getBoat() {
		return _boat;
	}

	public void setBoat(String boat) {
		_boat = boat;
	}

	// Redéfinition (forcément la même signature que dans la classe mère)
	public String toString() {
		// Appel à toString() de la classe mère
		return super.toString() + " à bord de " + _boat;

	}
}