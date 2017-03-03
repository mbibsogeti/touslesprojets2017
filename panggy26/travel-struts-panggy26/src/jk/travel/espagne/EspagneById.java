package jk.travel.espagne;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.opensymphony.xwork2.ActionSupport;
import jk.travel.data.HibernateUtil;
import jk.travel.data.Monument;

public class EspagneById {

	// ATTRIBUT //
	private Monument _monument;
	private int _identifiant;

	// MÉTHODES //
	public String execute() {
		Session sess = HibernateUtil.openSession();
		// localhost:8080/travel-struts-panggy26/espagne/byId?identifiant=2 utilise getIdentifiant et affiche le 2e élément de la BD
		// sess.get(Monument.class, _identifiant) : appelle la méthode setId de Monument
		_monument = sess.get(Monument.class, _identifiant);
		if (_monument != null) {
			Transaction transact = sess.beginTransaction();
//			sess.delete(_monument);
			transact.commit();
		} // end if
		sess.close();
		return ActionSupport.SUCCESS;
	} // end execute method

	public Monument getMonument() {
		return _monument;
	}

	public void setMonument(Monument monument) {
		_monument = monument;
	}

	public int getIdentifiant() {
		return _identifiant;
	}

	public void setIdentifiant(int identifiant) {
		_identifiant = identifiant;
	}
} // end EspagneById class