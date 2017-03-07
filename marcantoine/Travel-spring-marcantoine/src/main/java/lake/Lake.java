package lake;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity
@Region("lakeRegion")
public class Lake {

	private long id;
	private float size;
	private String name, country;

	public Lake() {
		super();
	}

	public Lake(long id, float size, String name, String country) {
		super();
		this.id = id;
		this.size = size;
		this.name = name;
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "Lake: id=" + id + ", size=" + size + ", name=" + name + ", country=" + country;
	}

	@Id
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public float getSize() {
		return size;
	}

	public void setSize(float size) {
		this.size = size;
	}

	@Column
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
