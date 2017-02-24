package fr.obodrel.travel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CruiseGetter {
	public static final String DEBUG_URL = "http://localhost:8080/jee-rest-travel-obodrel/";
	public static final String RELEASE_URL = "http://10.0.0.97:8080/jee-rest-travel-obodrel/";
	public static final String CURRENT_MODE = "DEBUG";

	public static void main(String[] args) {
		int cruiseNumber = -1;
		String urlBeginning = "";
		String cruiseURL, requestURL;
		Scanner cin = null;
		
		if(CURRENT_MODE.equals("RELEASE")) {
			urlBeginning = RELEASE_URL;
		} else {
			urlBeginning = DEBUG_URL;
		}
		
		cruiseURL = urlBeginning+"cruiseCSV";
		
		cin = new Scanner(System.in);
		
		System.out.println("Cruise number ?");		
		try {
			cruiseNumber = cin.nextInt();
			requestURL = cruiseURL+"/"+cruiseNumber;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			requestURL = cruiseURL;
		}
		System.out.println(requestURL);	
		
		try {
			URL urlToRequestOn = new URL(requestURL);
			HttpURLConnection conn = (HttpURLConnection)urlToRequestOn.openConnection();
			if(conn.getResponseCode() == 200) {
				InputStream connInputStream = conn.getInputStream();
				BufferedReader connBufferedReader = new BufferedReader(new InputStreamReader(connInputStream, "UTF-8"));
				String lineRead;
				while((lineRead = connBufferedReader.readLine())!=null) {
					System.out.println(lineRead);
				}
				connInputStream.close();
			} else {
				System.out.println("URL is Wrong"+conn.getResponseCode());
			}
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		
		cin.close();		
	}

}
