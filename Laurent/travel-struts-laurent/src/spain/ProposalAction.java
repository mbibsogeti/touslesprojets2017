package spain;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class ProposalAction extends ActionSupport{
	
	private static final long serialVersionUID = 2001287484617484164L;
	
	//Attributs
	private Monument monument;

	//Accesseur
	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	//Définit si l'action s'est bien déroulé
	public String execute(){
		if(monument!=null){
			//ouverture de la session
			Session s = HibernateUtil.openSession();
			//demarrage d'une transaction
			Transaction tx = s.beginTransaction();
			//récupération de la donnée relative à la nouvelle entrée dans la base
			System.out.println(s.isDirty());
			s.save(monument);
			System.out.println(s.isDirty());
			monument.setVisitor(10*(monument.getVisitor()/10));
			System.out.println(s.isDirty());
			//application du changement
			tx.commit();//alternative : tx.rollback(); pour annuler tt ce qui était en attente dans la transaction
			//fermeture de la session
			s.close();
			//Préparation pour une nouvelle entrée
			monument= new Monument();
		}
		return ActionSupport.SUCCESS;
	}
}
