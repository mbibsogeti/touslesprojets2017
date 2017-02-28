import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	public static void main(String[] args) {
		System.out.println("Donner nouvelle croisière, nombre de jours");
		Scanner sc = new Scanner(System.in);
		// Le user va rentrer un string c pour la 'cruise' (ex: Rio, 18)), on ne
		// passera pas
		// par url et getConnection
		String cruise = sc.nextLine(); // si on sc.next, s'arrête à l'espace de
										// l'entrée. sc.nextLine prend toute
										// l'entrée jusqu'au retour à la ligne
		String addr = "http://localhost:8080/travel-rest-marcantoine/cruise/";
		sc.close();
		try {
			// créatio d'un équivalent de navigateur (ici, CloseableHttpClient)
			CloseableHttpClient client = HttpClients.createDefault();
			// création du post (donne l'en-tête = addr)
			HttpPost p = new HttpPost(addr);
			// remplissage du post (donne corps = entity ici, on y met cruise)
			p.setEntity(new StringEntity(cruise));
			// envoyer le post sur le client avec une réponse
			CloseableHttpResponse res = client.execute(p);
			// regarder le 'status code' de la réponse et l'imprimer pour test
			System.out.println(res.getStatusLine().getStatusCode());
			res.close();
			client.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
