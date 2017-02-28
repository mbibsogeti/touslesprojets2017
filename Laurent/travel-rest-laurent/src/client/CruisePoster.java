package client;

import java.util.Scanner;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class CruisePoster {

	public static void main(String[] args) {
		System.out.println("New Cruise ?");
		Scanner sc = new Scanner(System.in);
		//String cruise=sc.nextLine();
		String cruise="6";
		String addr="http://localhost:8080/travel-rest-laurent/cruise";
		try{
			CloseableHttpClient cl= HttpClients.createDefault();
			HttpPost post = new HttpPost(addr);
			post.setEntity(new StringEntity(cruise));
			
			CloseableHttpResponse res=cl.execute(post);
			res.close();
			cl.close();
					
		}catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
