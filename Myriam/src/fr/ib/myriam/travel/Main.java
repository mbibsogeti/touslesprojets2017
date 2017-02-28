package fr.ib.myriam.travel;

import java.util.Scanner;

/**
 * @author Myriam Benmansour le 30/01/2017
 */

public class Main {

	public static void main(String[] args) {

		System.out.println("----------------- Bienvenue dans notre agence de voyage 'Amerique du Nord' ----------------");

		Scanner sc = new Scanner(System.in);

		String pays[] = {"q","a","c","eu"};
		String etat[] = {"nevada","washington","californie","floride","massachusets","texas","new-york"};
		String reponse = "";
		
		System.out.println(
				"Que voulez-vous faire à présent ? q pour quitter, a pour voyager en Alaska, c pour voyager au Canada ou eu pour voyager au Etas-Unis");
		reponse = sc.nextLine();
		
		for (String i:pays){
			
			if (reponse.equals(i)){
				
				if (reponse.equals("eu")){
					
					System.out.println("en minuscule, écrivez le nom de l'état ou vous souhaitez atterrir");
					reponse = sc.nextLine();
					if (reponse.equals("nevada"))
						Amerique.goNevada();
					
					else if (reponse.equals("texas"))
						Amerique.goTexas();
					
					else if (reponse.equals("louisianne"))
						Amerique.goLouisianne(sc);
					
					else if (reponse.equals("floride"))
						Amerique.goFloride(sc);
					
					else if (reponse.equals("new-york"))
						Amerique.goNewYork();
					
					else 
						System.out.println("pas de voyage pour cet état");
					
				}
				else if (reponse.equals("a")){
					System.out.println("voyage en Alaska");
					Amerique.goAlaska(sc);
					
				}
				else if (reponse.equals("c")){
					do {
						System.out.println("Souhaitez vous aller au Saskakchewan ? (o/n)");
						reponse = sc.nextLine();
					} while (reponse.equals("o") && reponse.equals("n"));

					if (reponse.equals("o")) {
						float hotel = 45;
						float avion = 795;
						Amerique.goCanada(hotel, avion);
					} else {
						float hotel = 45;
						float avion = 785;
						Amerique.goCanada(hotel, avion);
					}
					
				}
				else 
					System.out.println("au revoir et à bientôt !");
			}
		}
		
		sc.close();
	}



	
}
