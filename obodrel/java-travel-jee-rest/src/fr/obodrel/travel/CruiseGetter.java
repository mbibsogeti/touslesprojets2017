package fr.obodrel.travel;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class CruiseGetter {
	public static final String DEBUG_URL = "http://localhost:8080/jee-rest-travel-obodrel/";
	public static final String RELEASE_URL = "http://10.0.0.97:8080/jee-rest-travel-obodrel/";
	public static final String CURRENT_MODE = "DEBUG";

	public static void main(String[] args) {
		int cruiseNumber = -1;
		String urlBeginning = "";
		String cruiseURL, requestURL;
		Scanner cin = null;
		ObjectMapper mapperJSON = new ObjectMapper();
		ArrayNode getResult = new ArrayNode(mapperJSON.getNodeFactory());

		if (CURRENT_MODE.equals("RELEASE")) {
			urlBeginning = RELEASE_URL;
		} else {
			urlBeginning = DEBUG_URL;
		}

		cruiseURL = urlBeginning + "cruiseCSV";

		cin = new Scanner(System.in);

		System.out.println("Cruise number ?");
		try {
			cruiseNumber = cin.nextInt();
			requestURL = cruiseURL + "/" + cruiseNumber;
		} catch (Exception ex) {
			System.out.println(ex.toString());
			requestURL = cruiseURL;
		}
		System.out.println(requestURL);

		try {
			CloseableHttpClient getClient = null;
			CloseableHttpResponse getResponse = null;
			HttpGet getRequest = null;
			
			getClient = HttpClients.createDefault();
			
			getRequest = new HttpGet(requestURL);
			
			getResponse = getClient.execute(getRequest);
			
			InputStream getInputStream = getResponse.getEntity().getContent();
			BufferedReader getBufferedReader = new BufferedReader(new InputStreamReader(getInputStream, "UTF-8"));
			String lineRead;
			while ((lineRead = getBufferedReader.readLine()) != null) {
				System.out.println(lineRead);
				ObjectNode nodeJSON = mapperJSON.getNodeFactory().objectNode();
				String [] data = lineRead.split(";");
				nodeJSON.put("destination", data[0]);
				nodeJSON.put("days", Integer.parseInt(data[1]));
				System.out.println("Node : "+nodeJSON.toString());
				getResult.add(nodeJSON);
			}
			getInputStream.close();
			
			getClient.close();
			getResponse.close();
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
			ex.printStackTrace();
		}
		System.out.println(getResult);
		cin.close();
	}

}
