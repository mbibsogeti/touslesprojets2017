package fr.ib.travel.Espagne;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.BDD.HibernateUtil;
import fr.ib.travel.BDD.Monument;

public class ListAction {
	
	private List<Monument> monuments;

	
	public String execute(){
		Session s=HibernateUtil.openSession();
		monuments=(List<Monument>)s.createQuery("from Monument where pays='Espagne' order by visitor",Monument.class).getResultList();
		s.close();
		return ActionSupport.SUCCESS;	
	}


	public List<Monument> getMonuments() {
		return monuments;
	}

}
