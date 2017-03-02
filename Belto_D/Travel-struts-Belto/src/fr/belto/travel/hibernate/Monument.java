package fr.belto.travel.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table( name="monument") //schema="travel") fortement déconséillé de manière générale!!!
// on aurait pu changer le nom(name) et aussi ne pas mettre le nom de la  BD(schema)
//c'est une entité, il sera enregistré; ça va durer un certain temps
// niveau principale de sauvegarde de données (faut tjrs le mettre, necessaire)
public class Monument {
//declaration des attributs de classe
	int id;// pour identifier, pourvoir faire appel
	

	String name;
	String location;
	int visitor;// différence entre integer et int c'est que integer peut recevoir null
// declaration du contructeur en initialisalisant les attributs
// on aurait pu faire aussi public monument(){
// 	this("no-name","Inconn",0)}
	public Monument() {
		this.id=0;// initialiser à zéro pour dire que c'est pas encore initialisé
		this.name = "no_name";
		this.location = "Inconnu";
		this.visitor = 0;
	}
//constructeur avec paramètre
	public Monument(String name, String location, int visitor) {
		super();
		this.name = name;
		this.location = location;
		this.visitor = visitor;
	}
@Column (name="name", length=100, nullable=false, unique=false)
//données stockés sous forme de colonne
// notation ancien, toujours utilisé
// name pour le nommé, option
// length=100, faut toujours mettre une taille(performence, sinon il reserve sa taille maximale(millards de caractères))
// nullable=false, oblige à avoir un name au moment de la sauvegarde
// unique=false donc deux documents peuvent avoir le meme nom!
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
@Column (name="location", length=100, nullable=false, unique=false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
@Column (name="visitor", nullable=false, unique=false)
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}
@Column @Id @GeneratedValue
//@Idpar convention, on fait toujours
//generatedvalue pour generer de façon automatique au moment de la création, insertion dans la table
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
