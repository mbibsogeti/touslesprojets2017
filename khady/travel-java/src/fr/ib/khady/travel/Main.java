
package fr.ib.khady.travel;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner LectureClavier = new Scanner(System.in);

		System.out.println("Welcome to our new travel Agency SENGO !");
		System.out.println("Quelle destination ? Louisiane---l, NewYork--- y, Floride---f, Texas---t, Nevada---n, Washington---w, Saskakchewan---s, Canada---c, Alaska---a, Quitter---q");
		String choix = LectureClavier.nextLine();

		if (choix.equals("a")) {System.out.println("Votre destination est Alaska");

			doAlaska(LectureClavier);

		} else if (choix.equals("c")) {
			int hotel_c = 45, avion_c = 785;
			System.out.println("Votre destination est Canada");

			doCanada(avion_c, hotel_c);
		}

		else if (choix.equals("s")) {
			int hotel_s = 65, avion_s = 895;

			doCanada(avion_s, hotel_s);

		} else if (choix.equals("w")) {
			Amerique.doWashington();

		} else if (choix.equals("n")) {
			Amerique.doNevada();

		} else if (choix.equals("t")) {
			Amerique.doTexas();
			
		}else if (choix.contentEquals("l")) {
			Amerique.doLouisiane();
			
		}else if (choix.contentEquals("f")) {
			Amerique.doFloride();
			
		}else if (choix.contentEquals("y")) {
			Amerique.doNewYork();
			
		}else
			System.out.println("Quitter");
	}

	
	static void doAlaska(Scanner LectureClavier) {
		String s;
		double tauxReduc = 0.2;
		int prix = 860, nbrejours;
		int prixjour = 48;		
        
		System.out.println("Entrez le nombre de jours: ");
		nbrejours = LectureClavier.nextInt();
		int prixVoyage = (prix + (prixjour * nbrejours));
		double prixReduit = (prixVoyage - (prixVoyage * tauxReduc));
		System.out.println("Un séjour de " + nbrejours + " jours en Alaska vous coutera " + prixVoyage + " €");
		s = String.format("%.2f" , prixReduit);
		System.out.println("Et avec une réduction de " + (0.2 * 100) + " %, cela vous revient à  " + s + " €");
     
		
		
		if (nbrejours < 8 && nbrejours != 7)
			System.out.println("Vous allez voyager avec Air France ");
		else {
			switch (nbrejours) {

			case 7:
			case 14:
			case 21:
			case 28:

				System.out.println("Vous allez voyager avec Condor");
				break;

			default:
				System.out.println("Vous allez voyager avec Alaska Airlines");

			}
		}
		String p = "Pêhe", c = "Crabe";

		for (int j = 1; j <= nbrejours; j++) {
			if (j == 1 || j == nbrejours)
				System.out.println("Jour " + j + " Avion");
			else {
				if (j % 4 == 1)
					System.out.println("Jour " + j + " " + c);
				System.out.println("Jour " + j + " " + p);
			}

		}

	}

	static void doCanada(int avion, int hotel) {
		int[] tabNbjours = { 7, 9, 13, 16, 18 };
		for (int i = 0; i < tabNbjours.length; i++) {
			System.out.println("Le prix pour " + tabNbjours[i] + " jours est de " + getCanada(tabNbjours[i]) + " €");
		}

	}

	static int getCanada(int avion, int hotel, int Nbrejours) {
		int calcul;
		calcul = avion + (hotel * Nbrejours);
		return calcul;
	}

	static int getCanada(int Nbrejours) {
		int hotel = 95, avion = 995, calcul;
		calcul = avion + (hotel * Nbrejours);
		return calcul;
	}

	static void doNevada() {
		System.out.println("Afficher le nbre de semaines en Nevada");
	}

	static void doTexas() {
		System.out.println("");
	}
	static void doLouisiane() {
		int Nbrejours;
		Scanner LectureClavier = new Scanner(System.in);
		Nbrejours = LectureClavier.nextInt();
		if(Nbrejours < 54){
			System.out.println("Départ au mieux en 7 semaines et 5 jours");		
		}
	}	
		static void doFloride() {
		
			String nom, email;
			Scanner LectureClavier = new Scanner(System.in);
			nom = LectureClavier.nextLine();			
			email = LectureClavier.nextLine();
			}
		
		static void doNewYork() {
			
			System.out.println("");
			}
	}

