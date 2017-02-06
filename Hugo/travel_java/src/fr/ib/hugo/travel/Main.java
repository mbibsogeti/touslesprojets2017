package fr.ib.hugo.travel;

import java.util.Scanner;

public class Main {

	static void doAlaska(Scanner sc) {

		System.out.println("Indiquez le nombre de jours que vous désirez partir: ");
		int Duree = sc.nextInt();
		float PrixVol = 860;
		int reduction = 20;
		float PrixSejour = 48;
		float PrixTot = (PrixVol + Duree * PrixSejour) * (1 - (reduction / 100f));

		if (Duree > 0 & Duree <= 7) {

			System.out.println("Alaska: -" + reduction + "% sur " + String.format("%.2f", PrixVol) + " € d\'avion et "
					+ Duree + " jours à " + String.format("%.2f", PrixSejour) + " €/jour. Prix total: "
					+ String.format("%.2f", PrixTot) + " €");
		}

		else {
			if (Duree <= 15) {
				System.out
						.println("Alaska: -" + reduction + "% sur " + String.format("%.2f", PrixVol) + " € d\'avion et "
								+ Duree + " jours à " + String.format("%.2f", PrixSejour) + " €/jour. Prix total: "
								+ String.format("%.2f", PrixTot) + " €. Vous avez en plus un porte-clé de l'Alaska");
			} else {
				System.out
						.println("Alaska: -" + reduction + "% sur " + String.format("%.2f", PrixVol) + " € d\'avion et "
								+ Duree + " jours à " + String.format("%.2f", PrixSejour) + " €/jour. Prix total: "
								+ String.format("%.2f", PrixTot) + " €. Vous avez en plus une pépite d'or!!");
			}
		}

		switch (Duree) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("Vous parterez avec Air France");
			break;
		case 7:
		case 14:
		case 21:
		case 28:
			System.out.println("Vous parterez avec Condor");
			break;
		default:
			System.out.println("Vous parterez avec Alaska Airlines");
			break;
		}

		for (int i = 1; i <= Duree; i++) {

			if (i == 1 | i == Duree) {
				System.out.println("jour" + i + ": Avion");
			} else {
				if (i % 4 == 1) {
					System.out.println("jour" + i + ": Crabe royal");
				} else {
					System.out.println("jour" + i + ": Pêche");
				}
			}
		}
		sc.close();
	}

	static void doCanada(float _PrixVol, float _PrixSejour) {
		int[] Jour = { 7, 9, 13, 16, 18 };
		float[] PrixTot = new float[Jour.length];
		float[] PrixTot1 = new float[Jour.length];
		for (int i = 0; i <= 4; i++) {
			PrixTot[i] = getCanadaPrice(_PrixVol, _PrixSejour, Jour[i]);
			PrixTot1[i] = getCanadaPrice(Jour[i]);
			System.out.println("Partir " + Jour[i] + " jours: Prix total " + PrixTot[i] + " €");
		}
	}

	static float getCanadaPrice(float _PrixVol, float _PrixSejour, int _Jour) {
		float PrixTot = (_PrixVol + _Jour * _PrixSejour);
		return PrixTot;
	}

	static float getCanadaPrice(int _Jour) {
		return getCanadaPrice(1000, 100, _Jour);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvenu(e) à notre agence de voyage");
		System.out.println(
				"Choisisez votre destination: Alaska (option a), Canada (option c), Saskakchewan (option s), Washington (option w), Nevada (option n), Texas (option t), Louisiane (option l), Florida (option f)");
		Scanner sc = new Scanner(System.in);
		String menu = sc.nextLine();

		switch (menu) {
		case "a":
			doAlaska(sc);
			break;
		case "c":
			doCanada(785, 45);
			break;
		case "s":
			doCanada(100, 70);
			break;
		case "w":
			USA.doWashington();
			break;
		case "n":
			USA.doNevada();
			break;
		case "t":
			USA.doTexas();
			break;
		case "l":
			USA.doLouisiane(sc);
			break;
		case "f":
			USA.doFlorida(sc);
			break;
		case "y":
			USA.doNewYork();
		}

		// if (menu.equals("a")) {
		// doAlaska(sc);
		// }
		//
		// else {
		// if (menu.equals("c")) {
		// doCanada(785, 45);
		// } else {
		// if (menu.equals("s")) {
		// doCanada(1000, 70);
		// } else {
		// if (menu.equals("w")) {
		// USA.doWashington();
		// }
		// }
		// }
		sc.close();
		// for(int i=0,j=0;j<20;j+=i,i++){
		// System.out.println("i="+i);
		// System.out.println("j="+j);
		// };

		// int b=6|11;
		// int a=0b000010011110;
		//
		// System.out.println(a);
		// System.out.println(b);
		//
		// b=b<<1;
		//
		// System.out.println(b);
		//
		// b+=10;
		//
		// System.out.println(b);
		// boolean[]tb=new boolean[30];
		// tb[29]=false;
		// System.out.println(tb);
		// int[]ti={5,4,0,0};
		// System.out.println(ti);
		// System.out.println(ti[ti[0]-4]);
	}
}
