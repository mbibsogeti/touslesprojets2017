package spain;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import data.HibernateUtil;
import data.Monument;

public class ListAction extends ActionSupport {

	private Monument monument;
	// on crée une liste de monuments pour la remplir avec le contenu de la BD
	// et l'afficher dans une JSP
	private List<Monument> monuments;

	public List<Monument> getMonuments() {
		return monuments;
	}

	public String execute() {
		Session s = HibernateUtil.openSession();
		// On remplit la liste. Dans le createQuery on met du HQL. Ce HQL va
		// être transformé en SQL.
		// "createQuery" envoie une requête vers BD, getResultList renvoie la
		// liste des résultats.
		// On pourrait trier, ordonner ces résultats avec des options
		// supplémentaires dans "createQuery".
		// Dans la partie HQL, "Monument" est le nom de la classe.
		monuments = (List<Monument>) s.createQuery("from Monument order by visitor").getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}
}
