package fr.ib.travel.BDD;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "monument" /* ,schema="travel" */)
public class Monument {

	private int id;
	private String name;
	private String location;
	private int visitor;
	private String pays;

	public Monument() {
		this(0, "", "?", 0,"");
	}

	public Monument(int id, String name, String location, int visitor, String pays) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.visitor = visitor;
		this.pays=pays;
	}

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

	@Column(name = "visitor", length = 100, nullable = false, unique = false)
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "pays", length = 100, nullable = false, unique = false)
	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

}


