package jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

// Si l'utilisateur rentre une url finissant par olympics, on passera par cette classe
// On pourrait mettre ce que l'on veut comme path, pas forcément olympics, et cela
// mènerait vers Olympics.java
@Path("/olympics")
public class Olympics {

	// On peut utiliser des méthodes @Consumes ou @Produces pour dire ce que la
	// méthode
	// consomme ou produit
	// NB : on peut les écrire chacune sur sa ligne ou les unes à côté des
	// autres. On pourrait écrire @Produces(MediaType.TEXT_PLAIN)
	// Ce qui est contenu entre parenthèses pour @Produces est lu par le
	// navigateur -> lui donne des infos
	@GET
	@Produces("text/plain")
	public String getInfos() {
		return "More trips on our website";
	}
}