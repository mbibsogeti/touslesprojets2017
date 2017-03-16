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
	
		try{
			Client c = ClientBuilder.newClient(new ClientConfig());// on crée l'objet client et sa configuration
			WebTarget t = c.target(addr);// on cible notre ressource: ici c'est "addr". c'est le client qui crée l'url d'où c.target
			Invocation.Builder ib = t.request(MediaType.APPLICATION_JSON);// class Builder est dans la class Invocation
			Response r = ib.get();// on envoie la méthode get
			System.out.println(r.readEntity(String.class));//"String.class" pour dire sous quelle forme on veut recevoir le corps, ici sous la forme d'une chaîne
			
		}catch(Exception ex){ex.printStackTrace();}
		
		
		
		
		
		
		
		
		

	}

}
