package fr.obodrel.travel.actions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.opensymphony.xwork2.ActionSupport;

import fr.obodrel.travel.beans.Comment;
import fr.obodrel.travel.beans.Monument;
import fr.obodrel.travel.util.HibernateUtil;

@SuppressWarnings("serial")
public class ItalyIndexAction extends ActionSupport {

	private List<Monument> _monumentsList;
	
	public List<Comment> getComments(Monument currMonument) {
		Session tmpSession = HibernateUtil.openSession();
		Transaction tmpTransaction = tmpSession.beginTransaction();
		String selectCommentsForMonumentsQueryString;
		selectCommentsForMonumentsQueryString = "select distinct c from Comment as c where c.monument = :currMonument and c.valid = :isValid";
		Query<Comment> selectCommentForMonuments = tmpSession.createQuery(selectCommentsForMonumentsQueryString,Comment.class);
		selectCommentForMonuments.setParameter("currMonument", currMonument);
		selectCommentForMonuments.setParameter("isValid", true);
		
		List<Comment> commentList = selectCommentForMonuments.getResultList();
		
		tmpTransaction.commit();
		tmpSession.close();
		return commentList;
	}

	public List<Monument> getMonuments() {
		return _monumentsList;
	}

	public String execute() {

		if (_monumentsList == null) {
			Session tmpSession = HibernateUtil.openSession();
			Transaction tmpTransaction = tmpSession.beginTransaction();
			String selectMonumentsQueryString;
			selectMonumentsQueryString = "select distinct m from Comment as c inner join c.monument as m where "
					+ "lower(m.location) like :likeArg and c.valid = :isValid and m = c.monument";
			Query<Monument> selectMonuments = tmpSession.createQuery(selectMonumentsQueryString,Monument.class);
			selectMonuments.setParameter("likeArg", "italy%");
			selectMonuments.setParameter("isValid", true);
			
			_monumentsList = selectMonuments.getResultList();
			tmpTransaction.commit();
			tmpSession.close();
		}
		return ActionSupport.SUCCESS;
	}

	public void validate() {
	}
}
