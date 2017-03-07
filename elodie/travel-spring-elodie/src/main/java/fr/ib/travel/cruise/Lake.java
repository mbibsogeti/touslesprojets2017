package fr.ib.travel.cruise;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.data.gemfire.mapping.Region;

@Entity @Region("lakeRegion")
public class Lake {
	private Long id;
	private String name, country;
	private float size;
	
	public Lake() {
		this(0l, null, null, 0f);
	}
	public Lake(Long id, String name, String country, float size) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.size = size;
	}
	
	@Id
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Column
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	
	public String toString(){
		return id + " - " + name + ", "+ country + " avec une taille de " + size + " km²";
	}
}
