package spain;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	//Création d'un créateur de session
	private static SessionFactory sFact;
	
	//Indication d'un seul créateur pour toute session
	static{
		try{
			//Indique au créateur d'aller chercher le fichier "Hibernate.cfg.xml" par défaut connaitre la configuration de la session
			sFact = new Configuration().configure().buildSessionFactory();
			
		}catch(Exception ex){ex.printStackTrace();}
	}

	//Création de la session
	public static Session openSession() throws HibernateException{
		return sFact.openSession();
	}
}
