package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

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
		
			Session s=HibernateUtil.openSession();
			Transaction tx=s.beginTransaction(); //necessaire pour agir sur la bdd
			monument=s.get(Monument.class, id);
			s.delete(monument);
		tx.commit();//necessaire pour agir sur la bdd
		s.close();
		
	return ActionSupport.SUCCESS;
}

}
