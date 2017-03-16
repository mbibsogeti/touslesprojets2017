package fr.ib.travel.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="monument"/*,schema="travel"*/)

public class Monument {
	
	private int id;
		
	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String name; 
	private String location;
	private int nbVisitors;

	
	@Column(name="name",length=100, nullable=false, unique=false)/*nullable=false veut dire que le nom ne peut pas ne pas être connu*/
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="location",length=100, nullable=false, unique=false)
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="nbVisitors", nullable=false, unique=false)
	public int getNbVisitors() {
		return nbVisitors;
	}

	public void setNbVisitors(int nbVisitors) {
		this.nbVisitors = nbVisitors;
	}

	public Monument() {
    this("","?",0);
	}

	public Monument(String name, String location, int nbVisitors) {
		this.name = "";
		this.location = "unknown";
		this.nbVisitors = 0;
		this.id = 0;
	}

}
