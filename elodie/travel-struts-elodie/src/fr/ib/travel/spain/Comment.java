package fr.ib.travel.spain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.ib.travel.data.Monument;

@Entity @Table
public class Comment {
	private int id;
	private boolean valid;
	private String author, text;
	private Monument monument;
	
	
	public Comment() {
		id=0;
		valid=true;
		author="";
		text="";
		monument=null;
	}
	
	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
	@Column
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Column
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@JoinColumn @ManyToOne(cascade={})
	public Monument getMonument() {
		return monument;
	}
	public void setMonument(Monument monument) {
		this.monument = monument;
	}
	
	
}
