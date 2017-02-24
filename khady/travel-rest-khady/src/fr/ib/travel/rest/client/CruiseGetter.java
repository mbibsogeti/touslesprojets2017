package fr.ib.travel.rest.client;

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

		System.out.println("Which cruise to read ?");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String addr = "http://localhost:8080/travel-rest-khady/cruise/" + n;
		try {

			URL url = new URL(addr);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn.getResponseCode() / 100 == 2) {
				InputStream is = conn.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));

				// System.out.println(br.readLine());
				String csv = br.readLine();
				System.out.println(csv);
                ObjectMapper m = new ObjectMapper();
                ObjectNode node = m.getNodeFactory().objectNode();
                String[]data = csv.split(",");//split coupe une chaine en plusieurs séparées
                node.put("destination", data[0]);//put sert à ajouter une valeur à notre tableau
                node.put("days", Integer.parseInt(data[1]));
                System.out.println(node.toString());
                
                
                
				is.close();
			} else {
				System.out.println(conn.getResponseCode());
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
