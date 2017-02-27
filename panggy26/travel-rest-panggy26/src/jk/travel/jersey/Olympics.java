package jk.travel.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Class Plain Old Java Object (POJO) : normale, n'héritant de rien

// Quand l'utilisateur rentre une adresse qui finit , il arrive sur cette page. Le web.xml pointe au bon endroit.
@Path("/olympics")
public class Olympics {

	// S'exécute quand l'utilisateur fait une requête GET (comportement par défaut du navigateur)
	@GET
	// @Produces : définit ce que la méthode produit (ici, du texte simple). @Consumes : définit le format du corps de requête.
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos() {
		return "Plus de voyage !";
	} // end getInfos method
} // end Olympics class