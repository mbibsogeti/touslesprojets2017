package fr.ib.amine.travel;

import java.util.Scanner;

public class Amerique {
	/*---------------------Etat de Washington DC-------*/
	public static void doWashington(Scanner wa) {
		System.out.println("Pas de voyage pour cet état");
	}

	/*--------------------Etat du Nevada------------*/
	public static void doNevada(Scanner Ne) {
		System.out.println("Bon choix!!");
		// Destination d1 = new Destination("Nevada", "USA", 2);
		Destination d1 = new Destination();
		d1.setName("La vallée de la mort");
		d1.setState("USA");
		d1.setDays(10);
		d1.extend(5);
		System.out.println(d1.toString() +" "+ d1.getWeeks()+" weekends");
		// System.out.println(d1.toString1());
	}

	/*-------------Etat du Texas-----------*/
	public static void doTexas(Scanner te) {
		System.out.println("Ville natale des Bush o_O'");
		CoastalDestination d1 = new CoastalDestination("Padre Island","Mexique",15,"TOTO");
		/*d1.setName("Padre Island");
		d1.setState("Mexique");
		d1.setDays(15);
		// d1.extend(0);
		d1.setBoat("Titanic");*/
		System.out.println(d1.toString());
	}
}
