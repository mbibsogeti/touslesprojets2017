package cap.jklein.travel;

import java.util.Scanner;

public class Main {

	public static void doAlaska(Scanner scan) {
		System.out.println("Veuillez rentrer un nombre de jours : ");

		// Demande à l'utilisateur de rentrer un entier byte dans la console
		byte jours = scan.nextByte();

		byte promo = -20;
		short vol = 860;
		byte prix = 48;

		// La promo s'applique au tout
		System.out.println("Alaska : " + promo + "% sur " + vol + "\u20ac d'avion et " + jours + "j à " + prix + "\u20ac.");

		// Calcul coût total - On rajoute 100f pour faire une division réelle.
		// la division entière ne convient pas ici
		float total = ((100 + promo) / 100f) * (vol + jours * prix);

		// Méthode format de la classe String pour afficher les centimes du prix
		System.out.println("Le prix total à payer est : " + String.format("%.2f", total) + "\u20ac.");

		if (jours < 8)
			System.out.println("Pas de cadeau");
		else if (jours < 15)
			System.out.println("Vous gagnez un magnifique porte-clef.");
		else
			System.out.println("Vous remportez une pépite d'or !");

		switch (jours % 7) {
		// Si le nombre de jours est un multiple de 7 :
		case 0:
			// On veut éviter les cas multiples de 7 autres que 7, 14, 21, 28 :
			if (jours / 7 < 5)
				System.out.println("Votre compagnie aérienne est : Condor");
			else
				System.out.println("Votre compagnie aérienne est : Alaska Airlines");
			break;
		default:
			// Seulement pour moins de 8 jours sauf 7
			if (jours < 8)
				System.out.println("Votre compagnie aérienne est : Air France");
			else
				System.out.println("Votre compagnie aérienne est : Alaska Airlines");
		}

		// Boucle (Initialisation; limite; incrémentation)
		// On veut un jour d'avion au début et à la fin, et un cycle avec 3
		// jours de pêche puis 1 jour de crabe
		for (int i = 1; i <= jours; i++) {
			String s = "pêche";
			if (i == 1 || i == jours)
				s = "avion";
			else if ((i - 1) % 4 == 0)
				s = "crabe royal";
			System.out.println("Jour " + i + " : " + s);
		}
	}

	public static int getCanadaPrice(int avion, int hebergement, int days) {
		return avion + hebergement * days;
	}

	public static int getCanadaPrice(int duree) {
		return getCanadaPrice(785, 45, duree);
	}

	public static void doCanada(int vol, int hotel) {
		int[] tabJours = { 7, 9, 13, 16, 18 };
		for (int i : tabJours) { // Syntaxe pour parcourir le tableau i
			int total = getCanadaPrice(vol, hotel, i);
			System.out.println(i + " jours : " + total + "\u20ac");
		}
		System.out.println("Prix pour le Canada - " + vol + "\u20ac d'avion et " + hotel + "\u20ac par nuit d'hôtel");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(
				"Veuillez taper A (Alaska), C (Canada), S (Saskatchewan), W (Washington), N (Nevada), T (Texas), L (Louisiane) ou Q (Quitter) : ");
		String menu = sc.nextLine();

		if (menu.equals("A")) {
			doAlaska(sc);
		}
		if (menu.equals("C")) {
			doCanada(785, 45);
		}
		if (menu.equals("S")) {
			doCanada(805, 45);
		}
		if (menu.equals("W")) {
			Usa.doWashington();
		}
		if (menu.equals("N")) {
			Usa.doNevada();
		}
		if (menu.equals("T")) {
			Usa.doTexas();
		}
		if (menu.equals("L")) {
			Usa.doLouisiane(sc);
		}
	}
}