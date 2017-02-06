import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.io.File;
/**
 * 
 */
import java.io.FileWriter;

/**
 * @author ib
 *
 */
// Tous les voyages vers les USA
public class America {
	// Voyage à washington
	public static void doWashington() {
		System.out.println("Pas de voyage pour cet état de Washington");
	};

	// Voyage au Nevada
	public static void doNevada(int d) {
		Destination d1 = new Destination();
		// avec utilisation de getters ans setters car les attibusts sont
		// private. Sinon d1.Name aurait suffit
		d1.setName("Las Vegas");
		d1.setState("Nevada");
		d1.setDays(d);
		d1.extend(6);
		System.out.println(d1.toString());
		// System.out.println("Je vous conseille "+ d1.Name + " dans cet état de
		// "+ d1.State);
	};

	// Voyage au Texas:
	public static void doTexas() {
		CoastalDestination d1 = new CoastalDestination();
		d1.setName("Texas");
		d1.setDays(15);
		d1.setState("Nevada");
		d1.setBoat("HaitianBoat");
		System.out.println("Vous allez dans l'état de " + d1.toString());
	};

	// voyage en Luisiane
	public static void doLuisianne() /*throws IOException*/ {
		System.out.println("Dans quelle ville voulez-vous aller?");
		Scanner sc = new Scanner(System.in);
		String Lieu = sc.nextLine();
		// corriger ce que rentre l'utilisateur, espace avant et espace après
		// lieu.trim =supprime les espaces avant et après l'entrée
		// lieu.substring(0,1).= Uppercase commence à partir du première
		// caractère et le mettre en majiscule
		// lieu.substring(1) =
		// recuperer une erreur avec try
		try {
			Lieu = Lieu.trim();
			Lieu = Lieu.substring(0, 1).toUpperCase() + Lieu.substring(1);
			String Name = "Julian";
		   // enregistrer les infos dans un fichier csv, Ecrire Louisiane.csv et ajouter si ça existe deja
			FileWriter f1 = new FileWriter("ecrire_Louisianne.csv", true);
			// avec un retour 
			f1.write(Lieu +"\n ");
			f1.write(Name+"\n");
			f1.close();
			System.out.println(Name + " ira en " + Lieu);
			// utilistation de LocalDateTime
			LocalDateTime t1 = LocalDateTime.now();
			// rajouter 7 semaines
			LocalDateTime t2 = t1.plusWeeks(7);
			// rajouter ensuite 5 jours (On aurait pu le faire d'un coup avec le
			// précédent!)
			LocalDateTime t3 = t2.plusDays(5);
			System.out.println(
					"Depart au mieux le: " + t3.getDayOfMonth() + " " + t3.getMonthValue() + " " + t3.getYear());
			// affichage de l'erreur, un message perso et/ou le message du
			// systeme
			// recuperer une exception IO
		} catch (IOException ex) {
			System.out.println("Ereu IO: " + ex.getMessage());
		    // recuperer une exception quelconque
		} catch (Exception ex){
			System.out.println("Erreur : "+ex.getMessage());
			ex.printStackTrace();
			// le bloc s'executera dans tous les cas, toujours appeler
		}finally{
			System.out.println("Fin de Louisiane");
		}
	};
}
