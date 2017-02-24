package fr.ib.travel.rest.client;

import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {
	public static void main(String[] args) {
		System.out.println("New Cruise ?");
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();
		String addr = "http://localhost:8080/travel-rest-amine/cruise";
		try {
			// prépare l'objet client sur le quel vont être faite les requêtes
			CloseableHttpClient client = HttpClients.createDefault();
			// préparation de la requête et son exécution
			HttpPost p = new HttpPost(addr);
			// mettre le corps
			p.setEntity(new StringEntity(c));
			// exécuter la requête avec le client
			CloseableHttpResponse r = client.execute(p);
			//première ligne de la réponse 200 pour avoir un ok donnée rajoutée
			System.out.println(r.getStatusLine().getStatusCode());
			r.close();
			client.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
