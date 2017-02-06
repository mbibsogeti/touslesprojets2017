package cap.jklein.travel;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import javax.swing.JFrame;

public class Usa {

	// MÉTHODES //
	public static void doWashington() {
		System.out.println("Pas de voyage pour l'état de Washington !");
	}

	public static void doNevada() {
		Destination dest = new Destination(); // Instanciation
		dest.extend(3);
		System.out.println(dest.toString());

		Destination desti = new Destination("Carson City", "Nevada", 10);
		System.out.println(desti.toString());
	}

	public static void doTexas() {
		CoastalDestination costDest = new CoastalDestination("Padre Island", "Texas", 3, "la Licorne");
		System.out.println(costDest.toString());
	}

	// throws : cette méthode est susceptible de provoquer des IOException.
	// Cette syntaxe permet de les laisser remonter. Il faut alors que l'on ait un bloc try catch plus haut pour traiter ce cas.
	public static void doLouisiane(Scanner sc) throws IOException {
		System.out.println("Où souhaitez-vous voyager en Louisiane ?");
		// Demande à l'utilisateur de rentrer un lieu
		String place = sc.nextLine();
		// String.trim() supprime les espaces au début et à la fin
		place = place.trim();
		// Si l'utilisateur rentre un lieu vide, on aboutit à une
		// StringIndexOutOfBounds
		try {
			// String.subtring(int beginIndex, int endIndex) renvoie un
			// sous-String de ce String
			// Ici, on met donc la première lettre en majuscule et les autres en
			// minuscules
			place = place.substring(0, 1).toUpperCase() + place.substring(1);

			System.out.println("Quel est votre nom ?");
			// nextLine() permet de rentrer des noms avec espaces
			String name = sc.nextLine();

			System.out.println("Demande pour un voyage à " + place + " enregistrée pour " + name);

			// Il faut 7 semaines et 5 jours de préparation pour ce voyage
			LocalDateTime time = LocalDateTime.now();
			time = time.plusWeeks(7).plusDays(5);

			// Solution 1 : avec un DateTimeFormatter
			DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM");
			System.out.println("Départ au mieux le " + time.format(timeFormat));
			// Si on ne met rien dans le catch, l'erreur est capturée mais rien
			// n'apparaît

			// Solution 2 : avec un String.format
			// System.out.println("Départ au mieux le " +
			// String.format("%02d/%02d",
			// time.getDayOfMonth(), time.getMonthValue()));

			// ajout = true, sinon false : écrasement du fichier
			FileWriter fich = new FileWriter("Louisiane.csv", true);
			fich.write(place + "," + name + "\n");
			fich.close();
		} catch (IOException e) {
			System.out.println("Erreur IO : " + e.getMessage());
		} catch (Exception e) {
			// Message de la 1ère ligne
			System.out.println("Erreur : " + e.getMessage());
			// Imprime la pile
			e.printStackTrace();
		} finally {
			System.out.println("Fin de Louisiane");
		}
	}

	public static void doFloride(Scanner sc) {
		try {
			System.out.println("Vous avez demandé un voyage en Floride. Quel est votre nom ?");
			String name = sc.nextLine();
			System.out.println("Vous avez demandé un voyage en Floride. Quel est votre e-mail ?");
			String email = sc.nextLine();

			// Signale au pilote que l'on va utiliser la classe JDBC dans le DriverManager
			Class.forName("org.sqlite.JDBC");
			// .getConnection : où est le serveur, type de connexion etc.
			// Ici, on se connecte au fichier florida.sqlite
			Connection conn = DriverManager.getConnection("jdbc:sqlite:florida.sqlite");

			// Création de la table demande
			Statement st = conn.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS demande(id INTEGER PRIMARY KEY, name TEXT, email TEXT);");

			// Insertion des valeurs

			// // Façon pas très commode, voire l'autre
			// Statement st2 = conn.createStatement();
			// st2.executeUpdate("INSERT INTO demande(name, email) VALUES (\"" + name + "\",\"" + email + "\")");

			// Utilisation d'un PreparedStatement
			PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(name, email) VALUES (?, ?)");
			// On remplace les ? (attention Java commence exceptionnellement à compter à 1)
			st2.setString(1, name);
			st2.setString(2, email);
			st2.executeUpdate();

			// Requête
			PreparedStatement st3 = conn.prepareStatement("SELECT name FROM demande WHERE email = ?");
			st3.setString(1, email);
			// Pour pouvoir accéder au résultat, on utilise un objet ResultSet qui sert à le lire
			ResultSet rs = st3.executeQuery();

			// On parcourt le ResultSet, et on affiche les noms correspondants à cette requête
			String names = "";
			while (rs.next())
				names += rs.getString("name") + ", ";
			rs.close();

			// Fermeture de la connexion
			conn.close();

			System.out.println("Demande de " + name + " enregistrée - " + names);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void doNewYork() {
		// Création d'une fenêtre frame de type NewYorkFrame
		NewYorkFrame frame = new NewYorkFrame();	
	}
}