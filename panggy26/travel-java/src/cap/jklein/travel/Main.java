package cap.jklein.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez taper A (Alaska), C (Canada) ou Q (Quitter) : ");
		String choix = sc.next();
		
		if (choix.equals("A")) {
		
			System.out.println("Veuillez rentrer un nombre de jours : ");
			byte jours = sc.nextByte(); // Demande à l'utilisateur de rentrer un entier dans la console
			
			byte promotion = -20;
			short vol = 860;
			byte prix = 48;
			
			// Phrase d'accueil
			System.out.println("Alaska : " + promotion + "% sur " + vol + "\u20ac d'avion et " + jours + "j à " + prix + "\u20ac."); // La promotion s'applique au tout
			
			// Calcul coût total
			float total = ((100 + promotion) / 100f) * (vol + jours * prix); // On rajoute 100f pour faire une division réelle, là où une division entière donne un mauvais résultat
			System.out.println("Le prix total à payer est : " + total + "\u20ac.");
			
			// Structure if
			if(jours < 8)
				System.out.println("Pas de cadeau");
			else
				if (jours < 15)
					System.out.println("Vous gagnez un magnifique porte-clef.");
				else
					System.out.println("Vous remportez une pépite d'or !");
			
			// Structure switch
			switch(jours % 7) {
				case 0: // Si le nombre de jours est un multiple de 7
					if (jours / 7 < 5) // On veut éviter les cas multiples de 7 autres que 7, 14, 21, 28
						System.out.println("Votre compagnie aérienne est : Condor"); // Seulement pour 7, 14, 21, 28 jours
					else
						System.out.println("Votre compagnie aérienne est : Alaska Airlines");
					break;
				default:
					if (jours < 8) // Seulement pour moins de 8 jours sauf 7
						System.out.println("Votre compagnie aérienne est : Air France");
					else
						System.out.println("Votre compagnie aérienne est : Alaska Airlines");			
			}
			
			// Boucle
			// On veut un jour d'avion au début et à la fin, et un cycle avec 1 jour de crabe après 3 jours de pêche
			for(int i = 1; i <= jours; i++) { // (Initialisation; limite; incrémentation)
				String s = "pêche";
				if (i == 1 || i == jours)
					s = "avion";
				else if ((i-1) % 4 == 0)
					s = "crabe royal";
				System.out.println("Jour " + i + " : " + s);
			}
		
		}
		sc.close(); // Fermeture du Scanner
	}	
}