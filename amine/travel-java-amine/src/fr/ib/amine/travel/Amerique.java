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
		//Destination d1 = new Destination("Nevada", "USA", 2);
		Destination d1 = new Destination();
		// d1.name = "La vallée de la mort";
		// d1.state = "USA";
		// d1.days = 10;
		d1.extend(5);
		System.out.println(d1.toString());
	}
}
