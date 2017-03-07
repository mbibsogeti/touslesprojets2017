package fr.ib.travel.beans;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.opensymphony.xwork2.ActionSupport;

@Entity @Table(name="comment")
public class Comment {
    private Monument monument;
	private int id;
	private String author, text;
	private boolean valid;
		
	public String execute() {	
	
		return ActionSupport.SUCCESS;			
		}

	
	@JoinColumn @ManyToOne(cascade={})//@ManyToOne veut dire +sieurs commentaires pour un seul monument
	public Monument getMonument() {
		return monument;
	}
	
	public void setMonument(Monument monument) {
		this.monument = monument;
	}

	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(nullable=false, unique=false)
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column(nullable=false, unique=false)
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Column
	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	public Comment() {
	this(null,0,"","",true);	
	}

	public Comment(Monument monument, int id, String author, String text, boolean valid) {
		this.monument = null;
		this.id = 0;
		this.author = "";
		this.text = "";
		this.valid = false;
	
	
}

}

