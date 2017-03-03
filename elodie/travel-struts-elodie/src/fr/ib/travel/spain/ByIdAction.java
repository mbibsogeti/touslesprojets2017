package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;

public class ByIdAction {
	private Monument mo;
	private int id;
	
	public Monument getMo() {
		return mo;
	}

	public void setMo(Monument mo) {
		this.mo = mo;
	}

	public String execute(){
		Session s=HibernateUtil.openSession();
		Transaction tx = s.beginTransaction();
		mo=s.get(Monument.class, id);
		if(mo!=null) s.delete(mo);
		tx.commit();
		s.close();
		return ActionSupport.SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
