package fr.ib.travel;

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
		System.out.println("Numéro de croisiere ?");
		Scanner sc= new Scanner(System.in);
		String c=sc.next();
		String addr ="http://localhost:8080/travel-rest-myriam/cruise";
		try {
			CloseableHttpClient cl=HttpClients.createDefault();
			HttpPost p=new HttpPost(addr);
			p.setEntity(new StringEntity(c));
			CloseableHttpResponse r = cl.execute(p);
			System.out.println(r.getStatusLine().getStatusCode());
			
		} catch (Exception ex){ ex.printStackTrace();}

	}

}
