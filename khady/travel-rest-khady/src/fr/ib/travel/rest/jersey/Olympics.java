package fr.ib.travel.rest.jersey;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/olympics")
public class Olympics {

	@GET
	//@Consumes: ne consomme rien mais produit qque chose sous forme texte
	@Produces(MediaType.TEXT_PLAIN)// ou ("text/plain")

	public String getInfos() {

		return "Plus de voyages disponibles pour les J.O";

	}

}
