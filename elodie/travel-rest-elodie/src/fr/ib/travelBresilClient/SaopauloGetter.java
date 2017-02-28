package fr.ib.travelBresilClient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaopauloGetter {

	public static void main(String[] args) {
		String adresse = "https://fr.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles=São_Paulo";
		
		//Communication avec l'adresse
		try{
			Client c = ClientBuilder.newClient(new ClientConfig());
			WebTarget t = c.target(adresse); //Cible l'adresse
			Invocation.Builder ib = t.request(MediaType.APPLICATION_JSON);//Indication de ce qu'on accepte de recevoir
			Response res = ib.get();//Cet appel est demandé en mode get
			System.out.println(res.readEntity(String.class)); //Afichage de la réponse
		
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
