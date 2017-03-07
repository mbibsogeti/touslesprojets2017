package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Comment {

	private int id;
	// ce booléen permettra de valider le commentaire
	private boolean valid;
	private String author, text;
	// on va ici faire référence à l'id d'un objet "monument" de la table
	// "monuments"
	private Monument monument;

	public Comment() {
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

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

	// @ManyToOne : de moi vers l'objet, ici many comments vers one monument
	@ManyToOne(cascade = {})
	@JoinColumn
	public Monument getMonument() {
		return monument;
	}

	public void setMonument(Monument monument) {
		this.monument = monument;
	}

}
