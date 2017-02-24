package fr.ib.travel.rest.client;


import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	public static void main(String[] args) {
		System.out.println("New cruise ?");
		Scanner sc = new Scanner(System.in);
		String c = sc.nextLine();

		String addr = "http://localhost:8080/travel-rest-khady/cruise/";
		try {
              CloseableHttpClient cl = HttpClients.createDefault();
              HttpPost p = new HttpPost(addr);
              p.setEntity(new StringEntity(c));
              CloseableHttpResponse r =cl.execute(p);
              
              System.out.println(r.getStatusLine().getStatusCode());
              r.close();
              cl.close();
			
		
		} catch (Exception ex) {ex.printStackTrace();}

	}
}