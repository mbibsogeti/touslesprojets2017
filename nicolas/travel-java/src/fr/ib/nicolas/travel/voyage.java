
package fr.ib.nicolas.travel;

import java.util.Scanner; //bibioth�que pour la Class scanner

public class voyage {

	public static void main(String[] args) {

		int reduction = 20;
		float prixbillet = 860;
		int duree = 7; // dur�e du voyage
		float prixsejour = 48;
		float prixtotal = prixbillet - (prixbillet * reduction / 100)
				+ duree * (prixsejour - prixsejour * reduction / 100);
		int duree2; // dur�e du transit pour l'eesai des comande case.

		Scanner sc = new Scanner(System.in); // d�claration d'un objet scanner
		System.out.println("saisir la dur�e du trajet"); // affiche

		duree = sc.nextInt();
		System.out.println("saisir la dur�e du trajet en trnasit");
		duree2 = sc.nextInt();

		// attend que l'utilisateur rentre un entier et le met dans scanner(
		// sinon o peut fair un autre nextline)
		// autre possibilit� reduction = integer.parseInt( sc.next()); mais plus
		// lourd...

		sc.close(); // permet d 'arreter le scanner , typiquement si on utilise
					// des classe qui font appel a un truc externe

		if (duree < 8)
			System.out.println("rien");

		if (duree > 8 & duree < 14) {
			System.out.println("n porte clef");

		} else {
			if (duree > 14) {

				System.out.println("or");
			}
		}
		switch (duree2) {
		case 2: // on peut aussi list� les case comme ici case 2: case3: case 4:
				// System.out.println..; break;
			System.out.println("transite 2 jr");
			break;
		case 4:
			System.out.println("transite 4 jr");
			break;
		default:
			System.out.println("direct"); // lorsqu'on rentre dans une case on
											// fais pas les autres , si ya pas
											// de case compatible on va dans le
											// default
		}
		for (int j = 1; j <= duree; j++) {
			String s = "peche";
			if (j == 1 || j == duree) // || est un ou optimis�
				s = "avion"; // remarque ici une seul commande apr�s le if dc
								// pas de parenth�se ce qui n'interdi pas le if
			else if (j % 4 == 1)
				s = "crabe";
			System.out.println("jour" + duree + " peche");

			/*
			 * ma solution de la gestyion des jour et des activit�s pas fini :
			 * System.out.println("jour 1 : Avion"); for(int i=1; i<duree;i++){
			 * int j=0; if (j<3); System.out.println("jour"+duree+" crabe") j=0;
			 * }else{ System.out.println("jour"+duree+" peche") };
			 * 
			 * 
			 * } System.out.println("jour"+duree+" avion");
			 */
		}

	}

	// exemple a ne pas utilis� x<4 ? 01:09; ou x<4 boolean ... a ne pas trop
	// utilis� .

}

/*
 * structure while int x=2 while(x=5){ x++; } l' action fait 3 fois le tour
 * 
 * par contre si x =5 et do{x--;} while(x>0); la boucle se fait 5 fois
 * 
 * 
 * autre truc de boucle
 * 
 * for( int x=2; x<5; x++){...}; int d�clare la variable x<5 est la condition et
 * x++ ce qu'on fait ..)
 * 
 * dernier exemple compliqu� : for (int i = 0, j =0 ; j <20;j+=i,i++) j+=i
 * augmente j de i ..
 * 
 * autre commande mais peu utilis� sauf pour des petite boucle pour optimis� les
 * performances : do{ if(...) break; // sort de la boucle if(....) continue;
 * x--; }while(x>0);
 * 
 * 
 */
