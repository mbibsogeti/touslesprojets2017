package fr.ib.travel.italy;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;
import fr.ib.travel.spain.Comment;

public class IndexAction {
	private List<Monument> monuments;
	
	
	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	public List<Comment> getComments(Monument m){
		Session s = HibernateUtil.openSession();
		List<Comment> l =s.createQuery("from Comment where monument=:m and valid=:v", Comment.class).setParameter("m", m).setParameter("v",Boolean.TRUE).getResultList();
		s.close();
		return l;
	}
	public String execute(){
		Session s = HibernateUtil.openSession();
		monuments=(List<Monument>)s.createQuery("select distinct c.monument from Comment c where c.valid=:v", Monument.class).setParameter("v",Boolean.TRUE).getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}
}
