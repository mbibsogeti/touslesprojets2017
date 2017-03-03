package data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

// cette classe est sérialisable. Elle hérite de la classe Object automatiquement ! Pas besoin d'écrire extends Object
// l'annotation "@Entity" permet d'indiquer que "ceci est à enregistrer". On importe l'annotation de javax.persistence (créée par JPA, tout le monde l'utilise)
// la classe est alors désignée comme une "entité" (est conservée sur disque dur) en opposition avec le "service".
// l'annotation @Table (JPA également) dit que cette entité sera stockée dans une table.
// on peut choisir le nom de la table, ex: @Table(name= "monument", schema="travel").
// le plus souvent ne sert à rien.
@Entity
@Table
public class Monument {

	private String name, location;
	private int visitor, id;

	// Pour Hibernate, il est obligatoire d'écrire un constructeur vide si on en
	// fait plusieurs. NB : les types primitifs ne prennent pas "null" comme
	// valeur.
	public Monument() {
		// "this" correspond ici au constructeur utilisant les trois args. Qui
		// peut le plus peut le moins ! C'est une affaire de récursivité.
		this(null, null, 0, 0);
	}

	public Monument(String name, String location, int visitor, int id) {
		this.name = name;
		this.location = location;
		this.visitor = visitor;
		this.id = 0;
	}

	// on annote aussi les propriétés avec @Column. Attention, il faut fixer une
	// taille pour des questions de performances avec length=x (donne un nbr de
	// caractères).
	// Annotations ne sont pas que techniques, il faut ici connaître le projet !
	// ex : annotation nullable = false / true permet de dire si les valeurs
	// seront sauvegardées ou pas si le name est égal à null.
	// unique=false/true permet de dire si "name" peut avoir plusieurs fois la
	// même valeur
	@Column(name = "name", length = 100, nullable = false, unique = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "location", length = 100, nullable = false, unique = false)
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	// pour les int, length n'a plus de sens !!
	@Column(name = "visitor", nullable = false, unique = false)
	public int getVisitor() {
		return visitor;
	}

	public void setVisitor(int visitor) {
		this.visitor = visitor;
	}

	// @Id garantit que cet attribut n'est pas nullable et est unique.
	// @GeneratedValue permet de réaliser une auto-incrémentation à chaque instanciation, par conséquent il est importatn de l'initialiser à 0 dans le constructeur
	@Column
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
