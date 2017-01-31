package fr.ib.elodie.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to our travel agency \n *************************");
		// ENTREE de jour
		Scanner sc = new Scanner(System.in);

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
		if(nbDays<8 && nbDays!=7)
			System.out.println("AirFrance");
		else{
			switch (nbDays){
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
				+ "%, le prix total est de :" + result + "\u20ac";
		System.out.println(str);

		// FIN de l'entrée
		sc.close();

	}

}
