import java.util.Scanner;

public class Main {

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
		boolean ConditionBoucle1 = true;
		boolean ConditionBoucle2 = true;
		String Option;

		// Acquisition de l'intension de l'utilisateur
		
		do {
			System.out.println("\nQue souhaitez-vous faire aujourd'hui :\n a : Alaska \n c : Canada \n q : Quitter");
			Option = sc.nextLine();
			//sc.close();
			switch (Option) {
			case "a":
				
				System.out.println("Veuillez entrer le nombre de jour désirés au niv de votre de votre séjour, svp");
				do {
					try {
						Sejour = sc.nextByte();
						ConditionBoucle2 = false;
						
					} catch (java.util.InputMismatchException e) {
						System.out.println("Veuillez rentrer un chiffre svp !");
						sc.next();
					}
				} while (ConditionBoucle2);
				
				float PrixTotal = Prix + PrixParJour * Sejour;

				String TextPromo = "Promo : " + Promo + " % sur " + Prix + "\u20ac d'avion et " + Sejour + " jours à "
						+ PrixParJour + "\u20ac la nuit !!\nSoit " + (Sejour * PrixParJour) + "\u20ac le séjour !!!!!";

				System.out.println(TextPromo);
				System.out.println("Le tout vous reviendrait à " + (PrixTotal - ((PrixTotal * 20) / 100))
						+ "\u20ac !!!!!!!!!!!! \nAvec une économie de " + ((PrixTotal * 20) / 100)
						+ "€ sur le billet d'avion. °_°");
				if (Sejour >= 15) {
					System.out.println("De plus, avec " + Sejour + " jours de séjour, vous gagnez une pépite d'or !!!");
				} else {
					if ((Sejour >= 8) && (Sejour < 14)) {
						System.out
								.println("De plus, avec " + Sejour + " jours de séjour, vous gagnez un porte clé !!!");
					} else {
						System.out.println("Malheureusement pour un séjour de " + Sejour
								+ "jrs, vous ne pouvez pas bénéficier des cadeaux liées à cette offre");
					}
				}

				switch (Sejour % 7) {
				case 0:
					System.out.println("Vous prendrez la compagnie Condor");
					break;
				default:
					if (Sejour <= 8)
						System.out.println("Vous prendrez la compagnie Air France");
					else {
						System.out.println("Vous prendrez la compagnie Alaska Airlines");
					}
					break;
				}

				// Commenter en indiquant n° de dossier dont dépend la mise en
				// place du code
				System.out.println("Voici votre programme :");
				for (int i = 0; i < Sejour; i++) {
					// "Jour 1 : Avion" ou "Dernier jour : Avion"
					if (i == 0 || i == Sejour - 1) {
						System.out.println("Jour " + (i + 1) + ": Avion");
					} else {
						// "Tout les 3 jours, Repos"
						if (i % 4 == 0) {
							System.out.println("Jour " + (i + 1) + ": Crabe Royal");
						} else {
							// "Activité pêche le reste du temps"
							System.out.println("Jour " + (i + 1) + ": Pêche");
						}
					}
				}
				if (Sejour < 6)
					System.out.println(
							"\nMalheureusement avec ce nombre de jours pour votre séjour, vous ne pourrez pas déguster notre merveilleux crabe royal.");
				//ConditionBoucle = false;
				break;
				
			case "c":
				short[] Jours= {7,9,13,16,18};
				PrixParJour=45;
				Prix=785;
				
				System.out.println("Voici nos offres :");
				for(short i:Jours){
					System.out.println(i+" : "+(i*PrixParJour+Prix));
				}
				break;
				
			case "q":
				System.out.println("Au plaisir de vous revoir");
				ConditionBoucle1 = false;
				sc.close();
				break;
			default:
				System.out.println("Veuillez rentrer un chiffre svp !");
			}
		} while (ConditionBoucle1);
		


	}

}
