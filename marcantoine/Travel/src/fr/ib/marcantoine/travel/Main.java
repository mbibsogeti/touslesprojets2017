package fr.ib.marcantoine.travel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	// MAIN
	public static void main(String[] args) {

		// Définition de l'objet scanner :
		Scanner sc = new Scanner(System.in);

		// Affichage de l'accueil :
		ArrayList <Integer> pouf = new ArrayList<>();
		pouf.add(10);
		pouf.add(8);
		pouf.add(2);
		pouf.add(2, 8);
		System.out.println (pouf);
		
		System.out.println("Bienvenue dans notre agence de voyages Degage.");

		// Choix de la destination :
		System.out.println(
				"Ou voulez-vous aller (c pour Canada, a pour Alaska, " + "s pour Saskakchewa, w pour Washington) ?");
		String menu = sc.nextLine();

		// Menu :
		switch (menu) {
		case "a": 
			doAlaska(sc);
			break;
		case "c": 
			doCanada(785, 45);
			break;
		case "s": 
			doCanada(2000, 45);
			break;
		case "w": 
			America.doWashington();
			break;
		case "n": 
			America.doNevada();
			break;
		case "t": 
			America.doTexas();
			break;
		case "l":
			America.doLouisiana(sc);
			break;
		case "f":
			America.doFlorida(sc);
			break;
		case "y":
			America.doNewYork(sc);
		}
		sc.close();
	}
	
	// ALASKA
	static void doAlaska(Scanner sc) {
		int promo = 20;
		int pbillet = 860;
		int pnuit = 48;
		float ptotal;

		// Entrée nombre de jours de voyage :
		System.out.println("Combien de jours voulez-vous partir ?");
		int duration = sc.nextInt();

		// Calcul et affichage du prix total :
		ptotal = (1 - promo / 100f) * (pbillet + duration * pnuit);
		System.out.println("Alaska : -" + promo + "% sur " + pbillet + "\u20ac d'avion et " + duration + "j à " + pnuit
				+ "\u20ac pour un total de " + String.format("%.2f",ptotal) + ".");

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
	}

	// CANADA
	static void doCanada(int pbillet, int pnuit) {
		int[] voyages = { 7, 9, 13, 16, 18 };
		for (int j : voyages) {
			float ptotal = getCanadaPrice(pbillet, pnuit, j);
			System.out.println("Voyage de " + j + " jours : " + ptotal + "\u20ac.");
		}
	}

	// GETCANADAPRICE et tests surcharge
	static float getCanadaPrice(int pbillet, int pnuit, int jour) {
		return (pbillet + jour * pnuit);
	}

	static float getCanadaPrice(int jour) {
		int pbillet = 1000;
		int pnuit = 50;
		return getCanadaPrice(pbillet, pnuit, jour);
	}

}
