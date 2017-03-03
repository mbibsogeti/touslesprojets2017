package fr.ib.travel.spain;   //appel du xml hibernate.cfg  ces deux fichie sont utile 
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	public static SessionFactory f=null ;
	
	static {
		try{
			f=new Configuration().configure().buildSessionFactory();
			
		}catch (Exception ex){ex.printStackTrace();}
	}
		public static Session openSession() throws HibernateException {
			 return f.openSession();
		}
	}


