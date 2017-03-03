package spain;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class ByIdAction extends ActionSupport{
	
	private static final long serialVersionUID = 2001287484617484164L;
	private int id;
	//Attributs
	private Monument monument;

	//Accesseur
	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
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
		//Lecture de l'entrée avec l'id renseigné
		monument = s.get(Monument.class, id);
		//demarrage d'une transaction
		Transaction tx = s.beginTransaction();
		//Suppression de l'élément demandé
		//if(monument!=null)s.delete(monument);
		//application du changement
		tx.commit();
		//fermeture de la session
		s.close();
		return ActionSupport.SUCCESS;
	}
}
