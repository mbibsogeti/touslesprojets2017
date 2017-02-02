package cap.jklein.travel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Usa {

	// MÉTHODES //
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
	
	public static void doLouisiane(Scanner sc) {
		System.out.println("Où souhaitez-vous voyager en Louisiane ?");
		// Demande à l'utilisateur de rentrer un lieu
		String place = sc.nextLine();
		// String.trim() supprime les espaces au début et à la fin
		place = place.trim();
		// String.subtring(int beginIndex, int endIndex) renvoie un sous-String de ce String
		// Ici, on met donc la première lettre en majuscule et les autres en minuscules
		place = place.substring(0, 1).toUpperCase() + place.substring(1);
		
		System.out.println("Quel est votre nom ?");
		// nextLine() permet de rentrer des noms avec espaces
		String name = sc.nextLine();
		
		System.out.println("Demande pour un voyage à " + place + " enregistrée pour " + name);
		
		// Il faut 7 semaines et 5 jours de préparation pour ce voyage
		LocalDateTime time = LocalDateTime.now();
		time = time.plusWeeks(7).plusDays(5);
		
		// Solution 1 : avec un DateTimeFormatter
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM");	
		System.out.println("Départ au mieux le " + time.format(timeFormat));
		
		// Solution 2 : avec un String.format
//		System.out.println("Départ au mieux le " + String.format("%02d/%02d", time.getDayOfMonth(), time.getMonthValue()));
	}
}