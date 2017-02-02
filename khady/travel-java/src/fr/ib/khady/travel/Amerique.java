package fr.ib.khady.travel;

public class Amerique {

	static void doWashington() {
		System.out.println("Pas de voyage pour cette destination !");

	}

	static void doNevada() {
		
		Destination d1 = new Destination();
	    //d1.name = "Monument" ; // Ceci fonctionne si les attributs de la classe Destination ne sont pas en private
		//d1.state = "Nevada";
		//d1.days = 5;
	//	d1.extend(8);
		System.out.println(d1.toString());
				
	}

	static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();	
		d1.setName("Padre Island");
		d1.setBoat("Foursea");
        System.out.println(d1.toString());
	}
	
	
	
}
