package fr.ib.marcantoine.travel;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Scanner;
import javax.swing.JFrame;

public class America {

	// FONCTION WASHINGTON
	static void doWashington() {
		System.out.println("Pas de voyage pour cet √©tat.");
	}

	// FONCTION NEVADA
	static void doNevada() {
		Destination d1 = new Destination();
		// d1.name = "Las Vegas";
		d1.setDays(Destination.FIXED_DAYS);
		System.out.println(d1.getName() + " pendant " + d1.getDays() + " jours");
		System.out.println(d1.toString());
		System.out.println(d1.getWeeks());
	}

	// FONCTION TEXAS
	static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();
		// d1.setName("Florabama");
		// d1.setState("Alabama");
		// d1.setDays(12);
		// System.out.println (d1.toString());
		// d1.setBoat("Hollandais Volant");
		System.out.println(d1.toString());
	}

	// FONCTION LOUSISIANA
	static void doLouisiana(Scanner sc) {

		System.out.println("Dans quelle ville voulez-vous allez ?");
		String place = sc.nextLine();

		place = place.trim();
		try {
			place = place.substring(0, 1).toUpperCase() + place.substring(1);
			System.out.println("Comment vous appelez-vous ?");
			String client = sc.nextLine();
			LocalDateTime takeoffdate = LocalDateTime.now().plusDays(54);
			System.out.println("Demande pour " + place + " enregistr√©e, " + "d√©part au mieux le "
					+ String.format("%02d / %02d", takeoffdate.getDayOfMonth(), takeoffdate.getMonthValue()));
			// Ècrire Louisiana.csv
			FileWriter w = new FileWriter("Louisiana.csv", true);
			w.write(place + ";" + client + "\n");
			w.close();
		} catch (Exception ex) {
			System.out.println("Erreur IO : " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			System.out.println("Yo mama");
		}
	}

	// FONCTION FLORIDA
	public static void doFlorida(Scanner sc) {
		try {
			System.out.println("Comment vous appelez-vous ?");
			String client = sc.nextLine();
			System.out.println("Quel est votre e-mail ?");
			String mail = sc.nextLine();

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:florida.sqlite");

			Statement st = conn.createStatement();
			st.executeUpdate(
					"CREATE TABLE IF NOT EXISTS demande " + "(id INTEGER PRIMARY KEY, client TEXT, mail TEXT);");

			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(client, mail) VALUES (?,?)");
			st2.setString(1, client);
			st2.setString(2, mail);
			st2.executeUpdate();

			PreparedStatement st3 = conn.prepareStatement("SELECT client FROM demande WHERE mail = ?");
			st3.setString(1, mail);
			ResultSet rs = st3.executeQuery();
			String clients = "";
			while (rs.next())
				clients += rs.getString("client") + ",";
			rs.close();

			conn.close();
			System.out.println("Demande de " + client + "\n" + mail + "\n" + clients + "enregistrÈe.");
		} catch (Exception e) {
			System.out.println(e);
			;
		}
	}

	// FONCTION NEW YORK
	public static void doNewYork(Scanner sc) {
		new NewYorkFrame();
	}

}
