package fr.belto.travel.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// pas obliger de le mettre dans le même package que monument
@Entity @Table
public class Comment {
	private int id;
	private boolean valid;
	private String author,text;
	private Monument monument;
@Column @Id	@GeneratedValue
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
  @ManyToOne(cascade={}) // Many (celui en en cours(comment) to one(Un monument))
 // cascade={} = pas de cascade, quand on supprime ou on fait quelque chose, il n'y a aucune consequence
  // ça cree automatimatique dans le schema travel(une table comment)
	public Monument getMonument() {
		return monument;
	}
	public void setMonument(Monument monument) {
		this.monument = monument;
	}

}
