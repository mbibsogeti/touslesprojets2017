package fr.ib.hugo.travel.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// dans la bd, la bd s'appelle travel et la table s'appelle monument
@Table(name = "monument", schema = "travel")
public class Monument {

	private int id;
	private String name;
	private String location;
	private int visitor;

	public Monument() {

		this(null, "?", 0);

	}

	public Monument(String _name, String _location, int _visitor) {

		id = 0;
		name = _name;
		location = _location;
		visitor = _visitor;

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

	// nullable=false: la colonne ne peut pas recevoir des valeurs null
	// unique=false: deux monuments peuvent avoir le même nom
	@Column(name = "name", length = 100, nullable = false, unique = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "location", length = 100, nullable = false, unique = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name = "visitor", length = 100, nullable = true, unique = false)
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

}
