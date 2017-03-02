package fr.obodrel.travel.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory hibernateSessionFactory = null;
	
	static {
		try {
			hibernateSessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static Session openSession() throws HibernateException {
		return hibernateSessionFactory.openSession();
	}
}
