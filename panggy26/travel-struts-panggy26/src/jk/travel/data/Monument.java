package jk.travel.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// @Entity : indique que la classe qui suit sera sauvegardée sur le disque dur (persistence), on peut l'opposer à un service.
// @Table(name="monument", schema="travel") : la classe sera sauvegardée dans une table "monument" dans la base de données "travel"
@Entity @Table(name = "monument")
public class Monument {

	// ATTRIBUTS //
	private int _id;
	private String _name;
	private String _location;
	private int _visitor;

	// MÉTHODES //

	// @Id : Indique une clef primaire (unique et non nullable).
	// @GeneratedValue : Généré tout seul au moment de la création de la talbe, s'incrémente de 1 en 1.
	@Column @Id @GeneratedValue
	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	// @Column : indique la correspondance avec une colonne de la table monument.
	// name="name" est fait par défaut grâce au nom GetName.
	// length donne la limite du nombre de caractères des champs de cette colonne.
	// nullable est un booléen indiquant si les champs de cette colonne peuvent être null ou non.
	// unique est un booléen indiquant si les champs de cette colonne peuvent être null ou non.
	@Column(name = "name", length = 100, nullable = false, unique = false)
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@Column(length = 100, nullable = false, unique = false)
	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	// Si on avait voulu que cette colonne puisse recevoir la valeur null, on aurait déclaré cet attribut en Integer au lieu d'int
	@Column
	public int getVisitor() {
		return _visitor;
	}

	public void setVisitor(int visitor) {
		_visitor = visitor;
	}

	// Constructeur nécessaire au fonctionnement d'Hibernate
	public Monument() {
		// Appel
		this(null, "Unknown", 0);
	}

	// Constructeur pour nous, quand on va rajouter des données à la main
	public Monument(String name, String location, int visitor) {
		// Un identifiant valant 0 est impossible en pratique. Ce 0 apour signification : pas encore inséré dans la table.
		_id = 0;
		_name = name;
		_location = location;
		_visitor = visitor;
	}
} // end Monument class