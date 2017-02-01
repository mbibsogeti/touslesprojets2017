package fr.ib.hugo.travel;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvenu(e) à notre agence de voyage");
		System.out.println("Souhaitez-vous partir en Alaska (option a) ou en Canada (option b)?");
		Scanner sc = new Scanner(System.in);
		String menu = sc.next();
		if (menu.equals("a")) {
			System.out.println("Indiquez le nombre de jours que vous désirez partir: ");
			int Duree = sc.nextInt();
			float PrixVol = 860;
			int reduction = 20;
			float PrixSejour = 48;
			float PrixTot = (PrixVol + Duree * PrixSejour) * (1 - (reduction / 100.0f));
			// Duree=sc.nextInt();

			if (Duree > 0 & Duree <= 7) {

				System.out.println("Alaska: -" + reduction + "% sur " + PrixVol + " € d\'avion et " + Duree
						+ " jours à " + PrixSejour + " €. Prix total: " + PrixTot + " €");
			}

			else {
				if (Duree <= 15) {
					System.out.println("Alaska: -" + reduction + "% sur " + PrixVol + " € d\'avion et " + Duree
							+ " jours à " + PrixSejour + " €. Prix total: " + PrixTot
							+ " €. Vous avez en plus un porte-clé de l'Alaska");
				} else {
					System.out.println("Alaska: -" + reduction + "% sur " + PrixVol + " € d\'avion et " + Duree
							+ " jours à " + PrixSejour + " €. Prix total: " + PrixTot
							+ " €. Vous avez en plus une pépite d'or!!");
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
		}

		else {
			if (menu.equals("b")) {
				int[] Jour = { 7, 9, 13, 16, 18 };
				float PrixVol = 785;
				float PrixSejour = 45;
				float[] PrixTot = new float[Jour.length];
				for (int i = 0; i <= 4; i++) {
					PrixTot[i] = (PrixVol + Jour[i] * PrixSejour);
					System.out.println(PrixTot[i]);
				}
			}
		}

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