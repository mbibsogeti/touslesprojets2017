package fr.belto.travel.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/excursions")
public class Excursions {
	// TODO Auto-generated method stub
	@GET
	@Produces("text/plain")
	public String getInfos() {
		return "Ceci est la liste des excursions disponible pour le Brésil";
	}

	private List<Excursion> l;
	public Excursions() {
		l = new ArrayList<>();
		l.add(new Excursion("Janeiro", 10));
		l.add(new Excursion("Brazilia", 9));
		l.add(new Excursion("Porto Alegre", 8));
		l.add(new Excursion("Sao Paolo", 9));
		l.add(new Excursion("Fortaleza", 4));
		l.add(new Excursion("Belem", 7));
	}
@GET @Path ("/list")  // rajouter une adresse à la suite de(olympics) quand on appelle en plus,
@Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList() {// réalisation d'une liste d'escursion
		return l;
	}
@GET @Path ("/bynumber/{no}") // @PathParam("no") utilisation d'un numero pour trouver un ville dans la liste
@Produces(MediaType.APPLICATION_JSON)
public Excursion getByNumber(@PathParam("no") int n){// pathparam relie {no} à "no"et int n est le type
	return l.get(n);
}
// on peut faire un delete, Le problème on ne peut pas le tester dans le navigateur!
@DELETE @Path("/bynumber/{no}")
public void deleteByNumber(@PathParam("no") int m){
	l.remove(m);
}

	@GET
	@Path("/bestvalue")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@HeaderParam("User-Agent") String ua) {// lire dans l'en-tête avec header param
		if (ua.toLowerCase().contains("chrome"))// comparer le navigateur utilisé avec chrome!
			return new Excursion("Ciuaba", 8);	
		return new Excursion("Ciuaba", 6);// sinon voila ce quil faut faire
	}

}
