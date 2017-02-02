/**
 * 
 */

/**
 * @author ib
 *
 */
public class CoastalDestination extends Destination {
	// rajouter un paramètre à la classe fille
	public CoastalDestination(String n, String s, int d, String b) {
		super(n, s, d);
		boat = b;
	}

	public CoastalDestination() {
		this(null, null, 5, null);
	}

	public String getBoat() {
		return boat;
	}

	public String toString() {
		return super.toString() + " Avec le beatau de croisière : " + boat;
	}

	public void setBoat(String boat) {
		this.boat = boat;
	}

	private String boat;
}
