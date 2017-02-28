package fr.ib.travel.rest;

import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster{

	public static void main(String[] args) {
		
		System.out.println("new cruisen n°?");//affiche un mesa
		Scanner sc= new Scanner(System.in);//scanne ce quon tape
		String crois=sc.nextLine();  //récupération d'une chaine avec les espace
		
	
		String addr="http://localhost:8080/travel-rest-nicolas/cruise/";
		try{        // le try catch permet de faire ce qu'il y a dans le try et si erreur va a catch donc renvoi les exemption
			
			
			CloseableHttpClient cl= HttpClients.createDefault(); //créé un client, 
			HttpPost p= new HttpPost(addr);
			p.setEntity(new StringEntity(crois));
			CloseableHttpResponse r=cl.execute(p);
			System.out.println(r.getStatusLine().getStatusCode());//affiche le code 
			r.close();
			cl.close();
						
				
		}catch(Exception ex){ex.printStackTrace();} //affiche l'exeption 
		
		}

}
