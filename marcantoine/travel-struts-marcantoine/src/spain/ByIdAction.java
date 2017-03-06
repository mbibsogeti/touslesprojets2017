package spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import data.HibernateUtil;
import data.Monument;

// On va utiliser cette action pour afficher un monument dans la jsp.
public class ByIdAction extends ActionSupport {

	private Monument monument;
	private int id;

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
		Transaction tx = s.beginTransaction();
		// Implémentation du delete : supprime l'objet demandé dans la barre
		// d'url. Attention : ce genre de page est dangereux et représenterait
		// une faille de sécurité. A l'usage, on protégerait cette page avec un
		// pswd.
//		s.delete(monument);
		tx.commit();
		s.close();
		return ActionSupport.SUCCESS;
	}

}
