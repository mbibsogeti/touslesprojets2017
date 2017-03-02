package fr.ib.hugo.travel;

import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	private static Scanner sc;

	public static void main(String[] args) {

		System.out.println("New Cruise?");
		sc = new Scanner(System.in);
		String c = sc.next();
		String addr = "http://localhost:8080/hugo-travel-rest/cruise";

		try {
			// on prépare l'objet central du client sur lequel les rêquetes vont
			// être faites
			CloseableHttpClient client = HttpClients.createDefault();
			// objet p va être posté dans l'adresse URL addr
			HttpPost p = new HttpPost(addr);
			// chargement du contenu dans l'objet p
			p.setEntity(new StringEntity(c));
			// excute les méthodes associées à l'objet p dans l'objet client et
			// on les stocke dans un objet de type http réponse sur lequel on
			// pourrait éventuellement venir chercher l'info avec un get par ex.
			CloseableHttpResponse r = client.execute(p);
			r.close();
			client.close();
			System.out.println("cool man");
			// renvoie le code d'état de la reqête (200=ok)
			System.out.println(r.getStatusLine().getStatusCode());
		}

		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
