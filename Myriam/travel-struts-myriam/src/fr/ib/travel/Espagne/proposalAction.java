package fr.ib.travel.Espagne;

import org.hibernate.Transaction;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.ib.travel.BDD.HibernateUtil;
import fr.ib.travel.BDD.Monument;

public class proposalAction {
	
	private Monument monument;
	
	public String execute(){
		if (monument!=null){
			Session s = HibernateUtil.openSession(); //Ouverture de session : connexion avec la bdd
			Transaction tx=s.beginTransaction(); // Initiation de la transaction associée à la session
			System.out.println(s.isDirty()); // Indique si les objets java sont différents des objets de la base (s.isDirty = true) ou non
			s.save(monument); // on enregistre la donnée à ajouter à la BDD dans la session
			System.out.println(s.isDirty());
			monument.setVisitor(10*(monument.getVisitor()/10));// test 
			tx.commit(); // On réalise la transaction de la session à la BDD
			System.out.println(s.isDirty());
			s.close(); // On ferme la session
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
