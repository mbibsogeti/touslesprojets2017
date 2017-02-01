package fr.ib.marcantoine.travel;

public class America {
	
	// FONCTION WASHINGTON
	static void doWashington() {
		System.out.println("Pas de voyage pour cet état.");
	}
	
	// FONCTION NEVADA
	static void doNevada() {
		Destination d1 = new Destination("New Orleans", "Louisiana", 8);
//		d1.name = "Las Vegas";
//		d1.days = 10;
		System.out.println(d1.name+" pendant "+d1.days+" jours");
		d1.extend(5);
		System.out.println(d1.toString());
	}
}
