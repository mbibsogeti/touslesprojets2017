package fr.belto.travel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaopauloGetter { // biblioteque client!

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String addr="https://fr.wikipedia.org/w/api.php?action=query&format=json&"+
		"prop=extracts&titles=São_Paulo";
	try{
		Client c=ClientBuilder.newClient(new ClientConfig());
		WebTarget t=c.target(addr);//on lui indique une adresse
		Invocation.Builder ib=t.request(MediaType.APPLICATION_JSON);// on lui indique une requete(un retour de requete)
		Response r=ib.get();// on va le chercher dans r (en envoyant la methode get)
		System.out.println(r.readEntity(String.class));//afficher le resultat, String.class(methode qu'on aurait pu préparer) lui dire qu'on reçoit une chaine de caractère 
		
	}catch(Exception ex){ex.printStackTrace();
	
	}
	}
}
