package fr.ib.elodie.travel;

public class America {
	public static void doWashingtown() {
		System.out.println("Not trip for this state");
	}

	public static void doNevada() {
		
		Destination d1 = new Destination ("Death Valley","Nevada",7);
		d1.setName("Monument Valley");
		d1.extend(7);

		System.out.println(d1.toString() + " = " + d1.getWeeks() + " weeks");
	}
	
	public static void doTexas(){
		CostalDestination cd1 = new CostalDestination ("Padre Island", "Texas", 4, "Federal");
		System.out.println(cd1.toString());
	}
}
 