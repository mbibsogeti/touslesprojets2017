package client;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Frame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField tf1,tf2;
	private JButton bt1,bt2;
	private String Text="";
	private boolean Scan=false;
	
	public Frame() throws HeadlessException {
		this(900,300,true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		//Création d'un bouton
		bt1 = new JButton("Send1");
		this.getContentPane().add(bt1);
		bt1.setBounds((500/2)-20, (300/2)-8, 100, 25);
		bt1.addActionListener(this); //Création d'un détecteur d'action
		
		bt2 = new JButton("Send2");
		this.getContentPane().add(bt2);
		bt2.setBounds((500/2)+150, (300/2)-8, 100, 25);
		bt2.addActionListener(this); //Création d'un détecteur d'action
		
		//Création d'une zone de lecture
		tf2 = new JTextField("");
		this.getContentPane().add(tf2);
		tf2.setBounds(10, 10, 800, 100);
		//tf2.setEnabled(false);
		tf2.setColumns(60);
		
		//Création d'une zone d'écriture
		tf1 = new JTextField("");
		this.getContentPane().add(tf1);
		tf1.setBounds(100, 200, 300, 50);
		
	}

	public JTextField getTf2() {
		return tf2;
	}

	public void setTf2(JTextField tf2) {
		this.tf2 = tf2;
	}

	public JTextField getTf1() {
		return tf1;
	}

	public void setTf1(JTextField tf1) {
		this.tf1 = tf1;
	}

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public Frame(short xTaille, short yTaille) throws HeadlessException {
		super();
		this.setSize(xTaille, yTaille);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public Frame(int xTaille, int yTaille, boolean showFrame) throws HeadlessException {
		super();
		this.setSize(xTaille, yTaille);
		this.setVisible(showFrame);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	public void Write(String txt){
		tf2.setText(tf2.getText()+"\n"+txt);
		Scan=false;
	}
	
	public boolean isScan() {
		return Scan;
	}

	public void setScan(boolean scan) {
		Scan = scan;
	}

	public void actionPerformed(ActionEvent arg0) {

		if(arg0.getSource().equals(bt1))
		{
			//Elaboration de l'adresse du post
			String addr="http://localhost:8080/travel-rest-laurent/cruise/"+tf1.getText();
			try{
				//Elaboration d'un post
				URL url = new URL(addr);
				HttpURLConnection conn = (HttpURLConnection) url.openConnection(); //création d'une connection au serveur
				InputStream is = conn.getInputStream(); //Récupération du flux de lecture
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8")); //Utilisation du flux de lecture dans un buffer de lecture
				String csv;
				csv=br.readLine(); //Récupération de la ligne en réponse à notre requête
				tf2.setText(csv); //Affichage de l'information dans notre console maison
				
				//Encodage de la réponse en JSON
				ObjectMapper n = new ObjectMapper();
				ObjectNode node = n.getNodeFactory().objectNode();
				String[] data = csv.split(",");
				node.put("dest", data[0]);
				node.put("days", Integer.parseInt(data[1]));
				tf2.setText(node.toString());
				
				is.close();
				
			}catch(Exception ex){
				tf2.setText(ex.toString());
			}
		}
		
		if(arg0.getSource().equals(bt2))
		{
			String adr = "https://fr.wikipedia.org/w/"+"api.php?action=query&format=json&"+"prop=extracts&titles=São_Paulo";
			try{
				Client c = ClientBuilder.newClient(new ClientConfig()); //Definition de celui qui demande kkc
				WebTarget t = c.target(adr); // Définition de la page visée
				Invocation.Builder ib=t.request(MediaType.APPLICATION_JSON); //Création d'un constructeur d'invocation
				Response r = ib.get(); //Réalisation de l'invocation dans un objet réponse
				tf2.setText(r.readEntity(String.class)); // Récupération du corps de la réponse (la donnée) et Mise en format de la réponse, puis affichage
				
			}catch(Exception ex){
				tf2.setText(ex.toString());
			}
		}
		
	}
}
