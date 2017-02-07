package fr.ib.nicolas.travel;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JFrame;


public class Amerique {

	static void dotexas() {
		DestinationMaritime d1 = new DestinationMaritime();
		d1.setName("toto");
		d1.setDays(1);
		d1.setState("toto");
		d1.setBoat("titan");
		System.out.println(d1.toString());
	}

	
	static void donevada() {
		System.out.println("neuneu");
		Destination d1 = new Destination("to", "ta", 0);

		// ou Destination d1=null qui va initialis� l o,"ta",0bjet d1; d1 = new
		// Destination();

		// d1.name= "nevaaada";
		// d1.extend(6);
		System.out.println(d1.toString());

	}

	static void dowashingtown() { // fonction appeler par l'autre classe voyage
									// 2

		System.out.println("messagedelautreclass");

		
	}
	
	
	 static void do_louisiane(){//throws IOException { //throws
	// indique qu'on va avoir des exception qui vont remonté par la fonction ,
	// sauf les runtime exception on ne met pas throw
		 
	Scanner sc = new Scanner(System.in);

	try

	{

			System.out.println("lieu de destination");
			
			String lieu = sc.nextLine();
			lieu = lieu.trim(); // enleve les espace en trop 
	
			/*if(..lieu)
				throw sans s indique quon déclenche une exception manuel 
				syntaxe : throw new Exception (""); Exception est tjr de type throwable 
				
			*/
			
			System.out.println("nom");
			lieu = lieu.substring(0, 1).toUpperCase() + lieu.substring(1); // susstring 
																			//s�l�ctione,
																			// cd
																			// lieu
																			// substring(0,1)
																			// s�l�ctionne
																			// le
																			// premier
																			// caract�re
																			// et
																			// que
																			// lui
																			// ,
																			// (longueur
																			// 1)
																			// et
																			// ensuite
																			// le
																			// substring(1)
																			// s�lectionne
																			// le
																			// rste
																			// a
																			// partir
																			// du
																			// premeir
																			// carat�re
																			// (
																			// soit
																			// odnc
																			// le
																			// 2eme
																			// car
																			// on
																			// commence
																			// �
																			// 0

			String nom = sc.nextLine();
			System.out.println("lieu : " + lieu + "nom : " + nom);
			FileWriter f1 = new FileWriter("enregistrement.csv",true);
			f1.write(lieu +","+"\n");
			
			f1.close();
			
	/*	} catch (outofmemoryException){    // catch pour dépassement de mémoire sinon il passe au suivant 
	   
			
		}*/
	      }catch (IOException ex) {  //, catch de toute les exceptions d'entrée sortie 
		
			System.out.println("erreur : "+ex.getMessage());
			}catch (Exception ex) { 
				System.out.println("erreur : " +ex.getMessage());
				ex.printStackTrace();      // indique l'emplacement de l'erreur
		   }finally 	{
			System.out.println("fin: ");							//est executé tout le temps sauf si on a un catch qui récuère l'exeption . 
		}
		
		
	}


	/*static void do_nouvelleorlean(Scanner sc) {

		System.out.println("lieu de destination");
		String lieu = sc.nextLine();
		lieu = lieu.trim();
		System.out.println("nom");
		lieu = lieu.substring(0, 1).toUpperCase() + lieu.substring(1); // susstring
																		// s�l�ctione,
																		// cd
																		// lieu
																		// substring(0,1)
																		// s�l�ctionne
																		// le
																		// premier
																		// caract�re
																		// et
																		// que
																		// lui ,
																		// (longueur
																		// 1) et
																		// ensuite
																		// le
																		// substring(1)
																		// s�lectionne
																		// le
																		// rste
																		// a
																		// partir
																		// du
																		// premeir
																		// carat�re
																		// (
																		// soit
																		// odnc
																		// le
																		// 2eme
																		// car
																		// on
																		// commence
																		// � 0

		String nom = sc.nextLine();
		System.out.println("lieu : " + lieu + "nom : " + nom);
		LocalDateTime t = LocalDateTime.now().plusWeeks(7).plusDays(5);
		System.out.print("d�part le " + String.format("%02d %02d", t.getDayOfMonth(), t.getMonthValue()));

	}

	private String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}
}
*/

static void do_floride() { 
	Scanner sc = new Scanner(System.in);
	try {
		System.out.println("mbase de donnée");
		System.out.println("nom?");
		String name =sc.nextLine();
		System.out.println("email?");
	    String email =sc.nextLine();
	    
	    //syntaxe spécifique au base de donnée ..
	    Class.forName("org.sqlite.JDBC");
	    Connection conn = DriverManager.getConnection(
	    		
	    		"jdbc:sqlite:florida.sqlite"
	    		
	    		);
	    Statement st = conn.createStatement(); //ecrire une requete sql  a chaque requete un statement 
	    st.executeUpdate("CREATE TABLE IF NOT EXISTS demande (id INTEGER PRIMARY KEY, name TEXT, email TEXT);");
	    PreparedStatement st2 = conn.prepareStatement("INSERT INTO demande(name,email)VALUES(?,?)");
	    st2.setString(1,name);
	    st2.setString(2,email);
	    st2.executeUpdate();
	    
	    PreparedStatement st3 = conn.prepareStatement("SELECT name FROM demande WHERE email = ?");
	    st3.setString(1,email);
	    ResultSet rs = st3.executeQuery();
	    String names = "";
	    while(rs.next())
	    	names += rs.getString("name")+" , ";
	    rs.close();
	    conn.close();
	    
	    System.out.println("demade de " + name +"enregistre"+ names);
	  
	    System.out.println("demande de"+ name+"enregistré");//message de confirmation 
	}catch(Exception ex){
		System.out.println(ex);
		
	
	}
}
	static void do_ny(){ // fonction appeler par l'autre classe voyage
		// 2
		new Do_nyaffich();
       System.out.println("affichage");
       


    		   
}
	}




