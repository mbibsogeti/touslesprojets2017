package fr.ib.travel.spain;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.opensymphony.xwork2.ActionSupport;

public class ListAction {
private List<Monument>monuments;
public List<Monument>getMonuments(){
	return monuments;
}
	public String execute() {
		
			Session s=HibernateUtil.openSession();
			
			//ici on fait un e liste d'objet si n voulai des nombre on mettrai integer a la place de monument
	//pas besoin de transaction car pas de commit et creatQuery envoi un requete sur la base et get récupère les donnée
			monuments=(List<Monument>) s.createQuery("from Monument order by visitor",Monument.class).getResultList();
		s.close();
		
	return ActionSupport.SUCCESS;
}

}
