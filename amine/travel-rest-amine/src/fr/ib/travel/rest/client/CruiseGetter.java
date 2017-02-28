package fr.ib.travel.rest.client;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CruiseGetter {
	public static void main(String[] args) {

		// demander à l'utilisateur quelle croisière, il veut lire
		System.out.println("Cruise n°?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String addr = "http://localhost:8080/travel-rest-amine/cruise/" + n;
		try {
			// ouvre une connection réseau en http
			URL url = new URL(addr);
			// il s'occupe du côté http sorte de tour de contrôle http
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// déclancher une 404 en modifiant l'URL en haut
			if (conn.getResponseCode() / 100 == 2) {
				// ouvrir notre flux en entrée
				InputStream is = conn.getInputStream();// entrée en flux binaire
				// un objet qui se base sur ce flux binaire pour faire la
				// conversion textuelle
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				// System.out.println(br.readLine());
				String csv = br.readLine();
				System.out.println(csv);
				// création d'objet tour de contrôle de Jackson
				ObjectMapper m = new ObjectMapper();
				ObjectNode node = m.getNodeFactory().objectNode();
				// la virgule pour séparer les données entre elles
				String[] data = csv.split(",");
				// définition de la clé et de la valeur
				node.put("dest", data[0]);
				// pour la conversion en entier du nombre de jours de la
				// croisière
				node.put("days", Integer.parseInt(data[1]));
				System.out.println(node.toString());
				is.close();// ferme la connection à la fin
			} else
				System.out.println(conn.getResponseCode());

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

}
