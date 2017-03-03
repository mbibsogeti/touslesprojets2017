package jk.travel.italie;

import java.util.List;

import org.hibernate.Session;

import com.opensymphony.xwork2.ActionSupport;

import jk.travel.data.HibernateUtil;
import jk.travel.data.Monument;

public class ItalieList {

	// ATTRIBUTS //
	private List<Monument> _listMonuments;

	// MÉTHODES //
	public String execute() {
		Session sess = HibernateUtil.openSession();
		// Liste des monuments distincts dans la table ItalieComment
		// Variante Myriam : select ic.monument from ItalieComment ic group by ic.monument
		// Variante Mickaël sess.createQuery("select distinct monument from ItalieComment where valid=:v",
		// Monument.class).setParameter("v",Boolean.TRUE).getResultList();
		_listMonuments = (List<Monument>) sess.createQuery("select distinct monument from ItalieComment where valid=true", Monument.class)
				.getResultList();
		sess.close();
		return ActionSupport.SUCCESS;
	} // end execute method

	public List<Monument> getListMonuments() {
		return _listMonuments;
	} // end _listMonuments getter

	public List<ItalieComment> getComments(Monument monu) {
		Session sess = HibernateUtil.openSession();
		// Ma version avec =true directement
//		List<ItalieComment> listComments = sess.createQuery("from ItalieComment where monument=:m and valid=true)", ItalieComment.class)
//				.setParameter("m", monu).getResultList();
		List<ItalieComment> listComments = sess.createQuery("from ItalieComment where monument=:m and valid=:v)", ItalieComment.class)
				.setParameter("m", monu).setParameter("v", Boolean.TRUE).getResultList();
		return listComments;
	} // end getComments method
} // end ItalieList class