package spain;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class ListAction extends ActionSupport{
	
	private static final long serialVersionUID = 2001287484617484164L;
	private int id;
	
	//Attributs
	private List<Monument> monuments;

	//Accesseur
	public List<Monument> getMonuments() {
		return monuments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	//Définit si l'action s'est bien déroulé
	public String execute(){
		
		//ouverture de la session
		Session s = HibernateUtil.openSession();
		//récupération d'une liste de d'élément ordonnée
		monuments = (List<Monument>) s.createQuery("from Monument order by visitor",Monument.class).getResultList();
		//fermeture de la session
		s.close();
		return ActionSupport.SUCCESS;
	}
}
