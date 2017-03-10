package fr.ib.hugo.travel.scandinavia;


import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity
@Region("lakeRegion")
public class Lake {

	private long id;
	private String name, country;
	private float size;

	public Lake() {
		id = 0;
		name = "";
		country = "";
		size = 0;
	}

	// javabean Lake appelé avec les arguments _id,_name,_country,_size, qui vont
	// ensuite attribuer leurs valeurs aux variables id,name,countr,size via les
	// setters des variables. Les getters permettront ensuite d'accéder à ces
	// valeurs.
	public Lake(long _id, String _name, String _country, float _size) {
		id = _id;
		name = _name;
		country = _country;
		size = _size;
	}

	@Column
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column
	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	public String toString() {
		return "ID: "+id+", Nombre: "+name+", Superficie: "+size+" m2"+", Pais: "+country;
	}
}