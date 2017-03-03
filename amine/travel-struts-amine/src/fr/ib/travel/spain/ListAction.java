package fr.ib.travel.spain;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;

public class ListAction extends ActionSupport {
	private List<Monument> monuments;

	public List<Monument> getMonuments() {
		return monuments;
	}

	public String execute() {
		Session s = HibernateUtil.openSession();
		monuments = (List<Monument>) s.createQuery("from Monument order by visitor", Monument.class).getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}
}
