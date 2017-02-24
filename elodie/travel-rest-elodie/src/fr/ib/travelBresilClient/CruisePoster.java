package fr.ib.travelBresilClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	public static void main(String[] args) {
		System.out.println("New Cruise ?");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String adresse = "http://localhost:8080/travel-rest-elodie/cruise/";
		
		try{
		
			CloseableHttpClient c = HttpClients.createDefault();
			HttpPost p = new HttpPost(adresse);
			p.setEntity(new StringEntity(str));
			
			CloseableHttpResponse res = c.execute(p);
			System.out.println(res.getStatusLine().getStatusCode());
			
			res.close();
			c.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
