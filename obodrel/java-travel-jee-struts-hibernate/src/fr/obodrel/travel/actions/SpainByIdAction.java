package fr.obodrel.travel.actions;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import fr.obodrel.travel.beans.Monument;
import fr.obodrel.travel.util.HibernateUtil;

@SuppressWarnings("serial")
public class SpainByIdAction extends ActionSupport {
	
	private Monument _monument;
	private int _id;
	
	public Monument getMonument() {
		return _monument;
	}
	
	public void setMonument(Monument monument) {
		_monument = monument;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String execute() {	

		Session tmpSession = HibernateUtil.openSession();
		_monument = tmpSession.get(Monument.class, _id);
		//DELETE : tmpSession.delete(_monument); do a delete, if we sent an already 
		//existing id it deletes the saved monument which the same id, commit afterwards to validate
		
		tmpSession.close();
		
		return ActionSupport.SUCCESS;
	}

	public void validate() {	
	}
}
