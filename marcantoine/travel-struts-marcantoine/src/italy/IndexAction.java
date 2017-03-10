package italy;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import data.Comment;
import data.HibernateUtil;
import data.Monument;

public class IndexAction extends ActionSupport {

	private Monument monument;
	// on crée une liste de monuments pour la remplir avec le contenu de la BD
	// et l'afficher dans une JSP
	private List<Monument> monuments;

	public List<Monument> getMonuments() {
		return monuments;
	}

	public String execute() {
		Session s = HibernateUtil.openSession();
		// On cherche à récupérer les monuments possédant un commentaire :
		// monuments = (List<Monument>) s.createQuery("REQ").getResultList();
		// REQ="select c.monument from Comment c"
		// ATTENTION, pour éviter d'afficher plusieurs fois un monument ayant
		// plusieurs comms, on doit utiliser group by OU distinct :
		// REQ="select c.monument from Comment c group by c.monument"
		// REQ="select distinct c.monument from Comment c"
		// Ce dernier veut dire que la machine va récupérer des monuments
		// distincts.
		// On veut maintenant sélectionner les monuments avec un commentaire
		// avec valid=1 :
		// monuments = (List<Monument>) s.createQuery("select distinct
		// c.monument from Comment c where c.valid=:v")
		// .setParameter("v", Boolean.TRUE).getResultList();
		// Dans ce cas, on utilise .setParameter() en entrant une valeur pour ce
		// paramètre dans notre requête. ATTENTION : "group by" sera placé après
		// le "where"
		monuments = (List<Monument>) s.createQuery("select distinct c.monument from Comment c where c.valid=:v")
				.setParameter("v", Boolean.TRUE).getResultList();
		s.close();
		return ActionSupport.SUCCESS;
	}

	// On prépare ici une action qui nous permettra d'aller chercher les
	// commentaires associés à un monument
	public List<Comment> getComments(Monument m) throws HibernateException {
		System.out.println("value m"+m);
		Session s = HibernateUtil.openSession();
		List<Comment> l = s.createQuery("from Comment where monument =:m and valid=:v", Comment.class).setParameter("m", m).setParameter("v", Boolean.TRUE)
				.getResultList();
		s.close();
		return l;
	}

}
