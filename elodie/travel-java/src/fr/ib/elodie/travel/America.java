package fr.ib.elodie.travel;

import java.awt.Color;
import java.io.FileOutputStream;
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
import javax.swing.JLabel;
import javax.swing.JPanel;

public class America {
	public static void doWashingtown() {
		System.out.println("Not trip for this state");
	}

	public static void doNevada() {

		Destination d1 = new Destination("Death Valley", "Nevada", 7);
		d1.setName("Monument Valley");
		d1.extend(7);

		System.out.println(d1.toString() + " = " + d1.getWeeks() + " weeks");
	}

	public static void doTexas() {
		CostalDestination cd1 = new CostalDestination("Padre Island", "Texas", 4, "Federal");
		System.out.println(cd1.toString());
	}

	public static void doLouisiane() {
		Scanner sc = new Scanner(System.in);
		String place = "";
		String nameCustomer = "";
		LocalDateTime depart = LocalDateTime.now().plusDays(54);

		try {
			FileWriter f = new FileWriter("enregister.csv", true);

			System.out.println("Give a place");
			place = sc.nextLine();
			System.out.println("Give your name about record of the destination");
			nameCustomer = sc.nextLine();
			place = place.trim();
			place = place.substring(0, 1).toUpperCase() + place.substring(1);

			f.write(place + " " + nameCustomer + "\n");
			f.close();

			System.out.println("Record of the destination for " + place + " have been taken account");
			System.out.println("Date of depart from "
					+ String.format("%02d/%02d", depart.getDayOfMonth(), depart.getMonthValue()));
		} catch (IOException e) {
			System.out.println("Erreur io : " + e.getMessage());

		} catch (Exception e) {
			System.out.println("Place is empty!" + " L'erreur vient de : " + e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("Je suis dans le bloc finally");

		}

	}

	public static void doFloride() {
		Scanner sc = new Scanner(System.in);
		String nameF;
		String email;

		try {
			System.out.println("What is your name?");
			nameF = sc.nextLine();
			System.out.println("What is your email?");
			email = sc.nextLine();

			Class.forName("org.sqlite.JDBC"); // nom de la classe de pilote
			Connection conn = DriverManager.getConnection("jdbc:sqlite:floride.sqlite"); //Fait la connexion et permet les statements
			Statement st = conn.createStatement(); // objet de requête
			st.executeUpdate("CREATE TABLE IF NOT EXISTS demande (id INTEGER PRIMARY KEY, nameF TEXT, email TEXT);");
			
			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(nameF, email)VALUES(?,?)"); //requête préparé
			st2.setString(1, nameF);
			st2.setString(2,email);
			st2.executeUpdate();
			
			PreparedStatement st3 = conn.prepareStatement("SELECT nameF FROM demande WHERE email =?");
			st3.setString(1,email);
			ResultSet rs = st3.executeQuery(); //Sorte de curseur, pointant chaque resusltat
			String names = " ";
			while (rs.next()) // bouble jusqu'à ce qu'il n'est plus rien à lire
				names += rs.getString("nameF") + ", ";
			rs.close();

			conn.close();
			System.out.println(nameF + " want a Floride trip - Enregister" + names);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public static void doNewYork(){
		new NewYorkFrame();
	}

}
