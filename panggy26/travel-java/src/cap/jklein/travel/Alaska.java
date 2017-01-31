package cap.jklein.travel;

import java.util.Scanner;

public class Alaska {

	public static void main(String[] args) {
		
		byte promotion = -20;
		short vol = 860;
		byte prix = 48;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez rentrer un nombre de jours : ");
		byte jours = sc.nextByte(); // Demande à l'utilisateur de rentrer un entier dans la console
		
		System.out.println("Alaska : " + promotion + "% sur " + vol + "\u20ac d'avion et " + jours + "j à " + prix + "\u20ac."); // La promotion s'applique au tout
		
		float total = ((100 + promotion) / 100f) * (vol + jours * prix); // On rajoute 100f pour faire une division réelle, là où une division entière donne un mauvais résultat
		System.out.println("Le prix total à payer est : " + total + "\u20ac.");
		
		if(jours < 8)
			System.out.println("Pas de cadeau");
		else
			if (jours < 15)
				System.out.println("Vous gagnez un magnifique porte-clef.");
			else
				System.out.println("Vous remportez une pépite d'or !");
		
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
	
		
		
		sc.close(); // Fermeture du Scanner
		
	}
}