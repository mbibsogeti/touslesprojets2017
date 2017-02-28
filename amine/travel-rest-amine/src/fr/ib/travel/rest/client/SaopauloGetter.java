package fr.ib.travel.rest.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaopauloGetter {

	public static void main(String[] args) {
		String addr = "https://fr.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&titles=São_Paulo";
		try {
			//préparer l'objet principale client avec sa configutation
			Client c = ClientBuilder.newClient(new ClientConfig());
			//l'adresse URL
			WebTarget t = c.target(addr);
			//préparer une requête
			//class.class(classe dans une classe) builder dans invocation
			Invocation.Builder ib=t.request(MediaType.APPLICATION_JSON);
			Response r=ib.get();
			System.out.println(r.readEntity(String.class));
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
