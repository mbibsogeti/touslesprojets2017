package fr.ib.marcantoine.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// Défintion de l'objet scanner :
		Scanner sc = new Scanner(System.in);

		// Affichage de l'accueil
		System.out.println("Bienvenue dans notre agence de voyages Dégage.");

		// Déclaration variables
		int promo = 20;
		int pbillet = 860;
		System.out.println("Combien de jours voulez-vous partir ?");
		int duration = sc.nextInt();
		System.out.println("Où voulez-vous aller ?");
		String menu = sc.next();
		int pnuit = 48;
		float ptotal = (1 - promo / 100f) * (pbillet + duration * pnuit);

		// Menu
		if (menu.equals("a")) {

			// ALASKA
			System.out.println("Alaska : -" + promo + "% sur " + pbillet + "\u20ac d'avion et " + duration + "j à "
					+ pnuit + "\u20ac pour un total de " + ptotal + ".");

			byte b = 5;
			int i = b;
			b = (byte) i;

			// Affichage des goodies avec des conditions
			if (duration > 15) {
				System.out.println("C'est pas une pépite d'or dans votre poche ?");
			} else {
				if (duration > 7 & duration <= 14) {
					System.out.println("Vous avez gagné un porte-clef !");
				} else {
					System.out.println("Vous n'avez rien gagné... ça vous étonne ?");
				}

			}

			// Affichage du nom de la compagnie utilisée en utilisant switch
			switch (duration % 7) {
			case 0:
				System.out.println("Votre compagnie sera Condor");
				break;
			default:
				if (duration < 7) {
					System.out.println("Votre compagnie sera Air France");
				} else {
					System.out.println("Votre compagnie sera Alaska Airlines");

				}
			}

			// Emploi du temps avec ce qu'on a comme outils
			for (int cpt = 1; cpt <= duration; cpt++) {
				if (cpt == 1 | cpt == duration) {
					System.out.println("jour " + cpt + " : Avion");
				} else {
					if ((cpt - 1) % 4 == 0) {
						System.out.println("jour " + cpt + " : Crabe royal");
					} else {
						System.out.println("jour " + cpt + " : Pêche");
					}
				}
			}
		} else {
			// CANADA
			if (menu.equals("c")) {
				pbillet = 785;
				pnuit = 45;
				int [] voyages = {7,9,13,16,18};
				for (int j : voyages) {
					ptotal =(pbillet + j * pnuit);
					System.out.println ("Voyage de "+ j+" jours : "+ptotal+"\u20ac.");
				}
			} else {
				System.out.println("WTF ?!!!");
			}
		}

		// XP
		// int[]ti = {5,4,0,0};

		// Emploi du temps avec ce qu'on a comme outils : solution alternative +
		// courte, demande + mémoire, nomme mieux.
		// for (int cpt = 1 ; cpt <= duration ; cpt ++)
		// String activite = "Peche";
		// if (cpt==1 || cpt ==duration) {
		// activite = "Avion";
		// } else {
		// if ((cpt-1)%4==0) {
		// activite = "Crabe royal";
		// }
		// }
		// System.out.println("jour "+cpt+" : "+activite);
		// }

		// Expérience
		// for (int g = 0, j = 0 ; j < 20 ; j+=g, g++) {
		// System.out.println (g+"/"+j);
		// }

	}
}
