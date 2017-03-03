package fr.ib.travel.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class ByIdAction {
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private Monument monument;

	
	public Monument getMonument() {
		return monument;
	}


	public void setMonument(Monument monument) {
		this.monument = monument;
	}



	public String execute() {	
		Session s = HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		monument = s.get(Monument.class, id);
		//tx.commit();
		//s.delete(monument);
		s.close();
		return ActionSupport.SUCCESS;			
		}
		
	
	
	
}
