import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaoPauloGetter {

	public static void main(String[] args) {
		String addr = "https://fr.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles=São_Paulo";
		try {
			// Objet tour de contrôle (= navigateur) qui va pouvoir cibler qqs
			// chose.
			Client c = ClientBuilder.newClient(new ClientConfig());
			// Création d'une cible (en iniduant une adresse)
			WebTarget t = c.target(addr);
			// préparation d'une requête (associée à un client, une adresse et
			// un type de retour). On utilise ici la classe Builder située dans
			// le classe Invocation.
			Invocation.Builder ib = t.request(MediaType.APPLICATION_JSON);
			// On envoie la méthode get sur cette requête
			Response r = ib.get();
			// Comment on reçoit le corps (on aurait aussi pu recevoir un objet
			// avec des attributs à l'intérieur).
			System.out.println(r.readEntity(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
