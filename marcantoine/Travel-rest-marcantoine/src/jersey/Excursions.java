package jersey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/excursions")
public class Excursions {

	// création d'un attribut : liste d'instances de la classe Excursion
	// c'est une interface
	private List<Excursion> l;

	// création d'un constructeur créant une liste et y entrant des valeurs
	// ArrayList est un type de liste. Ici, on réalise une implémentation de
	// cette interface
	public Excursions() {
		l = new ArrayList<>();
		l.add(new Excursion("Ciuba", 7));
		l.add(new Excursion("Uberlandia", 8));
		l.add(new Excursion("Curitiba", 4));
		l.add(new Excursion("Tchoulala",10));
		l.add(new Excursion("Youille",2));
		l.add(new Excursion("Dihossemiyo",8));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos() {
		return ("This is the application for trips around Brazil\nURL:");
	}

	// production de JSON
	@GET
	@Path("/bestvalue")
	@Produces(MediaType.APPLICATION_JSON)
	// méthode renvoyant un objet Excursion
	public Excursion getBestValue(@Context HttpServletRequest req) {
		if (req.getHeader("User-Agent").contains("Chrome")) {
			return new Excursion("Ciuba", 8);
		} else {
			return new Excursion("Ciuba", 6);
		}
	}

	// On crée une sous-adresse avec une annotation @Path supplémentaire
	// Ici, il s'agit de créer une fonction retournant une liste.
	// En JSON, une liste est transformée en tableau d'objets
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList() {
		return l;
	}

	// reçoit numéro élément dans la liste et retourne élément en question
	// {} permettent de faire varier un numéro, syntaxe spécifique aux URL
	// de JAX-RS en général. On ajoute une annotation @PathParam pour lier n à
	// l'URL
	@GET
	@Path("/bynumber/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("n") int n) {
		return l.get(n);
	}
	
	@DELETE
	@Path("/bynumber/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteByNumber(@PathParam("n") int n) {
		l.remove(n);
	}
}
