package fr.ib.nicolas.travel;

import java.util.Scanner;

public class voyage2 {

	// public static int prixt; moche il vaut mieux les d�clarer dans chaque
	// fonction

	public static int getCalaskaprice(int prixav, int prixho) {
		// int prixt;
		// prixt = prixav + prixho * 2;
		// return prixt ; // attention cela renvoi un entier mais pas dans prixt
		// il fzut mettre dans l'appel de la focntion prixt=get...
		return prixav + prixho;

	}
	// public static int getCalaskaprice(int prixav, int prixho, int prixd){

	// return getcalaskaprice(int prixav, int prixho) + prixd;
	// }

	public static void do_canada(Scanner b) {

		// String menu = b.next();

		System.out.println("cananda");
	}

	public static void do_alaska(int a, int b) {

		System.out.println("alaska" + a + b);
	}

	public static void main(String[] args) {
		System.out.println("bienvenue");
		int prixt = 0;
		int prixhotel = 45;
		
		//String.format("%.1f", prixhotel);
		int prixavion = 785;
		// int duree = 18;
		// int[]tb=new int[4]; tableau sans valeurs
		// int[] ti = { 7, 9, 13, 16, 18 };

		/*
		 * for (int i=0; i<ti.length;i++){
		 * 
		 * int prix=785+45*ti[i]; System.out.println(ti[i]+"jour:"+prix+"�"); }
		 */
		Scanner sc = new Scanner(System.in);

		/*
		 * for (int j : ti) { int prix = 785 + 45 * j; System.out.println(j +
		 * "jour:" + prix + "�"); // inconv�nien pas de // retour en arri�re //
		 * , pas de saut // deux par deux , // pas d'index mais // que la valeur
		 * 
		 * }
		 */
		System.out.println("menu:......");
		String menu = sc.next();
		if (menu.equalsIgnoreCase("a")) { // permet de tester une chaine de
											// caract�re

			do_alaska(745, 45);

		}

		if (menu.equalsIgnoreCase("c"))

		{
			do_canada(sc);
		}
		if (menu.equalsIgnoreCase("Sask")) { // permet de tester une chaine de
												// caract�re

			do_alaska(72, 45);

		}
		if (menu.equalsIgnoreCase("prix")) { // permet de tester une chaine de
												// caract�re

			prixt = getCalaskaprice(prixavion, prixhotel);
			System.out.println("prixtot " + prixt);

		}
		if (menu.equalsIgnoreCase("w")) { // permet de tester une chaine de
											// caract�re

			Amerique.dowashingtown();

			System.out.println("pas de voyage ");
		}
		if (menu.equalsIgnoreCase("ne")) { // permet de tester une chaine de
			// caract�re

			Amerique.donevada();

			System.out.println("bal�se ");
		}
		if (menu.equalsIgnoreCase("init")) { // permet de tester une chaine de
			// caract�re

			Amerique.donevada();

			System.out.println("bal�se ");
		}
		if (menu.equalsIgnoreCase("l")){
			Amerique.do_louisiane();
			}
		
	
	
	
	if (menu.equalsIgnoreCase("f")){
		Amerique.do_floride();
		}
	if (menu.equalsIgnoreCase("ny")){
		Amerique.do_ny();
		}
}
}
