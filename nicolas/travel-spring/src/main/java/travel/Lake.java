package travel;
import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity
@Region ("lakeRegion")
public class Lake {
	
	private Long id;
	private String name;  
	private String country;
	private float size;
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
	
	public Lake(){
		id=0L;
		name="?";
		country="?";
		size=0f;
		
	}
	public Lake(Long id, String name, String country, float size){
		this.id= id;
		this.name= name;
		this.country= country;
		this.size= size;
	}
	public String toString(){
		return name + "se trouve au" +  country + "de superficie" + size + "km²";
	}
}
