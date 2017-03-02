package fr.belto.travel.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
private static SessionFactory f;
// on lui dit que la configuration de sessionFactory 
// de se baser sur hibernate.cfg.xml comme fichier de configuration
static{
	try{// recuperer les erreur s'il en existe lors de la configuration
		//et les afficher
		f=new Configuration().configure().buildSessionFactory();
		
	}catch(Exception ex){ex.printStackTrace();}
	}
public static Session openSession() // ouvrir une session
throws HibernateException{// recuperer des erreurs au cas où et les envoyer à la config
	return f.openSession();
}

}


