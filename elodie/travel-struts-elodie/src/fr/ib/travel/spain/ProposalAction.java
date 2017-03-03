package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;

public class ProposalAction {
	private Monument m; //Hibernate fait une instance en appelant directement le constructeur sans paramètre

	public String execute(){
		if(m !=null){
			Session s = HibernateUtil.openSession();
			Transaction tx = s.beginTransaction();
			s.save(m);
			//m.setVisitor(10*(m.getVisitor()/10));
			tx.commit();
			s.close();
		}
		return ActionSupport.SUCCESS;
	}

	public Monument getM() {
		return m;
	}

	public void setM(Monument m) {
		this.m = m;
	}
}
