package fr.ib.travel.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;





public class SaopauloGetter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
String addr= "https://fr.wikipedia.org/w/"+"api.php?action=query&format=json&"+"prop=extracts&titles=São_paulo";
	try{
		Client c = ClientBuilder.newClient(new ClientConfig());  //prepare objet client (avec apache) avec possivble config
		WebTarget t=c.target(addr);  // adress attaché au client 
		Invocation.Builder ib=t.request(MediaType.APPLICATION_JSON);//prépare un requete sur une cible l objet de type invocation .builder  classe dansu ne classe 
		Response r=ib.get();//on nevoi la methode get qui nou renvoi la reponse R 
		System.out.println(r.readEntity(String.class)); //pon l'affiche 
		
	}catch(Exception ex){ex.printStackTrace();}
	
	}

}
		