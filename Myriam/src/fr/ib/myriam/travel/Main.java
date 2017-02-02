package fr.ib.myriam.travel;

import java.util.Scanner;

/**
 * @author Myriam Benmansour le 30/01/2017
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("------ Bienvenue dans notre agence de voyage ------");

		Scanner sc = new Scanner(System.in);

		String rep[] = { "q", "a", "c" };
		String reponse = "";

		do {
			System.out.println(
					"Que voulez-vous faire ? q pour quitter, a pour un voyage en Alaska et c pour un voyage au Canada");
			reponse = sc.nextLine();
		} while (reponse.equals("q") && reponse.equals("a") && reponse.equals("c"));

		if (reponse.equals("q"))
			System.out.println("Au revoir !");

		else if (reponse.equals("c")) {
			System.out.println("Bienvenu au Canada !");

			float hotel = 45;
			float avion = 785;
			int nb_jours[] = { 7, 9, 13, 16, 18 };

			for (int i : nb_jours) {
				float prix = (float) (i) * hotel + avion * 2;
				System.out.println(i + " jours : " + prix + " €");
			}
		}

		else {
			System.out.println("voyage en Alaska");

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

		sc.close();
	}

}
