package fr.ib.hugo.travel.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {

	private int id;
	private boolean valid;
	private String author, text;
	private Monument monument;
	
	public Comment(){
		
		monument=null;
		
	}
	
	@Column
	@Id
	@GeneratedValue
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
	//Many comments to one monument
	@ManyToOne(cascade={})
	public Monument getMonument() {
		return monument;
	}
	public void setMonument(Monument monument) {
		this.monument = monument;
	}
	
}
