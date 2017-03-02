package spain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table //Options pour la table : (name="monument",schema="travel")
public class Monument {

	//Attributs
	private int id;
	private String name;
	private String location;
	private int visitor;
	
	//Constructeur vide (obligatoire pour hibernate)
	public Monument() {
		this(null, null, 0);
		this.id=0;
	}
	
	
	//Constructeur avec paramêtres
	public Monument(String name, String location, int visitor) {
		this.name = name;
		this.location = location;
		this.visitor = visitor;
	}
	
	//Accesseurs
	@Column @Id @GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(length=100,nullable=false,unique=false) //options: (name="name",length=100, nullable=false, unique=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(length=100,nullable=false,unique=false)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Column(nullable=false,unique=false)
	public int getVisitor() {
		return visitor;
	}
	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}
}
