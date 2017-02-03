package fr.ib.marcantoine.travel;

import java.time.LocalDateTime;
import java.util.Scanner;

public class America {

	// FONCTION WASHINGTON
	static void doWashington() {
		System.out.println("Pas de voyage pour cet état.");
	}

	// FONCTION NEVADA
	static void doNevada() {
		Destination d1 = new Destination();
		// d1.name = "Las Vegas";
		d1.setDays(Destination.FIXED_DAYS);
		System.out.println(d1.getName() + " pendant " + d1.getDays() + " jours");
		System.out.println(d1.toString());
		System.out.println(d1.getWeeks());
	}

	// FONCTION TEXAS
	static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();
		// d1.setName("Florabama");
		// d1.setState("Alabama");
		// d1.setDays(12);
		// System.out.println (d1.toString());
		// d1.setBoat("Hollandais Volant");
		System.out.println(d1.toString());
	}

	// FONCTION LOUSISIANA
	static void doLouisiana(Scanner sc) {
		System.out.println("Dans quelle ville voulez-vous allez ?");
		String place = sc.nextLine();
		place = place.trim();
		place = place.substring(0, 1).toUpperCase() + place.substring(1);
		System.out.println("Comment vous appelez-vous ?");
		String client = sc.nextLine();
		LocalDateTime takeoffdate = LocalDateTime.now().plusDays(54);
		System.out.println("Demande pour " + place + " enregistrée, " + "départ au mieux le "
				+ String.format("%02d / %02d", takeoffdate.getDayOfMonth(), takeoffdate.getMonthValue()));
	}
}
