package fr.ib.hugo.travel.db;
import org.hibernate.HibernateException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory f;

	// static: une seule usine pour toutes les sessions
	static {

		try {

			f = new Configuration().configure().buildSessionFactory();

		}

		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public static Session openSession() throws HibernateException {
		return f.openSession();
	}

}
