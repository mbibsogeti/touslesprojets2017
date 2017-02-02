package cap.jklein.travel;

public class Usa {

	public static void doWashington() {
		System.out.println("Pas de voyage pour l'état de Washington !");
	}

	public static void doNevada() {

		Destination dest = new Destination(); // Instanciation

		dest.extend(3);
		System.out.println(dest.toString());

		Destination desti = new Destination("Carson City", "Nevada", 10);
		System.out.println(desti.toString());
	}

	public static void doTexas() {

		CoastalDestination costDest = new CoastalDestination("Padre Island", "Texas", 3, "la Licorne");
		System.out.println(costDest.toString());
	}
}