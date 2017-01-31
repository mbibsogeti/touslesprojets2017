package fr.ib.amine.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/*-------Entrer des données par console--------------*/
		Scanner sc = new Scanner(System.in);
		System.out.println("donnez la valeur de la réduction:");
		int reduction = sc.nextInt();
		System.out.println("donnez la durée de votre séjour:");
		int duree = sc.nextInt();

		/*------calcul du prix du séjours------*/
		// int reduction=20;
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
		switch(duree){
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
		sc.close();
	}

}