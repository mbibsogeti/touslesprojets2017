package fr.ib.travel.spain;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

public class ProposalAction extends ActionSupport{
	
	private Monument monument;

	public Monument getMonument() {
		return monument;
	}


	public void setMonument(Monument monument) {
		this.monument = monument;
	}


	public String execute() {
		if(monument!=null){
			Session s=HibernateUtil.openSession();
			Transaction tx=s.beginTransaction();//necessaire pour agir sur la bdd
			monument.setVisitor(10*(monument.getVisitor()/10));
			System.out.println(s.isDirty());
			s.save(monument);
			System.out.println(s.isDirty());
			tx.commit();//tx.rollback //necessaire pour agir sur la bdd
			System.out.println(s.isDirty());
			s.close();
		}
		
		return ActionSupport.SUCCESS;
	}
	

	}

