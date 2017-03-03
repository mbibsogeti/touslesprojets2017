package fr.ib.travel;

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
		System.out.println("Numéro de croisiere ?");
		Scanner sc= new Scanner(System.in);
		int n=sc.nextInt();
		String addr ="http://localhost:8080/travel-rest-myriam/cruise/"+n;
		try {
			URL url=new URL(addr);
			HttpURLConnection conn = (HttpURLConnection)url.openConnection(); //on ouvre la connection et on accède au fichier, HttpURLConnection est le meilleur pour les requetes GET/POST
			
			if (conn.getResponseCode()/100==2){
				InputStream is=conn.getInputStream(); // on ouvre le flux d'information = lecture du fichier en entier en binaire, octet par octet
				BufferedReader br=new BufferedReader(new InputStreamReader(is, "UTF-8")); // traduction du flux entier en fichier "UTF-8" caractère par caractère
				
				//System.out.println(br.readLine()); // lecture de la première ligne de la traduction UTF-8 du fichier. On peut aussi lire le fichier charactère par caractère (ou octet par octet en lisant le flux is)
				
				String csv = br.readLine();
				System.out.println(csv);
				ObjectMapper om=new ObjectMapper();
				ObjectNode node=om.getNodeFactory().objectNode();
				String[] data=csv.split(",");
				node.put("dest", data[0]);
				node.put("days", Integer.parseInt(data[1]));
				System.out.println(node.toString());
				
				is.close();
			}
			else {
				System.out.println(conn.getResponseCode());
			}
			
		} catch (Exception ex) {System.out.println(ex.toString());}

	}

}
