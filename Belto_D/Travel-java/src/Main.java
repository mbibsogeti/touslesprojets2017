import java.util.Scanner;

public class Main {
	// fonction CanadaPrice, tous les calculs dans Canada
	public static int getCanadaPrice(int billet, int nuit, int jours){
		int tot = 0;
		// (Voyage Canada, Avion=785e, hotel=45e, afficher les prix pour
		// 7j,9j,13j,16j,18,//
		// surcharge de la fonction getCanadaprice
		// La fonction getCanadaPrice (int, int, int) fait appelle à la fonction getCanadaprice(int)
		tot = billet + (nuit * getCanadaPrice(jours));
		return tot;
	};
	public static int getCanadaPrice (int jours){
		return jours;
	};
	// scanner sc est en paramètre de la fonction doAlaska
	public static void doAlaska(Scanner sc) {
		int offre = -20;
		long avion = 860;
		System.out.println("Rentrez le nombre de jours de vacances");
		int duree = sc.nextInt();
		long pension = 48;
		double total;
		total = avion + (duree * pension);
		total = ((100 + offre) * total) / 100;
		String i;
		i = "\u20ac";
		/* Demarrage Java avec Mr Blanchard (30-01-2017)
		 * System.out.println("Hello "); System.out.println("Word");
		 * System.out.println(i); System.out.println("Hello \"Bob\"!");
		 */
		System.out.println("Alaska :" + offre + "%" + " sur " + avion + i + " d'avion et " + duree + "j"
				+ " de séjour à " + pension + i + ".");
		System.out.println("Le total est : " + total + i + ".");
		if (duree < 7) {
			System.out.println("Vous n'avez pas de prime");
		} else if (duree >= 8 && duree < 14) {
			System.out.println("Vous avez une porte clé");
		} else {
			System.out.println("vous avez gagné une pépite d'or");
		}

		switch (duree) {
		case 7:
			System.out.println("Vous voyagez avec Condor");
			break;
		case 14:
			System.out.println("vous voyagez avec Condor");
			break;
		case 21:
		case 28:
			System.out.println("vous voyagez avec Condor");
			break;
		case 1:
			System.out.println("Vous voyagez avec Air france");
			break;
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
			System.out.println("vous voyagez avec Air france");
			break;
		default:
			System.out.println("vous voyagez avec Alaska Airline");
		}
		for (int jour = 1; jour <= duree; jour++) {
			String s = "peche";
			if (jour == 1 || jour == duree)
				s = "Avion";
			else if (jour % 4 == 1)
				s = "Crabe";
			System.out.println(" Jour " + jour + " " + s);
		}
	}

	public static void doCanada(int billet, int nuit) {
		System.out.println("Vous irez au Canada");
		int tab[] = { 7, 9, 13, 16, 18 };
		int k = 0;
		while (k < 5) {
			int tot=getCanadaPrice(billet, nuit, tab[k]);
			System.out.println("Voyage " + (k + 1) + ",donc " + tab[k] + "jours" + "=" + tot + "e");
			k++;
		}
		/*
		 * // correction du prof, int[] vs={7,9,13,16,18}; for (int i=0;
		 * i<vs.length;i++){ int prix=785+ vs[i]*45;
		 * System.out.println(vs[i]+"j:"+prix);}
		 */
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Voyage en Alaska
		System.out.println("Bienvenue, où voulez-vous alllez");
		Scanner sc = new Scanner(System.in);
		String menu = sc.next();
		if (menu.equals("A")) {
			doAlaska(sc);
		}
		;
		// si vous tapez C, vous irez au Canada//
		if (menu.equals("C")) {
			int billet = 795;
			int nuit = 45;
			doCanada(billet, nuit);
		}
		if (menu.equals("K")) {
				int billet = 830;
				int nuit = 50;
				doCanada(billet, nuit);
			}

		sc.close();
	}

}
