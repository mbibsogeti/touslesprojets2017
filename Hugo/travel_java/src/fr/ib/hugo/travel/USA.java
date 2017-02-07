package fr.ib.hugo.travel;

import java.util.Scanner;

import javax.swing.JFrame;

//import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.*;

public class USA {

	public static void doWashington() {
		System.out.println("Nous ne disposons pas d'offre de voyage pour Washington en ce moment.");
		return;
	}

	public static void doNevada() {
		Destination d1 = new Destination("Death Valley", "Nevada", 1);
		d1.extend(6);
		System.out.println(d1.toString());

		Destination d2 = new Destination();
		d2.setName("Las Vegas");
		d2.setState("Nevada");
		d2.setDays(14);
		System.out.println(d2.toString());

		Destination d3 = new Destination();
		System.out.println(d3.toString());
		return;
	}

	public static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();

		d1.setName("Padre Island");
		d1.setState("Texas");
		d1.setDays(10);
		// d1.setBoat("bateau pêcheur");
		System.out.println(d1.toString());
	}

	public static void doFlorida(Scanner sc) {
		String name = "";
		String email = "";
		try {
			System.out.println("Votre nom:");
			name = sc.nextLine();
			System.out.println("Votre adresse e-mail:");
			email = sc.nextLine();

			// connection à la base de données SQLite
			Class.forName("org.sqlite.JDBC");

			// appel au pilote de la base sqlite -> jdbc:sqlite, puis création
			// du fichier de la base florida.sqlite
			Connection conn = DriverManager.getConnection("jdbc:sqlite:florida.sqlite");

			// requête à la base de données pour créer une table
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS demande(" + "id INTEGER PRIMARY KEY, name TEXT, email TEXT);");

			// requête à la base de données pour remplir la table créée
			// précédemment
			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(name,email)VALUES(?,?)");
			st2.setString(1, name);
			st2.setString(2, email);
			st2.executeUpdate();

			// requête à la base de données pour afficher l'email de quelqu'un
			// dans la liste
			PreparedStatement st3 = conn.prepareStatement("SELECT name FROM demande WHERE email=?");
			st3.setString(1, email); // 1=premier ?, email=attribut local donné
										// comme argument pour la requête
			ResultSet rs = st3.executeQuery();
			String names = "";
			while (rs.next())
				names += rs.getString("name") + ", ";
			rs.close();

			conn.close();

			System.out.println("Demande de " + name + " enregistrée - " + names);
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	public static void doLouisiane(Scanner sc) {
		String lieu = "";
		String nom = "";
		try {
			System.out.println("Lieu?");
			lieu = sc.nextLine();
			lieu = lieu.trim();
			lieu = lieu.substring(0, 1).toUpperCase() + lieu.substring(1);
			lieu.toUpperCase();
			System.out.println("A quel nom?");
			nom = sc.nextLine();
			// } catch (IOException ioexc) {
			// System.out.println("Erreur IO: " + ioexc.getMessage());
		} catch (StringIndexOutOfBoundsException exc) {
			System.out.println("Erreur: " + exc.getMessage());
			exc.printStackTrace();
		} finally {
			System.out.println("Fin de Louisiane");
		}
		LocalDateTime DateAuj = LocalDateTime.now();
		int Mois = DateAuj.getMonthValue();
		int Jour = DateAuj.getDayOfMonth();
		int Heure = DateAuj.getHour();
		int Min = DateAuj.getMinute();
		int An = DateAuj.getYear();
		System.out.println("Demande pour " + lieu + " enregistrée le " + String.format("%02d", Jour) + "/"
				+ String.format("%02d", Mois) + "/" + An + " à " + String.format("%02d", Heure) + "h"
				+ String.format("%02d", Min) + " au nom de " + nom + ".");
		LocalDateTime DateDep = DateAuj.plusDays(54);
		Mois = DateDep.getMonthValue();
		Jour = DateDep.getDayOfMonth();
		An = DateDep.getYear();
		System.out.println(
				"Compte tenu du temps nécessaire pour l'organisation du voyage, la date de départ au mieux sera le "
						+ String.format("%02d", Jour) + "/" + String.format("%02d", Mois) + "/" + An);
		FileWriter f1;
		try {
			f1 = new FileWriter("liste.csv", true);
			f1.write(lieu + ", " + nom + System.lineSeparator());
			f1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// FileReader fr1;
		// fr1=new FileReader("liste.csv");
		// fr1.read;
		sc.close();
	}

	public static void doNewYork() {
		new NewYorkFrame();
	}

}