/**
 * 
 */

/**
 * @author ib
 *
 */
// Tous les voyages vers les USA
public class America {
	// Voyage à washington
	public static void doWashington() {
		System.out.println("Pas de voyage pour cet état de Washington");
	};

	// Voyage au Nevada
	public static void doNevada(int d) {
		Destination d1 = new Destination();
// avec utilisation de getters ans setters car les attibusts sont private. Sinon d1.Name aurait suffit
		d1.setName("Las Vegas");
		d1.setState("Nevada"); 
		d1.setDays(d);
		d1.extend(6);
		System.out.println(d1.toString());
		// System.out.println("Je vous conseille "+ d1.Name + " dans cet état de
		// "+ d1.State);
	};
	// Voyage au Texas:
	public static void doTexas(){
	CoastalDestination d1=new CoastalDestination();
	d1.setName("Texas");
	d1.setDays(15);
	d1.setState("Nevada");
	d1.setBoat("HaitianBoat");
	System.out.println("Vous allez dans l'état de "+d1.toString());
	};
}
