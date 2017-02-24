package fr.belto.travel;

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
		// TODO Auto-generated method stub
System.out.println("Cruises No ?");// questionner le client
Scanner sc = new Scanner(System.in);
int n=sc.nextInt();// stockage du scanner dans un entier
   sc.close();// fermeture du scanner
String addr="http://localhost:8080/travel-rest-Belto/cruise/"+n;// on stock notre adresse ligne

try{
	URL url=new URL(addr);//comment de connecter au serveur
	HttpURLConnection conn=(HttpURLConnection)url.openConnection();//on se connect au bon endroit!
	if (conn.getResponseCode()==200){
	InputStream is= conn.getInputStream();// On reçoit les données en binaire
	BufferedReader br=new BufferedReader(new InputStreamReader(is,"UTF-8"));// on transforme le bianire en caractère
	// fermeture de InputStream
	String csv=br.readLine();//Lire la ligne
	System.out.println(csv); // convertisons le fichier reçu du serveur en Jason
	ObjectMapper m= new ObjectMapper();// on recupère les données en vrac 
	ObjectNode on=m.getNodeFactory().objectNode();// on le stock dans un objet
	String[]data=csv.split(",");//on le separe au niveau des virgules
	on.put("dest", data[0]);// la première valeur correspond à la destination
	on.put("days",Integer.parseInt(data[1]));// la deuxieme, le nombre de jour
	System.out.println(on.toString());// on l'affiche finalement en Jason wééééééé ouhouu!!
	is.close();// fermeture du Stream- il faut toujours le fermer!
	}// on affiche le resultat
	else 
		System.out.println(conn.getResponseCode());
}catch(Exception ex){System.out.println(ex.toString());
}
}
}
