package jk.travel.espagne;

import java.util.List;
import org.hibernate.Session;
import com.opensymphony.xwork2.ActionSupport;
import jk.travel.data.HibernateUtil;
import jk.travel.data.Monument;

public class EspagneList {

	// ATTRIBUTS //
	private List<Monument> _listMonuments;

	// MÉTHODES //

	public String execute() {
		Session sess = HibernateUtil.openSession();
		// Pas besoin d'ouvrir des transactions, car on n'est qu'en lecture seule de la BD
		// Bien vérifier la concordance entre le type de ce que demande la requête HQL et l'objet Java.
		// Par exemple, si on n'avait voulu que la liste des noms, on aurait eu List<String>
		// La requête HQL fonctionne ainsi : appel au constructeur vide de Monument (dans FROM), puis appels aux getters.
		_listMonuments = (List<Monument>) sess.createQuery("from Monument order by visitor", Monument.class).getResultList();
		sess.close();
		return ActionSupport.SUCCESS;
	} // end execute method

	public List<Monument> getListMonuments() {
		return _listMonuments;
	} // end _listMonuments getter
} // end EspagneList class