package jk.travel.espagne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;
import jk.travel.data.HibernateUtil;
import jk.travel.data.Monument;

public class EspagneProposal {

	// ATTRIBUT //
	private Monument _monument;

	public String execute() {
		// Si on a rentré un monument
		if (_monument != null) {
			// Ouverture de session
			Session sess = HibernateUtil.openSession();
			// Commencement de la transaction
			Transaction transact = sess.beginTransaction();
			// Sauvegarde du monument rentré dans la table et ajout de l'ID grâce à @Id et @GeneratedValue
			System.out.print(sess.isDirty()); // false
			sess.save(_monument);
			System.out.print(sess.isDirty()); // true
			transact.commit(); // transact.rollback() si on a détecté une erreur, et qu'on veut annuler la transaction
			System.out.print(sess.isDirty()); // false
			// Fermeture de la session
			sess.close();	
		} // end if
		return ActionSupport.SUCCESS;
	} // end execute method

	public Monument getMonument() {
		return _monument;
	}

	public void setMonument(Monument monument) {
		_monument = monument;
	}
} // end EspagneProposal class

