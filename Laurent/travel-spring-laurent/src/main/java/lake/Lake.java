package lake;

import javax.persistence.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.gemfire.mapping.Region;

@Entity @Region("lakeRegion") //Déclaration de lake comme étant une table et association de cette table à la region "lakeRegion" déclaré dans spring.xml
public class Lake {

	//ATTRIBUT
	private Long id;
	private String name;
	private String country;
	private float size;
	
	//CONSTRUCTEUR SANS PARAMETRES
	public Lake() {
		this(null, null, null, 0.00f);
	}

	//CONSTRUCTEUR AVEC TOUS LES PARAMETRES
	public Lake(Long id, String name, String country, float size) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
		this.size = size;
	}

	//ACCESSEUR
	@Id //Définition de l'id relative à l'entrée qui sera instancié
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column //Qualification en champ
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

	//TO STRING (de base)
	@Override
	public String toString() {
		return "Lake : id=" + id + ", name=" + name + ", country=" + country + ", size=" + size;
	}

	
}
