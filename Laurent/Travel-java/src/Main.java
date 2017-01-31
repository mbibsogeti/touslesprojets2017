import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		// Initialisation du texte d'introduction
		String InitText="Bienvenue dans notre agence de voyage \"Paradise on ice !!\"";
		
		//Affichage du texte à l'écran
		System.out.println(InitText);
		
		byte Promo = -20;
		float Prix = 860;
		byte Sejour=0;
		float PrixParJour=48;
		boolean Flag=true;
		System.out.println("Veuillez entrer le nombre de jour désirés au niv de votre de votre séjour, svp");
		do{
			try{
			Sejour=sc.nextByte();
			Flag=false;
			sc.close();
			}catch(java.util.InputMismatchException e){
				System.out.println("Veuillez rentrer un chiffre svp !");
				sc.next();
			}
		}while (Flag);
		
		float PrixTotal= Prix + PrixParJour*Sejour;
		
		String TextPromo="Promo : "+Promo+" % sur "+Prix+"\u20ac d'avion et "+Sejour+" jours à "+PrixParJour+"\u20ac la nuit !!\nSoit "+(Sejour*PrixParJour)+"\u20ac le séjour !!!!!";
		
		System.out.println(TextPromo);
		System.out.println("Le tout vous reviendrait à "+(PrixTotal-((PrixTotal*20)/100))+"\u20ac !!!!!!!!!!!! \nAvec une économie de "+((PrixTotal*20)/100)+"€ sur le billet d'avion. °_°");
		if(Sejour >= 15){
			System.out.println("De plus, avec "+Sejour+" jours de séjour, vous gagnez une pépite d'or !!!");
		}else{
			if ((Sejour>=8) && (Sejour<14)){
				System.out.println("De plus, avec "+Sejour+" jours de séjour, vous gagnez un porte clé !!!");
			} else {
				System.out.println("Malheureusement pour un séjour de "+Sejour+"jrs, vous ne pouvez pas bénéficier des cadeaux liées à cette offre");
				}
		}
		
		switch (Sejour%7) {
		case 0:
			System.out.println("Vous prendrez la compagnie Condor");
			break;
		default :
			if(Sejour<=8)System.out.println("Vous prendrez la compagnie Air France");
			else{
				System.out.println("Vous prendrez la compagnie Alaska Airlines");
			}
			break;
		}
		
	}

}
