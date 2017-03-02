package data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	// final car on ne veut qu'une SessionFactory pour tout le projet. Sert à
	// fabriquer les sessions : c'est notre usine à sessions.
	private static SessionFactory sFact;

	// ici, le constructeur sera un bloc "static" qui s'exécutera au début de la
	// classe :
	// la construction de ce bloc static peut échouer, d'où la préparation d'un
	// try/catch
	static {
		try {
			// NB : la "configuration" est l'objet "hibernate.cfg.xml" que le
			// compilateur va lire. On pourrait donner à configure() le nom du fichier à lire.
			sFact = new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static Session openSession() throws HibernateException {
		return sFact.openSession();
	}
}
