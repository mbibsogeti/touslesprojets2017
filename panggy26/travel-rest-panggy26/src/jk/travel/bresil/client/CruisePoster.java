package jk.travel.bresil.client;

import java.util.Scanner;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	public static void main(String[] args) {
		System.out.println("Tapez la croisière que vous souhaitez ajouter :");
		Scanner scan = new Scanner(System.in);
		String croisiere = scan.nextLine();
		String addr = "http://localhost:8080/travel-rest-panggy26/cruise";
		try {
			// Objet central, que l'on pourra utiliser plusieurs fois
			CloseableHttpClient client = HttpClients.createDefault();
			// Objet représentant la requête post
			// On va poster post dans l'adresse addr
			HttpPost post = new HttpPost(addr);
			post.setEntity(new StringEntity(croisiere));
			// Envoie cette requête en utilisant ce client "client"
			CloseableHttpResponse reponse = client.execute(post);
			// StatusLine() : première ligne de la réponse, elle comporte le status code
			System.out.println(reponse.getStatusLine().getStatusCode());
			reponse.close();
			client.close();	
			} catch (Exception exc) {
			exc.printStackTrace();
		} // end try-catch
		scan.close();
	} // end main method
} // end CruisePoster class