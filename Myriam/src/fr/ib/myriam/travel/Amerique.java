package fr.ib.myriam.travel;

import java.util.Scanner;

public class Amerique {
	
	
	
	static void goWashington(){
		Etat washington = new Etat("Washington");
		System.out.println("pas de voyage pour cet état !");
	}
	
	static void goNevada(){
		Etat nevada = new Etat("Nevada");
		System.out.println("Welcome to Nevada !");
		
		Destination d1 = new Destination("Vallé de la mort", nevada, 1);
		d1.extend(2);
		System.out.println(d1.toString());
	}
	
	static void goAlaska(Scanner sc) {

		float billet = 860;
		float tarif_j = 48;
		float nb_jour = 7;
		float promo = 20;

		System.out.println("combien de jour souhaitez vous partir ?");
		nb_jour = sc.nextInt();

		float tot = (billet + (tarif_j * nb_jour));
		float prix_promo = tot * (1 - (promo / 100));

		System.out.println("le voyage coûtera : " + tot + " €");
		System.out.println("Avec notre offre promotionelle, nous vous faisons une réduction de -" + promo
				+ "%. Le prix tombe à : " + prix_promo + " €");

		switch ((int) (nb_jour)) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 6:
		case 8:
			System.out.println("Le voyage se fera avec Air France");
			break;
		case 7:
		case 14:
		case 21:
		case 28:
			System.out.println("Le voyage se fera avec condor");
			break;
		default:
			System.out.println("Le voyage se fera avec Alaska AirLines");
		}

		if (nb_jour > 15)
			System.out.println(
					"Vu la durée de votre séjour, nous vous offrirons en souvenir une petite pépite d'or à votre retour :)");

		else if (nb_jour < 14 && nb_jour > 8)
			System.out.println(
					"Vu la durée de votre séjour, nous vous offrirons en souvenir un porte-clé à votre retour :)");

		else
			System.out.println(
					"Votre séjour est trop court, vous n'aurez pas le temps de profiter de l'Alaska ! Nous attendrons votre prochain voyage pour vous offrir un souvenir :)");

		System.out.println("\nDétail du voyage :");
		System.out.println("Jour 1 : Avion");
		for (int i = 1; i < (nb_jour - 1); i++)
			if (i % 4 != 0)
				System.out.println("Jour " + (i + 1) + " : Pêche");
			else
				System.out.println("Jour " + (i + 1) + " : Garstronomie");
		System.out.println("Jour " + (int) (nb_jour) + " : Avion");

	}

	static void goCanada(float hotel, float avion) {
		System.out.println("Bienvenue au Canada !");

		int nb_jours[] = { 7, 9, 13, 16, 18 };

		for (int i : nb_jours) {
			float prix = getCanadaPrice(hotel, avion,i);
			System.out.println(i + " jours : " + prix + " €");
		}
	}

	static float getCanadaPrice(float hotel, float avion, int jours) {
		float prix = (float) (jours) * hotel + avion * 2;
		return prix;
	}
	
	static float getCanadaPrice(int jours) {
		float hotel = 45;
		float avion = 785;
		float prix =  getCanadaPrice (hotel, avion, jours);
		return prix;
	}
	
	static void goTexas(){
		Etat texas = new Etat("Texas");
		System.out.println("Welcome to Texas !");
		
		CoastalDestination d = new CoastalDestination("Padre Island", texas, 3,"Felicy");
		d.extend(2);
		System.out.println(d.toString());
	}
}
