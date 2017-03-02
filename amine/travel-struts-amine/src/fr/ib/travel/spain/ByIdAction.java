package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;

public class ByIdAction extends ActionSupport {
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

	public String execute() {

		Session s = HibernateUtil.openSession();
		monument = s.get(Monument.class, id);
		if (monument != null) {
			Transaction tx = s.beginTransaction();
			s.delete(monument);
			tx.commit();
			s.close();
		}
		return ActionSupport.SUCCESS;
		
	}
}
