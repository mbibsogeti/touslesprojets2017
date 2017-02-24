package fr.belto.travel;

import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class CruisePoster {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("New cruise ?");// questionner le client rentrer nouvel destination
		Scanner sc = new Scanner(System.in);// exemple Rio, 18
		String c=sc.nextLine();
		String addr="http://localhost:8080/travel-rest-Belto/cruise/";
		sc.close();
		try{
			CloseableHttpClient cl=HttpClients.createDefault();// on crée un objet client qui s'occupe de tout
			HttpPost p= new HttpPost(addr);// on recupère l'adresse mail et on fait appel a la fonction Post qu'on a crée
			p.setEntity(new StringEntity(c));// on associe c (nouveaux données) à l'adresse mail corrigé p
			CloseableHttpResponse r=cl.execute(p);// j'execute la requete, donc j'ajoute les données
			System.out.println(r.getStatusLine().getStatusCode());
		}catch (Exception ex){ex.printStackTrace();} 
	}

}
