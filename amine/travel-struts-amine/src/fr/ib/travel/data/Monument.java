package fr.ib.travel.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//cette classe est à sauvegarder et n'est pas seulement transitoire
@Entity
// Bien sauvegarder dans une table
// @Table(name = "monument", schema = "travel")
@Table(name = "monument")
public class Monument {
	// Attribut

	private int id;
	private String name, location;
	private int visitor;

	// constructeur
	public Monument() {
		// optimiser le constructeur en minimisant les lignes
		// this(0,null,"?",0);
		id = 0;
		name = "?";
		location = "?";
		visitor = 0;
	}

	public Monument(int id, String name, String location, int visitor) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.visitor = visitor;
	}

	// déclarer une colonne Name ou bien @Column
	// length taille maximal du String dans DB Varchar
	// unique est false par défaut
	@Column
	// annotation identifiant
	@Id
	// tu génère le id automatiquement
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "Name", length = 100, nullable = false, unique = false)
	// get+set des attributs
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "Location", length = 100, nullable = false, unique = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "Visitor", nullable = false, unique = false)
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

}
