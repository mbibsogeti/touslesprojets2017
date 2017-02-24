package fr.ib.travelBresilClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CruiseGetter {

	public static void main(String[] args) {
		System.out.println("Cruise n°?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String adresse = "http://localhost:8080/travel-rest-elodie/cruise/"+n;
		
		try{
		URL url = new URL(adresse);
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		
			if(conn.getResponseCode()/100==2)
				{
				InputStream is = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8")); 
				//System.out.println(br.readLine());
				
				String csv = br.readLine();
				System.out.println(csv);
				
				ObjectMapper m = new ObjectMapper();
				ObjectNode no = m.getNodeFactory().objectNode();
				String[] data = csv.split(",");
				no.put("dest", data[0].trim());
				no.put("days", Integer.parseInt(data[1].trim()));
				
				System.out.println(no.toString());
				is.close();
				}
				
			else
				System.out.println(conn.getResponseCode());
		
			
		}catch(Exception e){
			System.out.println(e.toString());
		}

	}

}
