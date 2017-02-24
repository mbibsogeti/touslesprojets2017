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
		// on demande au client ce qu'il veut :
		System.out.println("Cruise n°?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		// on donne l'adresse en dur mais on pourrait rentrer un paramètre :
		// cette adresse permettra d'envoyer une rqeuête :
		String addr = "http://localhost:8080/travel-rest-marcantoine/cruise/" + n;
		// On prévoit les exceptions sur notre code et on imprime le résultat
		try {
			// On crée une URL :
			URL url = new URL(addr);
			// ON crée une connexion :
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// On crée un flux d'entrée binaire (pour avoir un flux texte mais
			// aussi image)
			// InputStream permet de prendre une chaîne de binaire
			// On vérifie que tout va bien en lisant le code de la réponse à la
			// requête : (pour tester une erreur 404, il suffit de modifier
			// addr)
			if (conn.getResponseCode() / 100 == 2) {
				InputStream is = conn.getInputStream();
				// inputstreamreader fait la conversion du binaire en flux
				// texte. on
				// choisit l'encodage
				// le buffered reader ressemble bcp au scanner : sert à lire
				// ligne par ligne ce flux texte
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// Lecture de la ligne
				// System.out.println(br.readLine());

				// Affectation de la valeur lue de la réponse dans csv :
				String csv = br.readLine();
				// lecture de la valeur :
				System.out.println(csv);

				// Faire de l'encodage en JSON : les lignes qui suivent :
				ObjectMapper m = new ObjectMapper();
				ObjectNode node = m.getNodeFactory().objectNode();
				// définition d'un tableau data. split crée une liste/table en
				// coupant un string (ici à chaque virgule)
				String[] data = csv.split(",");
				// le trim enlèvera les espaces s'il y en a. Attention : on a
				// que des chaînes de caractères, il faut convertir le nbr de
				// jours.
				node.put("dest", data[0].trim());
				node.put("days", Integer.parseInt(data[1].trim()));
				// maintenant qu'on a mis toutes les données dans un objet, on
				// utilise toString du node pour faire du JSON (méthode spéciale de l'objet node).
				System.out.println(node.toString());
				is.close();
			} else {
				// Affichage du code d'erreur
				System.out.println(conn.getResponseCode());
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
			// affiche tous les détails liés à l'exception
			ex.printStackTrace();
		}

		sc.close();
	}

}
