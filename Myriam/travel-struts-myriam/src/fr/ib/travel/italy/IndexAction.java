package fr.ib.travel.italy;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.BDD.Comment;
import fr.ib.travel.BDD.HibernateUtil;
import fr.ib.travel.BDD.Monument;

public class IndexAction {

	private List<Monument> monuments;

	public String execute() {
		Session s = HibernateUtil.openSession();
		monuments = (List<Monument>) s
				.createQuery("select distinct c.monument from Comment c where c.monument.pays='Italie'", Monument.class)
				.getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}

	public List<Monument> getMonuments() {
		return monuments;
	}

	public List<Comment> getComments(Monument m) {
		System.out.println(m + "hey !");
		Session s = HibernateUtil.openSession();
		System.out.println(m + "session");
		List<Comment> l = (List<Comment>) s.createQuery("from Comment c where monument=:m and valid=:v", Comment.class)
				.setParameter("m", m).setParameter("v", Boolean.TRUE).getResultList();
		System.out.println("elmt : " + l);
		s.close();
		return l;

	}

}
