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
			// Objet tour de contrôle (= navigateur) qui va pouvoir cibler qqs
			// chose.
			Client c = ClientBuilder.newClient(new ClientConfig());
			// Création d'une cible
			WebTarget t = c.target(addr);
			// 
			Invocation.Builder ib = t.request(MediaType.APPLICATION_JSON);
			Response r = ib.get();
			System.out.println(r.readEntity(String.class));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
