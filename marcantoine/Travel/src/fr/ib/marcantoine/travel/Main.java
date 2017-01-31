package fr.ib.marcantoine.travel;

import java.util.Scanner;

public class Main {

	public static void main (String[] args) {

		// Défintion de l'objet scanner :
		Scanner sc = new Scanner(System.in);

		// Affichage de l'accueil
		System.out.println("Bienvenue dans notre agence de voyages Dégage. Combien de jours voulez-vous partir ?");

		// Déclaration variables
		int promo = 20;
		int pbillet = 860;
		int duration = sc.nextInt();
		int pnuit = 48;
		float ptotal = (1 - promo / 100f) * (pbillet + duration * pnuit);

		// Affichage de la dernière promotion

		System.out.println("Alaska : -" + promo + "% sur " + pbillet + "\u20ac d'avion et " + duration + "j à " + pnuit
				+ "\u20ac pour un total de " + ptotal + ".");

		byte b = 5;
		int i = b;
		b = (byte) i;

		// Affichage des gains bonus !!
		if (duration > 15) {
			System.out.println("C'est pas une pépite d'or dans votre poche ?");
		} else {
			if (duration > 7 & duration <= 14) {
				System.out.println("Vous avez gagné un porte-clef !");
			} else {
				System.out.println("Vous n'avez rien gagné... ça vous étonne ?");
			}

		}

		// Affichage du nom de la compagnie utilisée
		switch (duration%7) {
		case 0 :
			System.out.println("Votre compagnie sera Condor");
			break;		
		default :
			if (duration < 7) {
				System.out.println("Votre compagnie sera Air France");
			} else {
				System.out.println("Votre compagnie sera Alaska Airlines");

			}
		}
		
	}
}
