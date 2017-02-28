package fr.ib.myriam.travel;

import java.time.LocalDateTime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;

public class Amerique {
	
	
	static void goWashington(){
		Etat washington = new Etat("Washington");
		System.out.println("pas de voyage pour cet état !");
	}
	
	static void goNevada(){
		Etat nevada = new Etat("Nevada");
		System.out.println("Welcome to Nevada !");
		
		Destination d1 = new Destination("Vallé de la mort", nevada, 1);
		d1.extend(2);
		System.out.println(d1.toString());
	}
	
	static void goAlaska(Scanner sc) {

		float billet = 860;
		float tarif_j = 48;
		float nb_jour = 7;
		float promo = 20;

		System.out.println("combien de jour souhaitez vous partir ?");
		nb_jour = sc.nextInt();

		float tot = (billet + (tarif_j * nb_jour));
		String tot_ = String.format("%.2f", tot);
		float prix_promo = tot * (1 - (promo / 100));
		String prix = String.format("%.2f", prix_promo);

		System.out.println("le voyage coûtera : " + tot_ + " €");
		System.out.println("Avec notre offre promotionelle, nous vous faisons une réduction de -" + promo
				+ "%. Le prix tombe à : " + prix + " €");

		switch ((int) (nb_jour)) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 6:
		case 8:
			System.out.println("Le voyage se fera avec Air France");
			break;
		case 7:
		case 14:
		case 21:
		case 28:
			System.out.println("Le voyage se fera avec condor");
			break;
		default:
			System.out.println("Le voyage se fera avec Alaska AirLines");
		}

		if (nb_jour > 15)
			System.out.println(
					"Vu la durée de votre séjour, nous vous offrirons en souvenir une petite pépite d'or à votre retour :)");

		else if (nb_jour < 14 && nb_jour > 8)
			System.out.println(
					"Vu la durée de votre séjour, nous vous offrirons en souvenir un porte-clé à votre retour :)");

		else
			System.out.println(
					"Votre séjour est trop court, vous n'aurez pas le temps de profiter de l'Alaska ! Nous attendrons votre prochain voyage pour vous offrir un souvenir :)");

		System.out.println("\nDétail du voyage :");
		System.out.println("Jour 1 : Avion");
		for (int i = 1; i < (nb_jour - 1); i++)
			if (i % 4 != 0)
				System.out.println("Jour " + (i + 1) + " : Pêche");
			else
				System.out.println("Jour " + (i + 1) + " : Garstronomie");
		System.out.println("Jour " + (int) (nb_jour) + " : Avion");

	}

	static void goCanada(float hotel, float avion) {
		System.out.println("Bienvenue au Canada !");

		int nb_jours[] = { 7, 9, 13, 16, 18 };

		for (int i : nb_jours) {
			float prix = getCanadaPrice(hotel, avion,i);
			System.out.println(i + " jours : " + prix + " €");
		}
	}

	static float getCanadaPrice(float hotel, float avion, int jours) {
		float prix = (float) (jours) * hotel + avion * 2;
		return prix;
	}
	
	static float getCanadaPrice(int jours) {
		float hotel = 45;
		float avion = 785;
		float prix =  getCanadaPrice (hotel, avion, jours);
		return prix;
	}
	
	static void goTexas(){
		Etat texas = new Etat("Texas");
		System.out.println("Welcome to Texas !");
		
		CoastalDestination d = new CoastalDestination("Padre Island", texas, 3,"Felicy");
		d.extend(2);
		System.out.println(d.toString());
	}

	static void goLouisianne(Scanner sc){
		String lieu;
		String nom;
		File resa = new File("reservation.csv");
		FileWriter fw;

		System.out.println("Où souhaitez vous aller en Lousiane ?");
		lieu = sc.nextLine();
		lieu = lieu.trim();
		
		String ch="";
		
		try {
			ch = lieu.substring(0,1);
			lieu = ch.toUpperCase()+lieu.substring(1);
			}
		catch (Exception e){
			System.err.println("pas de place entrée");
		}
		finally {
			if (ch.equals("")){
				lieu = "Nouvelle Orléan";
				System.out.println("Pas de lieu indiqué, par défaut vous atterirez à la Nouvelle Orléans");
			}
		}
		

		System.out.println("Quel est votre nom, il sera utilisé pour validé le devis et restera confidentiel ?");
		nom = sc.nextLine();	
		nom = nom.trim();
		nom = nom.substring(0, 1).toUpperCase()+nom.substring(1);
		
		System.out.println("Votre demande de voyage pour "+lieu+" est bien enregistrée au nom de "+nom);
		
		LocalDateTime t = LocalDateTime.now();
		t = t.plusWeeks(7).plusDays(5);
		
		System.out.println("Départ au mieux le : "+String.format("%02d",t.getDayOfMonth())+"/"+String.format("%02d",t.getMonthValue()));
	
		try {
			fw = new FileWriter(resa, true);
			fw.write(nom+";"+lieu+";"+LocalDateTime.now()+";"+t+"\n");
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void goFloride(Scanner sc){
		String nom;
		String email;
		Connection conn;
		PreparedStatement st;
		
		System.out.println("Quel est votre nom");
		nom = sc.nextLine();
		System.out.println("A quel email devons nous envoyer les billets ?");
		email = sc.nextLine();
		
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:florida.sqlite");
			st = conn.prepareStatement("INSERT INTO demande(name, email) VALUES (?,?);");
			
			st.setString(1, nom);
			st.setString(2, email);
			st.executeUpdate();
			
			PreparedStatement st3 = conn.prepareStatement("SELECT name FROM demande WHERE email=?");
			st3.setString(1, email);
			ResultSet rs = st3.executeQuery();
			String names = "";
			
			while (rs.next())
				names += rs.getString("name")+", ";
			rs.close();
			
			conn.close();
			System.out.println("Demande de "+nom+" enregistré - "+names);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("votre demande a été enregistrée");
	}
	
	public static void goNewYork(){
		NewYorkFrame f = new NewYorkFrame();
		
		
	}

}

