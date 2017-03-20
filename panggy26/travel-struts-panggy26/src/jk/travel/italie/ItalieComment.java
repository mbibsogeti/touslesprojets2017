package jk.travel.italie;

import com.opensymphony.xwork2.ActionSupport;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import jk.travel.data.HibernateUtil;
import jk.travel.data.Monument;
import org.hibernate.Session;

@Entity
@Table
public class ItalieComment {

	// ATTRIBUTS //
	private int _id;
	private boolean _valid;
	private String _author;
	private String _text;
	private Monument _monument;

	// MÉTHODES //
	public String execute() {
		Session sess = HibernateUtil.openSession();
		sess.close();
		return ActionSupport.SUCCESS;
	} // end execute method

	@Column @Id @GeneratedValue
	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	@Column
	public boolean isValid() {
		return _valid;
	}

	public void setValid(boolean valid) {
		_valid = valid;
	}

	@Column
	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	@Column
	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}
	
	// @ManyToOne(cascade={}) : On a plusieurs commentaires pour un monument. Lorsqu'on efface un commentaire, on laisse le monument (cas par défaut).
	@ManyToOne(cascade = {})
	public Monument getMonument() {
		return _monument;
	}

	public void setMonument(Monument monument) {
		_monument = monument;
	}

	public ItalieComment() {
		_id = 0;
		_valid = false;
		_author = "";
		_text = "";
		_monument = null;
	}
} // end ItalieComment