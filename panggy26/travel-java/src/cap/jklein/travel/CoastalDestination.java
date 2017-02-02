package cap.jklein.travel;

public class CoastalDestination extends Destination {

	// Attributs
	private String _boat;

	// Méthodes constructeurs
	public CoastalDestination(String nom, String etat, int jours, String bateau) {
		super(nom, etat, jours);
		_boat = bateau;
	}

	public CoastalDestination() {
		this(null, null, 5, null);
	}

	// Accesseurs
	public String getBoat() {
		return _boat;
	}

	public void setBoat(String boat) {
		_boat = boat;
	}

	// Autres méthodes
	// Redéfinition (forcément la même signature que dans la classe mère)
	public String toString() {
		// Appel à toString() de la classe mère
		return super.toString() + " à bord de " + _boat;

	}
}