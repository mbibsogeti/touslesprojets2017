package fr.ib.travel.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory f;
	static {
		try {
			f=new Configuration().configure().buildSessionFactory();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static Session openSession() throws HibernateException{
		return f.openSession();
	}
}