package fr.ib.travel.italie;



import java.util.List;

import org.hibernate.Session;


import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.spain.HibernateUtil;
import fr.ib.travel.spain.Monument;

public class IndexAction extends ActionSupport{
private List<Monument> monuments;
		public String execute() {
			
			Session s=HibernateUtil.openSession();
			
			//ici on fait un e liste d'objet si n voulai des nombre on mettrai integer a la place de monument
	//pas besoin de transaction car pas de commit et creatQuery envoi un requete sur la base et get récupère les donnée
			 
			monuments =(List<Monument>) s.createQuery("select c.monument from Comment c where c.valid=:v",Monument.class).setParameter("v",Boolean.TRUE).getResultList();
		s.close();
		
	return ActionSupport.SUCCESS;
}
		public List<Monument> getMonuments() {
			return monuments;
		}
		
	public List<Comment> getComments(Monument m){
		Session s=HibernateUtil.openSession();
	List<Comment> l = s.createQuery("from Comment where monument =:m").setParameter("m",m).getResultList();
	s.close();
	return l;
	}
		}
