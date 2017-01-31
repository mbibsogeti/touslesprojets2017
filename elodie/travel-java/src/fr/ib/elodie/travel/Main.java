package fr.ib.elodie.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to our travel agency \n *************************");
		// ENTREE de jour
		Scanner sc = new Scanner(System.in);

		System.out.println("Choisir entre les destinations suivante: CANADA --> c; ALASKA-->a ; Quitter-->q");
		String menu = sc.next();

		
		
		//TEST du Menu + entree dans le choix ALASKA ou CANADA
		if (menu.equals("a")) {
			System.out.println("VIVE l'ALASKA!");
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
				System.out.println("Vous ne repartez avec aucun souvenir");
			else if (nbDays >= 15)
				System.out.println("Vous avez droit à une pépite d'or");
			else
				System.out.println("Vous avez droit à un porte clés");

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
			String str = "Voyage Alaska " + nbDays + " jours --> " + pricePlane + "\u20ac Aller-retour et " + priceHotel
					+ "\u20ac par nuit soit un prix de : " + total + "\u20ac. Après réduction de " + reduction
					+ "%, le prix total est de :" + result + "\u20ac\n";
			System.out.println(str);

			// TEST boucles
			for (int i = 1; i <= nbDays; i++) {
				if (i == 1 | i == nbDays)
					System.out.println("Jour " + i + ": Avion");
				else if (i % 4 == 1)
					System.out.println("Jour " + i + ": Crabe Royal");
				else
					System.out.println("Jour " + i + ": Peche");
			}

		}

		else if (menu.equals("c")) {
			System.out.println("VIVE LE CANADA");

			int pricePlaneCanada = 785;
			int priceHotelCanada = 45;

			System.out.println("Prix par nuit d'hotel est de " + priceHotelCanada + "\u20ac avec un aller-retour de "
					+ pricePlaneCanada + "\u20ac");

			int[] days = { 7, 9, 13, 16, 18 };
			int priceDays;

			for (int i : days) {
				priceDays = (i * priceHotelCanada) + pricePlaneCanada;
				System.out.println("Le prix pour " + i + " jours est de: " + priceDays + " euros!");
			}

		} else
			System.out.println("VOUS NOUS AVEZ QUITTE");

		// FIN de l'entrée
		sc.close();

	}

}
