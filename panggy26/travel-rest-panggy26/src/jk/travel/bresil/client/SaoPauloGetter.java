package jk.travel.bresil.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;

public class SaoPauloGetter {

	public static void main(String[] args) {
		// Adresse bit.ly : bit.ly/2mfy66U
		String addr = "https://fr.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles=São_Paulo";
		try {
			// Préparation de l'objet Client
			Client client = ClientBuilder.newClient(new ClientConfig());
			// Ciblage de l'adresse URL
			WebTarget cible = client.target(addr);
			// Invocation.Builder : la classe Builder est interne à la classe Invocation
			// APPLICATION_JSON ; type de retour
			Invocation.Builder invoBuilder = cible.request(MediaType.APPLICATION_JSON);
			// On appelle la requête en mode get, ce qui renvoie une réponse
			Response reponse = invoBuilder.get();
			// Lecture de la réponse
			System.out.println(reponse.readEntity(String.class));
		} catch(Exception exc) {
			exc.printStackTrace();
		} // end catch
	} // end main method
} // end SaoPauloGetter class