package fr.obodrel.travel.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="comment")
public class Comment implements Serializable{

	public static final String AUTHOR_UNKNOWN = "JHON DOE";
	public static final String NO_TEXT = "EMPTY";	
		
	private static final long serialVersionUID = 1L;
	
	private int _id;
	private boolean _valid;
	private String _author;
	private String _text;
	private Monument _monument;
	
	public Comment() {
		this(false,NO_TEXT,AUTHOR_UNKNOWN,null);
	}
		
	public Comment(boolean isValid, String author, String text, Monument monument) {
		_valid = isValid;
		_author = author;
		setText(text);
		_monument = monument;
		_id = 0;
	}
	
	@Column @Id @GeneratedValue
	public int getID() {
		return _id;
	}
	
	public void setID(int id) {
		_id = id;
	}
	
	
	@Column(name="valid",nullable=false,unique=false)
	public boolean isValid() {
		return _valid;
	}
	
	public void setValid(boolean valid) {
		_valid = valid;
	}

	@Column(name="author",length=100,nullable=false,unique=false)
	public String getAuthor() {
		return _author;
	}
	
	public void setAuthor(String author) {
		_author = author;
	}

	@ManyToOne(cascade={})
	@JoinColumn(name="monument_id_fk",nullable=true,unique=false)
	public Monument getMonument() {
		return _monument;
	}
	
	public void setMonument(Monument monument) {
		_monument = monument;
	}

	@Column(name="text",length=2500,nullable=false,unique=false)
	public String getText() {
		return _text;
	}

	public void setText(String text) {
		_text = text;
	}
	
	
}
