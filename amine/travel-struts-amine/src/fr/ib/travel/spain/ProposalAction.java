package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.data.HibernateUtil;
import fr.ib.travel.data.Monument;

public class ProposalAction extends ActionSupport {
	private Monument monument;

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	public String execute() {
		// teste du formulaire de proposal.jsp
		if (monument != null) {
			Session s = HibernateUtil.openSession();
			// sauvegarde du formulaire dans la base
			Transaction tx = s.beginTransaction();
			System.out.println(s.isDirty());
			s.save(monument);// mis dans la liste
			monument.setVisitor(10 * (monument.getVisitor() / 10));// modifie
			System.out.println(s.isDirty());//pour dire que monument est changée 
			tx.commit();// tx.rollback il annule tout
			System.out.println(s.isDirty());
			s.close();
			System.out.println("SUCCESS!");
		}
		// HibernateUtil.openSession();
		return ActionSupport.SUCCESS;
	}

}
