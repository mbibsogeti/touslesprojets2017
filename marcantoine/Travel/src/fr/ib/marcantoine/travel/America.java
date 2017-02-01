package fr.ib.marcantoine.travel;

public class America {
	
	// FONCTION WASHINGTON
	static void doWashington() {
		System.out.println("Pas de voyage pour cet état.");
	}
	
	// FONCTION NEVADA
	static void doNevada() {
		Destination d1 = new Destination();
//		d1.name = "Las Vegas";
//		d1.days = 10;
		d1.setDays(8);
		System.out.println(d1.getName()+" pendant "+ d1.getDays() +" jours");
		System.out.println(d1.toString());
		System.out.println(d1.getWeeks());
	}
	
	// FONCTION TEXAS
	static void doTexas() {
		CoastalDestination d1 = new CoastalDestination ();
		d1.setName("Florabama");
		d1.setState("Alabama");
		d1.setDays(12);
		System.out.println (d1.toString());
		d1.setBoat("Hollandais Volant");
		System.out.println (d1.toString());
	}
}
