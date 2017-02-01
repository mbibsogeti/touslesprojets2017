package fr.ib.amine.travel;

import java.util.Scanner;

public class Main {
	public static void doAlaska(Scanner al) {

		System.out.println("donnez la valeur de la réduction:");
		// Scanner sc = new Scanner(System.in);
		int reduction = al.nextInt();
		System.out.println("donnez la durée de votre séjour:");
		int duree = al.nextInt();
		float prix_avion = 860.00f;
		// int duree=7;
		float prix_nuit = 48.00f;

		float voyage = (prix_avion + prix_nuit * duree) - reduction * (prix_avion + prix_nuit * duree) / 100;

		System.out.println("Le prix du séjour en Alaska: réduction de " + reduction + "% sur " + prix_avion
				+ "\u20ac d'avion et " + duree + "jours à " + prix_nuit + "\u20ac soit " + voyage + "\u20ac");

		/*-----------souvenir à ramener par le client --------------------------*/
		if (duree < 8) {
			System.out.println("le client ne ramènera rien avec lui");
		} else if (duree >= 8 & duree <= 14) {
			System.out.println("le client ramènera un porte clé en souvenir avec lui");
		} else {
			System.out.println("le client ramènera une pépite d'or en souvenir avec lui");
		}

		/*------Choix de la compagnie aérienne-------*/
		switch (duree) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Le voyage se fera avec la compagnie AirFrance");
			break;
		case 7:
		case 14:
		case 21:
		case 28:
			System.out.println("Le voyage se fera avec la compagnie Condor");
			break;
		default:
			System.out.println("Le voyage se fera avec la compagnie Alaska Airlines");
		}

		/*------programme du séjour en Alaska------*/
		for (int jour = 1; jour <= duree; jour++) {
			if (jour == 1) {
				System.out.println("Jour " + jour + ": Avion");
			} else if (jour == duree) {
				System.out.println("Jour " + jour + ": Retour Avion");
			} else if ((jour - 1) % 4 == 0) {
				System.out.println("Jour " + jour + ": Crabe Royal");
			} else {
				System.out.println("Jour " + jour + ": Pêche");
			}
		}
		al.close();
	}

	/*------------calcul prix du séjour au Canada----*/

	public static int getCanadaPrice(int av, int hot, int js) {
		return av + (hot * js);
	}

	public static int getCanadaPrice(int js) {
		return getCanadaPrice(1000, 100, js);

	}

	public static void doCanada(Scanner ca, int hotel, int avion) {

		int[] table = { 7, 9, 13, 16, 18 };
		// int hotel = 45;
		// int avion = 785;
		System.out.print("donnez la durée du séjour: ");
		// Scanner sc = new Scanner(System.in);
		int duree = ca.nextInt();
		for (int i : table) {
			if (i == duree) {
				int total = getCanadaPrice(duree);
				System.out.println("Le prix de votre séjour au est:" + total + " \u20ac");
				break;
			}

		}
		ca.close();
	}

	/*-----------Programme principale-----*/
	public static void main(String[] args) {
		System.out.println("Bienvenu à vous dans notre Agence de Voyage");

		/*---------Choisir votre destination------*/
		/*-------Entrer des données par console--------------*/
		Scanner sc = new Scanner(System.in);
		String menu = sc.next();

		/*-------------si le client choisi Alaska------------*/
		if (menu.equals("a")) {
			doAlaska(sc);
		}
		/*-------choix CANADA----------*/
		if (menu.equals("c")) {
			doCanada(sc, 100, 500);
		}
		if (menu.equals("s")) {
			doCanada(sc, 45, 795);
		}
		if (menu.equals("w")) {
			Amerique.doWashington(sc);
		}
		if (menu.equals("n")){
			Amerique.doNevada(sc);
		}
		sc.close();
	}

}