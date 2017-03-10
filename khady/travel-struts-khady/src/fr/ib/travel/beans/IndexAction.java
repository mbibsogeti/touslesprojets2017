package fr.ib.travel.beans;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction {

	public String execute() {
		Session s = HibernateUtil.openSession();
		monuments = (List<Monument>) s.createQuery("select distinct c.monument from Comment c where c.valid=:v", Monument.class).setParameter("v", Boolean.TRUE).getResultList();
	
		s.close();
		return ActionSupport.SUCCESS;

	}

	/* Etape 2 */ private List<Monument> monuments;
	public List<Monument> getMonuments() {
		return monuments;
	}

	public List<Comment> getComments(Monument m) {
		Session s = HibernateUtil.openSession();
		List<Comment> l = s.createQuery("from Comment where monument=:m",Comment.class).setParameter("m",m).getResultList();	
		return l;
	}


	
	

}
