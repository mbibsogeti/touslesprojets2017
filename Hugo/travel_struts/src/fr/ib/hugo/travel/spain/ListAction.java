package fr.ib.hugo.travel.spain;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.hugo.travel.db.HibernateUtil;
import fr.ib.hugo.travel.db.Monument;

public class ListAction {

	private List<Monument> monuments;

	public List<Monument> getMonuments() {
		return monuments;
	}

	public String execute() {
		Session s=HibernateUtil.openSession();
		monuments=(List<Monument>) s.createQuery("from Monument order by visitor").getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}

}
