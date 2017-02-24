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
		String addr = "bit.ly/2mfy66U";
		try {
			Client client = ClientBuilder.newClient(new ClientConfig());
			// Ciblage de l'adresse
			WebTarget cible = client.target(addr);
			Invocation.Builder invoBuilder = cible.request(MediaType.APPLICATION_JSON);
			// On appelle la requête en mode get
			Response reponse = invoBuilder.get();
			System.out.println(reponse.readEntity(String.class));
		} catch(Exception exc) {
			exc.printStackTrace();
		} // end catch
		
	} // end main method

} // end SaoPauloGetter class
