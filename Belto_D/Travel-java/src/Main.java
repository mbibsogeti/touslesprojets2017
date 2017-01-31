import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Voyage en Alaska
		Scanner sc = new Scanner(System.in);
		int offre = -20;
		long avion = 860;
		System.out.println("Rentrez le nombre de jours de vacances");
		short duree = sc.nextShort();
		long pension = 48;
		double total;
		total = avion + (duree * pension);
		total = ((100 + offre) * total) / 100;
		String i;
		i = "\u20ac";
		/*
		 * System.out.println("Hello "); System.out.println("Word");
		 * System.out.println(i); System.out.println("Hello \"Bob\"!");
		 */
		System.out.println("Alaska :" + offre + "%" + " sur " + avion + i + " d'avion et " + duree + "j"
				+ " de séjour à " + pension + i + ".");
		System.out.println("Le total est : " + total + i + ".");
		sc.close();
		if (duree < 7) {
			System.out.println("Vous n'avez pas de prime");
		} else if (duree >= 8 && duree < 14) {
			System.out.println("Vous avez une porte clé");
		} else {
			System.out.println("vous avez gagné une pépite d'or");
		}
		
	switch (duree){
	case 7: 
		System.out.println("Vous voyagez avec Condor");
		break;
	case 14:
		System.out.println("vous voyagez avec Condor");
		break;
	case 21:
		System.out.println("vous voyagez avec Condor");
		break;
	case 28:
		System.out.println("vous voyagez avec Condor");
		break;
	case 1: 
		System.out.println("Vous voyagez avec Air france");
		break;
	case 2:
		System.out.println("vous voyagez avec Air france");
		break;
	case 3:
		System.out.println("vous voyagez avec Air france");
		break;
	case 4:
		System.out.println("vous voyagez avec Air france");
		break;
	case 5:
	
	case 6:
		System.out.println("vous voyagez avec Air france");
		break;
	default :
		System.out.println("vous voyagez avec Alaska Airline");
		}	
	}
}
