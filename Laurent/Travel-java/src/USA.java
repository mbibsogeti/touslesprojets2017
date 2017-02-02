import java.util.Scanner;

//Class USA permet de définir l'affichage des données concernant les destinations vers les USA
public class USA {

	// CONSTRUCTEURS
	public USA() {
	}

	//METHODES
	public static void doWashington(){
		System.out.println("Malheureusement, il n'y a pas de voyage prévu pour cet état.");
	}
	
	public static void doNevada(){
		Destination dNev = new Destination("Reno","Nevada",1);
		dNev.extendDays(7);
		System.out.println(dNev.toString());
	}

	public static void doTexas() {
		CostalDestination cdTex = new CostalDestination(null,"Texas",1);
		cdTex.setName("PadreIsland");
		cdTex.setBoat("Queen-Mary II");
		System.out.println(cdTex.toString());
	}
	
	public static void doAlaska(Scanner sc, byte Sejour, float Prix, float PrixParJour, byte Promo){
		boolean ConditionBoucle2 = true;
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
	}
}
