package fr.ib.travel.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table(name="monument"/*,schema="travel"*/)
public class Monument implements Serializable{
	
	private String name;
	private String location;
	private int visitor;
	private int id;
	
	public Monument() {
		name=null;
		location="unknown";
		visitor=0;
		id=0;
		//ou this(null, "unknown", 0, 0);
	}

	public Monument(String name, String location, int visitor, int id) {
		this.name = name;
		this.location = location;
		this.visitor = visitor;
		this.id = id;
	}
	
	@Column(name="name",length=100,nullable=false,unique=false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="location",length=100,nullable=false,unique=false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Column(name="visitor",nullable=false,unique=false)
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

}
