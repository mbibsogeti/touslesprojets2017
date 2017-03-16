package fr.ib.khady.travel;

import java.sql.Statement;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Scanner;

import javax.swing.JFrame;

public class Amerique {
	String name;

	static void doWashington() {
		System.out.println("Pas de voyage pour cette destination !");

	}

	static void doNevada() {

		Destination d1 = new Destination();
		// d1.name = "Monument" ; // Ceci fonctionne si les attributs de la
		// classe Destination ne sont pas en private
		// d1.state = "Nevada";
		// d1.days = 5;
		// d1.extend(8);
		System.out.println(d1.toString());

	}

	static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();
		d1.setName("Padre Island");
		d1.setBoat("Foursea");
		System.out.println(d1.toString());
	}

	static void doLouisiane() {
		String lieu, nom;
		System.out.println("Quel est le lieu ?");
		Scanner clavier = new Scanner(System.in);
		lieu = clavier.nextLine();
		System.out.println("Quel est votre nom ? ");
		nom = clavier.nextLine();
		lieu = lieu.trim(); // Pour supprimer les espaces
		try {
			lieu = lieu.substring(0, 1).toUpperCase() + lieu.substring(1);
			nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
			System.out.println(nom + ", votre demande pour " + lieu + " est enregistrée");
			LocalDateTime t = LocalDateTime.now().plusWeeks(7).plusDays(5);
			System.out
					.println("Départ pas avant le " + String.format("%02d %02d", t.getDayOfMonth(), t.getMonthValue()));
			FileWriter f1 = new FileWriter("louisiane.csv", true);// Crée un
																	// fichier
																	// csv au
																	// même
																	// endroit
																	// que la
																	// classe
																	// Amerique
			f1.write(lieu + " , " + nom + "\n");
			f1.close();
		} catch (IOException ex) {
			System.out.println("Error IO ! " + ex.getMessage());
		} catch (Exception ex) {
			System.out.println("Error ! " + ex.getMessage());
			ex.printStackTrace();// Affiche le flux des piles
		} finally {
			System.out.println("Fin de Louisiane");
		}
	}

	static void doFloride() {
		try {
			System.out.println("nom ?");
			Scanner clavier = new Scanner(System.in);
			String nom = clavier.nextLine();
			System.out.println("email ?");
			String email = clavier.nextLine();

			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:floride.sqlite");

			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS demande(id INTEGER PRIMARY KEY, nom TEXT, email TEXT);");

			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(nom, email)VALUES(?,?)");
			st2.setString(1, nom);
			st2.setString(2, email);
			st2.executeUpdate();
			
			PreparedStatement st3 = conn.prepareStatement("SELECT nom FROM demande WHERE email = ?;");			
			st3.setString(1, email);
			ResultSet rs = st3.executeQuery();
			String names ="";
			while(rs.next())
				names += rs.getString("nom")+", ";
			rs.close();
			
			
        	conn.close();

			System.out.println("demande de " + nom + " enregistrée");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
		static void doNewYork(){
			new NewYorkFrame();
		}
	}


