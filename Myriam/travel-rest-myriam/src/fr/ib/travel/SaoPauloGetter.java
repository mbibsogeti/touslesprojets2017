package fr.ib.travel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaoPauloGetter {

	public static void main(String[] args) {
		String add="https://fr.wikipedia.org/w/"+"api.php?action=query&format=json&"+"prop=extracts&titles=São_Paulo";
		try {
			Client c=ClientBuilder.newClient(new ClientConfig());// on prépare l'objet principal : le client
			WebTarget t=c.target(add); // prépare  la requete
			Invocation.Builder ib=t.request(MediaType.APPLICATION_JSON); // type de la réponse : JSON
			
			Response r=ib.get(); // Initialisation du flux, lecture du header, préparation à la lecture.
			System.out.println(r.readEntity(String.class)); // lecture et affichage au format "String.class" (= type objet)
			
		} catch (Exception ex) { ex.printStackTrace();}
		
	}

}
