package fr.ib.travel.spain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //permet de mettre le @table et @column  @Table(name="monument")//schema="travel")  //permet de bien sauvegrader dans la table
//les chose entre parenthèse permet de fixer les limite de ce que l'on peut rentrer
//le schéma travel est en commentaire car ici on aura q'une seul bdd dc pas besoin de vérifier 
//name= indique la table dans laquel on doit etre 
public class Monument {

	
	private String name,location;
	private int visitor,id;  // on pourra mettre aussi un integer si on veu que les nb de visiteur soit nul qui est différent de 0
	
	public Monument() {
		name="";
		location="";
		visitor=0;
		id=0;
		
		//on peut aussi mettre pour remplacé les trois ligne du constructeur mettre this(null,"?",0)
				
	}
public Monument(String name,String location,int visitor) {
		this.name = name;
		this.location = location;
		this.visitor = visitor;
		
	}
@Column(name="name",length=100,nullable=false,unique=false)  // permet de définir les paramètree de la colone comme le nom , la llimte ..

public String getName() {
	return name;
}
/**
 * @return the id
 */
@Column @Id @GeneratedValue
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the location
 */
@Column(name="location",length=100,nullable=false,unique=false)
public String getLocation() {
	return location;
}
/**
 * @param location the location to set
 */
public void setLocation(String location) {
	this.location = location;
}
/**
 * @return the visitor
 */
@Column(name="visitor",length=100,nullable=false,unique=false)
public int getVisitor() {
	return visitor;
}
/**
 * @param visitor the visitor to set
 */
public void setVisitor(int visitor) {
	this.visitor = visitor;
}
}
