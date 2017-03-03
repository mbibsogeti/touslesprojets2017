package fr.ib.travel.beans;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class ListAction {

	/* Etape 1 */ public String execute() {
		Session s = HibernateUtil.openSession();
		monuments = (List<Monument>)s.createQuery("from Monument order by nbVisitors", Monument.class).getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}

	/* Etape 2 */ private List<Monument> monuments;
	public List<Monument> getMonuments() {
		return monuments;
	}

}
