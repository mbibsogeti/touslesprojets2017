package fr.obodrel.travel;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

public class SaoPauloGetter {

	public static void main(String[] args) {
		String requestURL;

		
		requestURL = "https://fr.wikipedia.org/w/api.php?action=query&format="
				+ "json&prop=extracts&titles=São_Paulo";

		try {
			Client jerseyClientGET = ClientBuilder.newClient();
			WebTarget jerseyWebTargetGET = jerseyClientGET.target(requestURL);
			Invocation.Builder jerseyInvocationBuilderGET = jerseyWebTargetGET.request(MediaType.APPLICATION_JSON);	
			Response jerseyResponsGET = jerseyInvocationBuilderGET.get();
			System.out.println(jerseyResponsGET.readEntity(String.class));
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
	}
}
