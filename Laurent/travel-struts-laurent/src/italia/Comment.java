package italia;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import spain.Monument;

@Entity @Table //Options pour la table : (name="monument",schema="travel")
public class Comment {

	//Attributs
	private int id;
	private boolean valid;
	private String author;
	private String text;
	private Monument monument;
	
	//Constructeur vide (obligatoire pour hibernate)
	public Comment() {
		this( false, null, null, null);
		this.id=0;
	}
	
	
	//Constructeur avec paramêtres
	public Comment(boolean valid, String author, String text, Monument monument) {
		super();
		this.valid = valid;
		this.author = author;
		this.text = text;
		this.monument = monument;
	}

	//Accesseurs
	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable=false,unique=false)
	public boolean isValid() {
		return valid;
	}

	
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Column(nullable=false,unique=false)
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}

	@Column(nullable=false,unique=false)
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}

	@ManyToOne
	public Monument getMonument() {
		return monument;
	}


	public void setMonument(Monument monument) {
		this.monument = monument;
	}
	
}
