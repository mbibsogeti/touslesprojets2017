package fr.belto.travel.springdata;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity	
@Region("lakeRegion")
public class Lake {
	long id;
	String name;
	String country;
	float size;
	
public Lake() {
		super();
		// TODO Auto-generated constructor stub
	}
// to String permet de retourner tes données sous forme de chaine de caractère)
@Override
public String toString() {
	return "Lake [id=" + id + ", name=" + name + ", country=" + country + ", size=" + size + "]";
}

public Lake(long id, String name, String country, float size) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.size = size;
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
	public float getSize() {
		return size;
	}
	public void setSize(float size) {
		this.size = size;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}


}
           
