package jk.travel.scandinavie;

import javax.persistence.Column;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

//Correspond au value= dans <property du bean correspondant
@Entity // JPA
@Region("lakeRegion") // Gemfire
public class Lake {

	// ATTRIBUTS //
	private long _id;
	private String _name;
	private String _country;
	private float _size;

	// MÉTHODES //
	public Lake() {
		_id = 0;
		_name = "";
		_country = "";
		_size = 0;
	}

	public Lake(long id, String name, String country, float size) {
		_id = id;
		_name = name;
		_country = country;
		_size = size;
	}

	@Id // Spring
	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	@Column // JPA
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Column // JPA
	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	@Column // JPA
	public float getSize() {
		return _size;
	}

	public void setSize(float size) {
		_size = size;
	}

	public String toString() {
		return "Id : " + _id + ", Name : " + _name + ", Country : " + _country + ", Size : " + _size + " km²";
	} // end toString method
} // end Lake class