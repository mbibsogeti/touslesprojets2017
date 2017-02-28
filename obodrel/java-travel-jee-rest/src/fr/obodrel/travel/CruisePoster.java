package fr.obodrel.travel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {
	public static final String DEBUG_URL = "http://localhost:8080/jee-rest-travel-obodrel/";
	public static final String RELEASE_URL = "http://10.0.0.97:8080/jee-rest-travel-obodrel/";
	public static final String CURRENT_MODE = "DEBUG";

	public static void main(String[] args) {
		String postOption = "";
		String urlBeginning = "";
		String cruiseURL;
		Scanner cin = null;

		if (CURRENT_MODE.equals("RELEASE")) {
			urlBeginning = RELEASE_URL;
		} else {
			urlBeginning = DEBUG_URL;
		}

		cruiseURL = urlBeginning + "cruiseCSV";

		cin = new Scanner(System.in);

		System.out.println("Type in your option to make a post request :");

		postOption = cin.next();
	
		System.out.println("Try Post to push in a new city");

		try {
			CloseableHttpClient postClient = null;
			CloseableHttpResponse postResponse = null;
			HttpPost postRequest = null;
			
			postClient = HttpClients.createDefault();
			
			postRequest = new HttpPost(cruiseURL);
			postRequest.setEntity(new StringEntity(postOption));
			
			postResponse = postClient.execute(postRequest);
			System.out.println("Status = "+postResponse.getStatusLine().getStatusCode());
			
			postClient.close();
			postResponse.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		System.out.println("END OF POST");

		System.out.println("Display all cruises");
		try {
			CloseableHttpClient getClient = null;
			CloseableHttpResponse getResponse = null;
			HttpGet getRequest = null;
			
			getClient = HttpClients.createDefault();
			
			getRequest = new HttpGet(cruiseURL);
			
			getResponse = getClient.execute(getRequest);
			
			InputStream getInputStream = getResponse.getEntity().getContent();
			BufferedReader getBufferedReader = new BufferedReader(new InputStreamReader(getInputStream, "UTF-8"));
			String lineRead;
			while ((lineRead = getBufferedReader.readLine()) != null) {
				System.out.println(lineRead);
			}
			getInputStream.close();
			
			getClient.close();
			getResponse.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		System.out.println("END OF 1ST GET");

		System.out.println("Delete last added cruise");
		try {
			CloseableHttpClient deleteClient = null;
			CloseableHttpResponse deleteResponse = null;
			HttpDelete deleteRequest = null;
			
			deleteClient = HttpClients.createDefault();
			
			deleteRequest = new HttpDelete(cruiseURL+"/5");
			
			deleteResponse = deleteClient.execute(deleteRequest);
			
			deleteClient.close();
			deleteResponse.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		System.out.println("END OF DELETE");

		System.out.println("Display all cruises");
		try {
			CloseableHttpClient getClient = null;
			CloseableHttpResponse getResponse = null;
			HttpGet getRequest = null;
			
			getClient = HttpClients.createDefault();
			
			getRequest = new HttpGet(cruiseURL);
			
			getResponse = getClient.execute(getRequest);
			
			InputStream getInputStream = getResponse.getEntity().getContent();
			BufferedReader getBufferedReader = new BufferedReader(new InputStreamReader(getInputStream, "UTF-8"));
			String lineRead;
			while ((lineRead = getBufferedReader.readLine()) != null) {
				System.out.println(lineRead);
			}
			getInputStream.close();
			
			getClient.close();
			getResponse.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		System.out.println("END OF 2ND GET");
		

		cin.close();
	}

}
