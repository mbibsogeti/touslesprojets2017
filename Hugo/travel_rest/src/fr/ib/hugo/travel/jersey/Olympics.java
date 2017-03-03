package fr.ib.hugo.travel.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// quand on va à l'adresse /olympics
@Path("/olympics")
public class Olympics {

	// avec la méthode GET, getInfos s'exécute et renvoie return
	@GET
	@Consumes
	// lorsque le code est exécuté, il l'est de la façon
	// indiquée par @Produces
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos() {
		return "Ya no hay viajes para los juegos";
	}

}
