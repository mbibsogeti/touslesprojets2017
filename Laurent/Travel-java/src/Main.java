import java.util.Scanner;

public class Main {
	
	public static boolean ConditionBoucle1 = true; 
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// Initialisation du texte d'introduction
		String InitText = "Bienvenue dans notre agence de voyage \"Paradise on ice !!\"";

		// Affichage du texte à l'écran
		System.out.println(InitText);

		byte Promo = -20;
		float Prix = 860;
		byte Sejour = 0;
		float PrixParJour = 48;
		
		String Option;
		// Acquisition de l'intension de l'utilisateur
		
		do {
			System.out.println("\nQue souhaitez-vous faire aujourd'hui :\n a : Alaska\n c : Canada\n f : Floride\n l : Louisiane\n n : Nevada\n ny : New York\n s : Saskakchewan\n t : Texas\n w : Washington\n q : Quitter");
			Option = sc.nextLine();
			//sc.close();
			switch (Option) {
			case "a":
				
				USA.doAlaska(sc, Sejour, Prix, PrixParJour,Promo);
				break;
				
			case "c":
				short[] j={7,9,13,16,18};
				doCanada(sc,Sejour,785,45,j);
				break;
				
			case "s":
				short[] j1={7,9,13,16,18};
				doCanada(sc,Sejour,795,45,j1);
				break;
				
			case "w":
				USA.doWashington();
				break;
				
			case "t":
				USA.doTexas();
				break;
				
			case "n":
				USA.doNevada();
				break;
				
			case "l":
				Destination Louisiane = null;
				USA.doLouisiane(sc,Louisiane);
				break;
				
			case "f":
				Destination floride = null;
				USA.doFloride(sc,floride);
				break;
			
			case "ny":
				Destination newyork = null;
				USA.doNewYork(sc,newyork);
				break;	
			
			case "q":
				Quit(sc);
				break;
				
			default:
				System.out.println("\nVeuillez rentrer la lettre correspondant aux différentes options énoncées svp !");
			}
		} while (ConditionBoucle1);
		
	}

	static void doCanada(Scanner sc,byte Sejour, float Prix, float PrixParJour, short[] Jours){
			
			System.out.println("Voici nos offres :");
			for(short i:Jours){
				System.out.println(i+" : "+getCanadaPrice(Prix,PrixParJour,i));
			}
	}

	static void Quit(Scanner sc){
		System.out.println("\nAu plaisir de vous revoir.\n");
		ConditionBoucle1 = false;
	}
	
	static float getCanadaPrice(float Prix, float PrixParJour, short NbJrs){
		return NbJrs*PrixParJour+Prix;
	}
	
	static float getCanadaPrice(short NbJrs){
		float PPJ= 45;
		float P = 795;
		return getCanadaPrice(P,PPJ,NbJrs);
	}
	
	
}
