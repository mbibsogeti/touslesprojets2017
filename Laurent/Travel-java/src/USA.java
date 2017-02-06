//import java.time.LocalDate;
//import java.time.Period;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


//Class USA permet de définir l'affichage des données concernant les destinations vers les USA
public class USA {

	public static final int NB_ERREUR = 5;
	
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
		System.out.println("Le tout vous reviendrait à " + String.format("%.2f",(PrixTotal - ((PrixTotal * 20) / 100)))
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

	public static void doLouisiane(Scanner sc, Destination Louisiane) {
		Louisiane = new Destination ("","Louisiane",0); 
		byte cptErreur=NB_ERREUR;
		String clientNom = null;
		String tempString = null;
		Exception e;
		
		do{
			e=null;
			System.out.println("\nOù souhaitez-vous vous rendre en "+Louisiane.getState()+" ?");
			try {
				//Création du fichier de listing des demandes
				FileWriter fDemande = new FileWriter(".\\Demande.csv",true);
				
				tempString=sc.nextLine();
				tempString=tempString.trim();
				tempString=tempString.substring(0,1).toUpperCase()+tempString.substring(1);
				Louisiane.setName(tempString);
				
				System.out.println("\nVeuillez indiquer votre nom svp");
				clientNom=sc.nextLine();
				
				//System.out.println("\nQuand souhaitez-vous partir ?");
				//LocalDate dateDepart=LocalDate.parse(sc.nextLine());
				//Period organisPeriod = dateDepart.until(LocalDate.now());
				
				fDemande.write("\""+Louisiane.getName()+"\",\""+clientNom+"\"\n");
				
				fDemande.close();
				
				System.out.println("\nLa demande de "+clientNom+", pour un voyage vers "+Louisiane.getName()+" a été enregistrée !!");
			}catch(IOException tempE){
				System.out.println("Une erreur interne nous oblige à clore cette option, nous sommes désolé.");
				return;
			}catch(Exception tempE){
				e=tempE;
				if(Louisiane.getName()==""){
					System.out.println("Veuillez rentrer le nom d'une ville de louisiane svp !");
				}else{
					if(clientNom==null || clientNom==""){
						System.out.println("Veuillez rentrer votre nom svp !");
					}
				}
				System.out.println("Vous n'avez droit "+(cptErreur-1==0?"à plus rien.":"qu'à "+(cptErreur-1)+" erreures ..."));
				cptErreur--;
			}
		}while((e!=null)&&(cptErreur!=0));
		if(cptErreur<=0) return;
		
		
	}

	public static void doFloride(Scanner sc, Destination floride) {
		floride = new Destination("","Floride",0);
		byte cptErreur=NB_ERREUR;
		String clientNom = null;
		String clientEmail = null;
		Exception e;
		
		do{
			e=null;
			try {
				System.out.println("\nVeuillez indiquer votre nom svp");
				clientNom=sc.nextLine();
				
				System.out.println("\nVeuillez indiquer votre email svp");
				clientEmail=sc.nextLine();
				
				//Création de la DB
				Class.forName("org.sqlite.JDBC");
				Connection conn=DriverManager.getConnection("jdbc:sqlite:Florida.sqlite");
				
				//Création d'un conteneur de requetes
				Statement st = conn.createStatement();
				
				//Etablissement d'une requete
				st.executeUpdate("CREATE TABLE IF NOT EXISTS demande (id INTEGER PRIMARY KEY, name TEXT, email TEXT);");
				
				//Utilisation des requètes préparées
				PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(name, email) VALUES (?,?)");
				st2.setString(1, clientNom);
				st2.setString(2, clientEmail);
				st2.executeUpdate();
				
				//Récupération des resultats d'une requete
				PreparedStatement st3 = conn.prepareStatement("select name, email from demande where email=?");
				st3.setString(1, clientEmail);
				ResultSet rs = st3.executeQuery();
				
				//Récupération dans une variable
				String results="";
				while(rs.next()){
					results += rs.getString("name")+" --> "+rs.getString("email")+"\n";
				}
				rs.close();
				System.out.println("\n Voici vos résultats :\n"+results);
				
				//Fermeture de la base
				conn.close();
				
				System.out.println("\nLa demande de "+clientNom+" a été enregistrée !!");
			}catch(SQLException tempE){	
				System.out.println("Une erreure est survenue au niveau de la DB");
				cptErreur--;
			}catch(Exception tempE){
				e=tempE;
				if(clientNom==null || clientNom==""){
					System.out.println("Je n'ai pas compris votre nom !");
				}else{
					if(clientEmail==null || clientEmail==""){
						System.out.println("Je n'ai pas compris votre email !");
					}
				}
				
				System.out.println("Vous n'avez droit "+(cptErreur-1==0?"à plus rien.":"qu'à "+(cptErreur-1)+" erreures ..."));
				System.out.println(tempE);
				cptErreur--;
			}
		}while((e!=null)&&(cptErreur!=0));
		if(cptErreur<=0) return;
		
	}

	public static void doNewYork(Scanner sc, Destination floride){
		new NewYorkFrame();
	}
}
