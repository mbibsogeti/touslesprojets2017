

public class Main {

	public static void main(String[] args) {
		
		// Initialisation du texte d'introduction
		String InitText="Bienvenue dans notre agence de voyage \"Paradise on ice !!\"";
		
		//Affichage du texte à l'écran
		System.out.println(InitText);
		
		byte Promo = -20;
		float Prix = 860;
		byte Sejour=7;
		float PrixParJour=48;
		
		String TextPromo="Promo : "+Promo+" % sur "+Prix+"\u20ac d'avion et "+Sejour+" jours à "+PrixParJour+"\u20ac la nuit !!\nSoit "+(Sejour*PrixParJour)+"\u20ac le séjour !!!!!";
		
		System.out.println(TextPromo);
		System.out.println("Le tout vous reviendrait à "+((Prix-(Prix*20)/100)+(Sejour*PrixParJour))+"\u20ac !!!!!!!!!!!! \nAvec une économie de "+((Prix*20)/100)+"€");

	}

}
