package fr.belto.travel.italy;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.belto.travel.hibernate.Comment;
import fr.belto.travel.hibernate.HibernateUtil;
import fr.belto.travel.hibernate.Monument;

public class IndexAction {
	private List<Monument> monuments;
	public List<Comment> getComments(Monument m){
		Session s=HibernateUtil.openSession();
		List<Comment> l=s.createQuery("from Comment where monument=:m and valid=:v",Comment.class).setParameter("m",m).setParameter("v",Boolean.TRUE).getResultList();
		s.close();
		return l;
					}
	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	public String execute(){
		Session s=HibernateUtil.openSession();
//select c.monument from Comment c--> on va chercher les monunents avec commentaires,
// Du coup les monuments avec plusieurs commentaires sont affichés plusieurs fois
// du coup on rajoute (group by c.monument) ou encore (select distinct c.monument from Comment c) yes. On prend le monument qu'une fois
// pour ne prendre que ceux qui ont des commentaires validés on met(--where c.valid=:v---et aussi-setParameter("v",Boolean.TRUE))
		monuments=(List<Monument>)s.createQuery("select c.monument from Comment c where c.valid=:v group by c.monument ", Monument.class).setParameter("v",Boolean.TRUE).getResultList();
		s.close();
				return ActionSupport.SUCCESS;
					}
	
}
