package fr.obodrel.travel.actions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import fr.obodrel.travel.beans.Monument;
import fr.obodrel.travel.util.HibernateUtil;

@SuppressWarnings("serial")
public class SpainListAction extends ActionSupport {
	
	private List<Monument> _monumentArray;
	
	public List<Monument> getMonuments() {
		return _monumentArray;
	}

	public String execute() {	

		if(_monumentArray == null) {
			Session tmpSession = HibernateUtil.openSession();
			Transaction tmpTransaction = tmpSession.beginTransaction();
			Query<Monument> selectMonuments = tmpSession.createQuery("from Monument order by max_visitors",Monument.class);
			
			_monumentArray = selectMonuments.getResultList();	
			tmpTransaction.commit();
			tmpSession.close();
		}
		
		return ActionSupport.SUCCESS;
	}

	public void validate() {	
	}
}
