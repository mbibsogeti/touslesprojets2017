
public class USA {

	public USA() {
	}

	public static void doWashington(){
		System.out.println("Malheureusement, il n'y a pas de voyage prévu pour cet état.");
	}
	
	public static void doNevada(){
		Destination dNev = new Destination("Reno","Nevada",1);
		
		dNev.extendDays(7);
		System.out.println(dNev.toString());
	}

	public static void doTexas() {
		CostalDestination cdTex = new CostalDestination(null,"Texas",1);
		cdTex.setName("PadreIsland");
		cdTex.setBoat("Queen-Mary II");
		System.out.println(cdTex.toString());
		
	}
}
