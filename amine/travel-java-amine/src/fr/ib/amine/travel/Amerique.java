package fr.ib.amine.travel;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JFrame;

public class Amerique {

	/*---------------------Etat de Washington DC-------*/
	public static void doWashington(Scanner wa) {
		System.out.println("Pas de voyage pour cet état");
	}

	/*--------------------Etat du Nevada------------*/
	public static void doNevada(Scanner Ne) {
		System.out.println("Bon choix!!");
		// Destination d1 = new Destination("Nevada", "USA", 2);
		Destination d1 = new Destination();
		d1.setName("La vallée de la mort");
		d1.setState("USA");
		d1.setDays(10);
		d1.extend(5);
		System.out.println(d1.toString() + " " + d1.getWeeks() + " weekends");
		// System.out.println(d1.toString1());
	}

	/*-------------Etat du Texas-----------*/
	public static void doTexas(Scanner te) {
		System.out.println("Ville natale des Bush o_O'");
		CoastalDestination d1 = new CoastalDestination("Padre Island", "Mexique", 15, "TOTO");
		/*
		 * d1.setName("Padre Island"); d1.setState("Mexique"); d1.setDays(15);
		 * // d1.extend(0); d1.setBoat("Titanic");
		 */
		System.out.println(d1.toString());
	}

	/*-------Etat de la Nouvelle Orleans---------*/
	public static void doLouisiane(Scanner sc) {
		System.out.println("Lieu?");
		String lieu = sc.nextLine();
		lieu = lieu.trim(); // enlève les espaces à l'intérieur d'une chaîne
		try {
			lieu = lieu.substring(0, 1).toUpperCase() + lieu.substring(1);

			System.out.println("Nom?");
			String nom = sc.nextLine();
			System.out.println("Demande pour " + lieu + " enregistrée.");

			LocalDateTime t1 = LocalDateTime.now();
			t1 = t1.plusWeeks(7);
			t1 = t1.plusDays(5);
			System.out.println("Votre date de départ est prévue pour le " + t1.getDayOfMonth() + "-"
					+ t1.getMonthValue() + "-" + t1.getYear());
			System.out.println("Départ le " + String.format("%02d / %02d", t1.getDayOfMonth(), t1.getMonthValue()));
			// écrire louisiane.csv
			FileWriter fichier = new FileWriter("Louisiane.csv", true);
			fichier.write(lieu + ";" + nom + "\n");
			fichier.close();
		} catch (IOException ex) {
			System.out.println("Erreur IO: " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Erreur: " + ex.getMessage());
			// ex.printStackTrace(); // Message d'erreur
			// doLouisiane(sc); // Si on relance la méthode doLouisiane
		} finally {
			System.out.println("Fin de Louisiane");
		}
	}

	public static void doFloride(Scanner sc) {
		try {
			System.out.println("Votre Nom svp ?");
			String nom = sc.nextLine();
			System.out.println("Votre email svp ?");
			String mail = sc.nextLine();

			Class.forName("org.sqlite.JDBC");// indique la class du pilote
												// sqlite qui permet la
												// connection
			Connection conn = DriverManager.getConnection("jdbc:sqlite:florida.sqlite");
			Statement st1 = conn.createStatement();
			st1.executeUpdate("CREATE TABLE IF NOT EXISTS demande (id INTEGER PRIMARY KEY , nom TEXT, mail TEXT);");
			// Statement st2=conn.createStatement();
			// st2.executeUpdate(\""+nom+"\",\""+mail+"\")");

			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande (nom,mail)VALUES(?,?)");
			st2.setString(1, nom);
			st2.setString(2, mail);
			st2.executeUpdate();

			PreparedStatement st3 = conn.prepareStatement("SELECT nom FROM demande WHERE mail = ?");
			st3.setString(1, mail);
			ResultSet rs = st3.executeQuery();
			String names = "";
			while (rs.next())
				names += rs.getString("nom") + ",";
			rs.close();

			conn.close();
			System.out.println("Demande de " + nom + " enregistrée - " + names);
			// System.out.println("Demande est enregistrée " + "\n" + "Nom: " +
			// nom + "\n" + "mail: " + mail);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void doNewYork(Scanner sc) {
		//JFrame jf = new JFrame();
		//jf.setSize(500, 400); // taille de l'interface graphique
		//jf.setVisible(true); // affichage de l'interface graphique
		//jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // le programme
																// s'arrête une
																// fois la
																// fenêtre fermé
		new NewYorkFrame();
	}

}