package fr.belto.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.belto.travel.hibernate.HibernateUtil;
import fr.belto.travel.hibernate.Monument;

public class ByIdAction {
	private int id;
	private Monument monument;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	public String execute(){
		Session s= HibernateUtil.openSession();
		monument=s.get(Monument.class, id);
		Transaction tx=s.beginTransaction();
		s.delete(monument);// pour supprimer un objet dans la base
		tx.commit();
		s.close();
		return ActionSupport.SUCCESS;
					}

}