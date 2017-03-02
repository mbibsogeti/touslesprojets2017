package fr.ib.hugo.travel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CruiseGetter {

	private static Scanner sc;

	public static void main(String[] args) {

		System.out.println("Cruise n°?");
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		String addr = "http://localhost:8080/hugo-travel-rest/cruise/" + n;
		try {
			URL url = new URL(addr);
			// HttpURLConnection permet de créer une connection http à l'adresse
			// URL indiquée
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn.getResponseCode() / 100 == 2) {
				// InputStream renvoie le flux quelque soit le type
				InputStream is = conn.getInputStream();
				// InputStreamReader fait la conversion de binaire venant de
				// InputStream en chaîne de caractères UTF-8
				// BufferedReader crée un objet qui lit en temps réel le flux de
				// données transformé en chaîne de caractèress
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				// readlin() méthode sur l'objet br qui permet de lire ce que
				// cette
				// objet contient
				String csv = br.readLine();
				System.out.println(csv);
				ObjectMapper m = new ObjectMapper();
				ObjectNode nde = m.getNodeFactory().objectNode();
				String[] data = csv.split(",");
				nde.put("dest", data[0]);
				nde.put("days", Integer.parseInt(data[1]));
				// la méthode toString appliquée a un objet de type ObjectNode
				// transforme les données en JSON
				System.out.println(nde.toString());
				is.close();
			} else {
				System.out.println("Error");
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

	}

}
