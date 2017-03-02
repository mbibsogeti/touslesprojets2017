package fr.belto.travel.spain;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.belto.travel.hibernate.HibernateUtil;
import fr.belto.travel.hibernate.Monument;

public class ProposalAction extends ActionSupport {
	private Monument monument;//on declare monument comme attribut
	// on se prepare a se connecter avec
	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	public String execute(){
		if(monument!=null){//il prend ce que l'on rentre (il ouvre une session), il le stock temporairement
			Session s= HibernateUtil.openSession();// pour l'instant il ne l'enregistre pas
			Transaction tx=s.beginTransaction();
			//monument.setVisitor(10*(monument.getVisitor()/10));// arrondi à 10
			System.out.print(s.isDirty());
			s.save(monument);// on doit lui indiquer une transation(un commit) pour qu'il le sauvegarde
			monument.setVisitor(10*(monument.getVisitor()/10));
			tx.commit();// appliquer l'information
			s.close();
// interet des transactions, ils peuvent etre liés car on peut dire que soit tout réussit soit tout échoue
// plusieurs opération non compatible!, rendre possible les ations simultanés
			}
		 return ActionSupport.SUCCESS;
					}
}
