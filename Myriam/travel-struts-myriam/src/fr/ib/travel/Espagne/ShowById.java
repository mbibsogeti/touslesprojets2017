package fr.ib.travel.Espagne;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.BDD.HibernateUtil;
import fr.ib.travel.BDD.Monument;

public class ShowById {

	private int id;
	private Monument monument;

	public String execute() {

		Session s = HibernateUtil.openSession();
		monument = s.get(Monument.class, id);
		s.close();
		return ActionSupport.SUCCESS;
	}

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}