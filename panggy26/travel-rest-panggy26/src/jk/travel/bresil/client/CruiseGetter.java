package jk.travel.bresil.client;

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
		System.out.println("Quel numéro de croisière désirez-vous ?");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		// String + int => String
		String addr = "http://localhost:8080/travel-rest-panggy26/cruise/" + n;
		try {
			// Création d'une URL suivant le String
			URL url = new URL(addr);
			// openConnection() : returns a URLConnection instance that represents a connection to the remote object referred to by the URL
			// Conversion URLConnection => HttpURLConnection
			HttpURLConnection connect = (HttpURLConnection) url.openConnection();
			// Avant de lire, on vérifie qu'on a reçu un code compris entre 200 et 299 avec / : division entière
			if (connect.getResponseCode() / 100 == 2) {
				// Returns an input stream that reads from this open connection
				InputStream inpStream = connect.getInputStream();
				// Transformation en String
				InputStreamReader inpStreamReader = new InputStreamReader(inpStream, "UTF-8");
				// Transformation en ligne
				BufferedReader buffReader = new BufferedReader(inpStreamReader);
				// Un flux est comparable à un tuyau : si on veut lire seulement le 2e, il faut lire le 1er, le jeter, puis lire le 2e
				String csv = buffReader.readLine();
				System.out.println(csv);
				ObjectMapper mapper = new ObjectMapper();
				ObjectNode node = mapper.getNodeFactory().objectNode();
				String[] data = csv.split(",");
				// Ajout de la clef
				node.put("dest", data[0]);
				// Ajout de la valeur
				node.put("days", Integer.parseInt(data[1]));
				// Conversion en JSON et affichage du résultat
				System.out.println(node.toString());
				// Fermeture de l'InputStream
				inpStream.close();
			} else {
				// "http://localhost:8080/travel-rest-panggy26/cruise/truc" : erreur 500
				// "http://localhost:8080/travelrestpanggy26/cruise/" : erreur 404
				System.out.println(connect.getResponseCode());
			}
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		scan.close();
	}
}