package fr.ib.myriam.travel;

import java.util.Scanner;

/**
 * @author Myriam Benmansour le 30/01/2017
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("------ Bienvenue dans notre agence de voyage ------");
		System.out.println("voyage en Alaska");

		float billet = 860;
		float tarif_j = 48;
		float nb_jour = 7;
		float promo = 20;

		Scanner sc = new Scanner(System.in);
		System.out.println("combien de jour souhaitez vous partir ?");
		nb_jour = sc.nextInt();

		float tot = (billet + (tarif_j * nb_jour));
		float prix_promo = tot * (1 - (promo / 100));

		System.out.println("le voyage coûtera : " + tot + " €");
		System.out.println("Avec notre offre promotionelle, nous vous faisons une réduction de -" + promo
				+ "%. Le prix tombe à : " + prix_promo + " €");


		switch ((int)(nb_jour)){
		case 1 : case 2: case 3 : case 4: case 6: case 8 :
			System.out.println("Le voyage se fera avec Air France");
			break;
		case 7 : case 14: case 21: case 28 :
			System.out.println("Le voyage se fera avec condor");
			break;
		default :
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

		sc.close();
	}

}
