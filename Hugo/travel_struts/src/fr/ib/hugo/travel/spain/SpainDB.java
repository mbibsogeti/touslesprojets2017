package fr.ib.hugo.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.hugo.travel.db.HibernateUtil;
import fr.ib.hugo.travel.db.Monument;

public class SpainDB {

	private Monument monument;

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	public String execute() {
		if (monument != null) {
			Session s = HibernateUtil.openSession();
			// permet d'avoir une atomicité, cohérence, isolation et durabilité dans l'ensemble de requêtes
			// envoyées. Nécessaire pour modifier la table
			Transaction tx = s.beginTransaction();
			System.out.println(s.isDirty());
			//save fait 3 choses: insert - génération id - enregistre les changements
			s.save(monument);
//			monument.setVisitor(10*(monument.getVisitor()/10));
			System.out.println(s.isDirty());
			tx.commit();
			System.out.println(s.isDirty());
			s.close();
		}
		return ActionSupport.SUCCESS;
	}

}
