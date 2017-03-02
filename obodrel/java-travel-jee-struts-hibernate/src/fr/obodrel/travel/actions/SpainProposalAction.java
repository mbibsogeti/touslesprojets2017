package fr.obodrel.travel.actions;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionSupport;

import fr.obodrel.travel.beans.Monument;
import fr.obodrel.travel.util.HibernateUtil;

@SuppressWarnings("serial")
public class SpainProposalAction extends ActionSupport {
	
	private Monument _monument;
	
	public Monument getMonument() {
		return _monument;
	}
	
	public void setMonument(Monument monument) {
		_monument = monument;
	}

	public String execute() {	
		
		if(_monument != null) {
			System.out.println("before open");
			Session tmpSession = HibernateUtil.openSession();
			System.out.println("bofore transac "+tmpSession.isDirty());
			Transaction tmpTransaction = tmpSession.beginTransaction();

			System.out.println("bedore save "+tmpSession.isDirty());
			tmpSession.save(_monument);
			_monument.setMaxVisitors(10*(_monument.getMaxVisitors()/10));
			System.out.println("before commit "+tmpSession.isDirty());
			tmpTransaction.commit();
			System.out.println("before close "+tmpSession.isDirty());
			tmpSession.close();
			System.out.println("after close");
		}
		
		return ActionSupport.SUCCESS;
	}

	public void validate() {	
	}
}
