package fr.ib.hugo.travel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaoPauloGetter {

	public static void main(String[] args) {

		String addr="https://fr.wikipedia.org/w/"+"api.php?action=query&format=json&"+"prop=extracts&titles=São_Paulo";
		
		try{
			Client client=ClientBuilder.newClient(new ClientConfig());
			//adresse URL ciblée
			WebTarget wt=client.target(addr);
			Invocation.Builder ib=wt.request(MediaType.APPLICATION_JSON);
			Response resp=ib.get();
			System.out.println(resp.readEntity(String.class));
		}

		catch(Exception ex){
			ex.printStackTrace();
		}
	}

}