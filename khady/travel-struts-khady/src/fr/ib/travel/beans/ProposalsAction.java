package fr.ib.travel.beans;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;


public class ProposalsAction {
	
	private Monument monument;	
	
	public Monument getMonument() {
		return monument;
	}


	public void setMonument(Monument monument) {
		this.monument = monument;
	}


	public String execute() {		
		
		if(monument!=null){
			Session s = HibernateUtil.openSession();
		    Transaction tx = s.beginTransaction();			    
			s.save(monument);// 1- fait le INSERT, 2- génére l'identifiant
			monument.setNbVisitors(10*(monument.getNbVisitors()/10));// permet un arrondi à 10 près c.a.d si je rentre la valeur 17 il n'enregistre que 10					
			tx.commit();// 3- fait le UPDATE et on aurait pu utiliser un équivalent qui est tx.rollback() à la place de tx.commit() ;
			System.out.println(s.isDirty());
			s.close();							
		}
		return ActionSupport.SUCCESS;
		
			
	}
	
	
}
