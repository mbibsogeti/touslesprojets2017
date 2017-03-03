package jk.travel.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
/**
 * Classe dédiée à l'objet session Hibernate
 */
	// ATTRIBUTS //
	private static SessionFactory _sesFact;
	
	// Bloc qui s'exécute à l'instanciation. Équivalent du constructeur pour les éléments statiques.
	static {
		try {
			_sesFact = new Configuration().configure().buildSessionFactory();
		} catch(Exception exc) {
			exc.printStackTrace();
		} // end catch
	} // end static
	
	// MÉTHODES //
	// Erreur récupérée au moment où on fait appel à ceci
	public static Session openSession() throws HibernateException {
		return _sesFact.openSession();
	} // end openSession method
} // end HibernateUtil