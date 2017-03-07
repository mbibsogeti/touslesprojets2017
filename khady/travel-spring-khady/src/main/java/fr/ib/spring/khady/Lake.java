package fr.ib.spring.khady;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity @Region("lakeRegion")
public class Lake {
	private Long id;
	private String name;
	private String country;
	private float size;

/* on utilise des annotations JPA*/	
	
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

	public Lake() {
		this(0l,"","",0f);
	}
		
	public Lake(Long id, String name, String country, float size) {
		this.id = id;
		this.name = name;
		this.country = country;
		this.size = size;
	}
	@Override
	public String toString() {
		return "Le " + name + ", situé en " + country + " et dont la superficie est de " + size + " Km².";
	}
	
}
