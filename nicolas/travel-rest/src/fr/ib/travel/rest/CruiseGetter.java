package fr.ib.travel.rest;

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
		
		System.out.println("cruisen n°?");//affiche un mesa
		Scanner sc= new Scanner(System.in);//scanne ce quon tape
		int n=sc.nextInt();
	
		String addr="http://localhost:8080/travel-rest-nicolas/cruise/"+n;
		try{        // le try catch permet de faire ce qu'il y a dans le try et si erreur va a catch donc renvoi les exemption
			URL url=new URL(addr);  //contient l'adresse en chaine
			HttpURLConnection conn= (HttpURLConnection)url.openConnection();	// appel flux binaire		issu de la fonction de HttpURLConnection
			if(conn.getResponseCode()==200){  //test le retour d'un bon code 200ok pas 404.....
			InputStream is = conn.getInputStream();     //recupère le flux binaire 
			BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8")); //défini un nouveau buffer reader qui li une seul ligne  puis converti le flu récupéré  en texte  
		
				//System.out.println(br.readLine());//affiche le flu converti en texte en java  ( mais qu'une seul ligne 
			String csv=br.readLine();
			System.out.println(csv);
			ObjectMapper m= new ObjectMapper();
			ObjectNode nod= m.getNodeFactory().objectNode();
			String[]data=csv.split(",");
			nod.put("dest",data[0]);
			nod.put("day",Integer.parseInt(data[1]));
			System.out.println(nod.toString());
			
			is.close();	
			}else {System.out.println(conn.getResponseCode());}
						
				//ferme le flu d'entrée
		}catch(Exception ex){System.out.println(ex.toString());} //affiche l'exeption 
		
		}

}
