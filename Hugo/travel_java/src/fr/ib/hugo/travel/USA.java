package fr.ib.hugo.travel;

import java.util.Scanner;
import java.time.*;

public class USA {

	public static void doWashington() {
		System.out.println("Nous ne disposons pas d'offre de voyage pour Washington en ce moment.");
		return;
	}

	public static void doNevada() {
		Destination d1 = new Destination("Death Valley", "Nevada", 1);
		d1.extend(6);
		System.out.println(d1.toString());

		Destination d2 = new Destination();
		d2.setName("Las Vegas");
		d2.setState("Nevada");
		d2.setDays(14);
		System.out.println(d2.toString());

		Destination d3 = new Destination();
		System.out.println(d3.toString());
		return;
	}

	public static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();

		d1.setName("Padre Island");
		d1.setState("Texas");
		d1.setDays(10);
		// d1.setBoat("bateau pêcheur");
		System.out.println(d1.toString());
	}

	public static void doLouisiane(Scanner sc) {
		System.out.println("Lieu?");
		String lieu = sc.nextLine();
		lieu=lieu.trim();
		lieu=lieu.substring(0,1).toUpperCase()+lieu.substring(1);
		lieu.toUpperCase();
		System.out.println("A quel nom?");
		String nom = sc.nextLine();
		LocalDateTime DateAuj = LocalDateTime.now();
		int Mois=DateAuj.getMonthValue();
		int Jour=DateAuj.getDayOfMonth();
		int Heure=DateAuj.getHour();
		int Min=DateAuj.getMinute();
		int An=DateAuj.getYear();
		System.out.println("Demande pour " + lieu + " enregistrée le "+String.format("%02d", Jour)+"/"+String.format("%02d", Mois)+"/"+An+" à "+Heure+"h"+Min+" au nom de " + nom + ".");
		LocalDateTime DateDep = DateAuj.plusDays(54);
		Mois=DateDep.getMonthValue();
		Jour=DateDep.getDayOfMonth();
		An=DateDep.getYear();
		System.out.println("Compte tenu du temps nécessaire pour l'organisation du voyage, la date de départ au mieux sera le "+String.format("%02d", Jour)+"/"+String.format("%02d", Mois)+"/"+An);
		sc.close();
	}
}