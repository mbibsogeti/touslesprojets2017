package jk.travel.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Class Plain Old Java Object (POJO) : normale, n'héritant de rien

// Quand l'utilisateur rentre une adresse qui finit , il arrive sur cette page.
@Path("/excursions")
public class Excursions {

	@GET
	// @Produces : définit ce que la méthode produit (ici, du texte simple). @Consumes : définit le format du corps de requête.
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos() {
		return "Ceci est l'API des excursions au Brésil !\n Adresses : ";
	} // end getInfos method
	
	@GET @Path("/list")
	public String getList() {
		return "(vide)";
	}
} // end Excursions class