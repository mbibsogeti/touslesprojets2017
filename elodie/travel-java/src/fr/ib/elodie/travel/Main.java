package fr.ib.elodie.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		boolean continuation = true;
		System.out.println("Welcome to our travel agency \n *************************");
		// ENTREE de jour
		Scanner sc = new Scanner(System.in);

		while (continuation) {
			System.out.println(
					"Choice a final destination: CANADA --> c; ALASKA-->a ; SASKAKCHEWAN --> s; WASHINGTOWN --> w; NEVADA --> n; TEXAS --> t; Quitter-->q");
			String menu = sc.next();

			// TEST du Menu + entree dans le choix ALASKA ou CANADA
			if (menu.equals("a")) {
				doAlaska(sc);
				continuation = false;
			} else if (menu.equals("c")) {
				int pricePlane = 785;
				int priceHotel = 45;
				doCanada(pricePlane, priceHotel);
				continuation = false;
			} else if (menu.equals("q")) {
				continuation = false;
			} else if (menu.equals("w")) {
				America.doWashingtown();
				continuation = false;
			} else if (menu.equals("n")) {
				America.doNevada();
				continuation = false;
			} else if (menu.equals("t")) {
				America.doTexas();
				continuation = false;
			} else if (menu.equals("s")) {
				int pricePlaneS = 1000;
				int priceHotelS = 80;
				doCanada(pricePlaneS, priceHotelS);
				continuation = false;
			} else {
				System.out.println("Choice between Alaska: a , Canada : c\n");
			}
		}

		System.out.println("Goodbye");
		// FIN de l'entrée
		sc.close();
	}

	// Fonction pour l'ALASKA
	public static void doAlaska(Scanner sc) {

		System.out.println("Let's go to ALASKA!");
		int reduction = 20;
		int pricePlane = 860;
		int nbDays = sc.nextInt();
		int priceHotel = 48;

		// CALCUL DU PRIX
		double result;
		double total;
		total = (nbDays * priceHotel) + pricePlane;
		result = total - ((total * reduction) / 100);

		// TEST de souvenir
		if (nbDays < 8)
			System.out.println("You win nothing. So, sorry !! ");
		else if (nbDays >= 15)
			System.out.println("You win a gold nugget !! ");
		else
			System.out.println("You win a key ring !! ");

		// TEST de compagnie
		if (nbDays < 8 && nbDays != 7)
			System.out.println("AirFrance");
		else {
			switch (nbDays) {
			case 7:
			case 14:
			case 21:
			case 28:
				System.out.println("Condor");
				break;
			default:
				System.out.println("Alaska Airlines");
			}
		}

		// AFFICHAGE
		String str = "Alaska trip " + nbDays + " days --> Return airfare : " + pricePlane + "\u20ac and " + priceHotel
				+ "\u20ac per night. So, the price is equal to " + total + "\u20ac. After recuction of " + reduction
				+ "%, the final price : " + result + "\u20ac\n";
		System.out.println(str);

		// TEST boucles
		for (int i = 1; i <= nbDays; i++) {
			if (i == 1 | i == nbDays)
				System.out.println("Day " + i + ": Plane trip");
			else if (i % 4 == 1)
				System.out.println("Day " + i + ": Eating a King crab");
			else
				System.out.println("Day " + i + ": Fishing");
		}
	}

	// Fonction pour le CANADA
	public static void doCanada(int priceP, int priceH) {

		System.out.println("Let's go to CANADA");
		System.out.println(
				"Price per hotel night: " + priceH + "\u20ac and price of a return airfare " + priceP + "\u20ac");

		int[] days = { 7, 9, 13, 16, 18 };
		int priceDays;

		for (int i : days) {
			priceDays = getCanadaPrice(priceP, priceH, i);
			// priceDays = getCanadaPrice(i); //Surcharge
			System.out.println("Price for " + i + " days is equal to " + priceDays + " euros!");
		}
	}

	public static int getCanadaPrice(int pP, int pH, int nD) {
		return (nD * pH) + pP;
	}

	// public static int getCanadaPrice(int nD) {
	// return getCanadaPrice(1000, 80, nD);
	// }

}
