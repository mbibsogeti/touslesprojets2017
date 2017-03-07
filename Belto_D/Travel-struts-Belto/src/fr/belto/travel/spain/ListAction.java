package fr.belto.travel.spain;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.belto.travel.hibernate.HibernateUtil;
import fr.belto.travel.hibernate.Monument;
//creation de données sous forme d'une liste en Struts-Hibernate
public class ListAction {
	private int id;
	private List<Monument> monuments;
	private List<Monument> getMonument(){
		return monuments;
	}
	
	public List<Monument> getMonuments() {
		return monuments;
	}

	public void setMonuments(List<Monument> monuments) {
		this.monuments = monuments;
	}

	public String execute(){
		Session s=HibernateUtil.openSession();
// on utilise/crée une liste avec du hql "from M..."(nouveau langage comme sql)
// là on lui dit d'ordonnée par nombre de visteurs
// odre inverse, après visitor desk
// ordre alphabétique un string
// Monument= nom de la class
		monuments=(List<Monument>)s.createQuery("from Monument order by visitor", Monument.class).getResultList();
		s.close();
				return ActionSupport.SUCCESS;
					}

}
