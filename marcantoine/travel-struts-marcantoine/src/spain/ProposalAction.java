package spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import data.HibernateUtil;
import data.Monument;

public class ProposalAction extends ActionSupport {

	/**
	 * Sérialisation (dans les faits, on ne sérialisera jamais de cette façon) :
	 */
	private static final long serialVersionUID = 1L;
	private Monument monument;

	public String execute() {
		// faire en sorte qu'en exécutant l'action (avant le return) on aille
		// chercher une session :
		HibernateUtil.openSession();
		if (monument != null) {
			Session s = HibernateUtil.openSession();
			// élément transaction n'est pas propre à Hibernate mais on est
			// presque obligé de l'utiliser. Complexifie un
			// peu le code mais aura un impact intéressant. Si on n'en fait pas,
			// on ne peut faire de modif de la table car il valide ceci au
			// moment du commit.
			Transaction tx = s.beginTransaction();
			System.out.println(s.isDirty());
			// On arrondit à 10 près l'attribut "Visitor"
			// monument.setVisitor(10 * (monument.getVisitor() / 10));
			// Fait une insertion des données dans la table ET donne une
			// nouvelle IDs
			s.save(monument);
			System.out.println(s.isDirty());
			monument.setVisitor(10 * (monument.getVisitor() / 10));
			System.out.println(s.isDirty());
			// tx.commit() est ce qui permet d'appliquer les changements.
			// Opération alternative au commit est le "rollback".
			tx.commit();
			System.out.println(s.isDirty());
			s.close();
		}
		return ActionSupport.SUCCESS;
	}

	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}
}
