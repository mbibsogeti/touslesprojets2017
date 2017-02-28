package jk.travel.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// Class Plain Old Java Object (POJO) : normale, n'héritant de rien
// Quand l'utilisateur rentre une adresse qui finit , il arrive sur cette page.
@Path("/excursions")
public class Excursions {

	// ATTRIBUTS //
	private List<Excursion> _listeExcursions;

	// MÉTHODES //
	/**
	 * Construction de la liste des excursions.
	 */
	public Excursions() {
		_listeExcursions = new ArrayList<>();
		_listeExcursions.add(new Excursion("Cuiabá", 6));
		_listeExcursions.add(new Excursion("João Pessoa", 8));
		_listeExcursions.add(new Excursion("Aracaju", 4));
		_listeExcursions.add(new Excursion("Macapá", 5));
		_listeExcursions.add(new Excursion("Goiânia", 9));
	} // end Excursions method

	@GET
	// @Produces : définit ce que la méthode produit (ici, du texte simple). @Consumes : définit le format du corps de requête.
	@Produces(MediaType.TEXT_PLAIN)
	public String getInfos() {
		return "Ceci est l'API des excursions au Brésil !\n Adresses : ";
	} // end getInfos method

	/**
	 * Renvoie la liste des excursions au format JSON.
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)

	// @Context HttpServletResponse res
	// @HeaderParam //: paramètre de requête définissant la requête de l'attribut

	public List<Excursion> getList() {

		return _listeExcursions;
	} // end getList method

	/**
	 * Si le navigateur est Chrome, la dangerosité est augmentée de 2.
	 */
	@GET
	@Path("/bestvalue")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@HeaderParam("User-Agent") String userAgent) {
	// Version MOI
//	public Excursion getBestValue(@Context HttpServletRequest req) {
//		String userAgent = req.getHeader("User-Agent");
		if (userAgent.toLowerCase().contains("chrome")) {
			return new Excursion("Cuiabá", 6 + 2);
		}
		return new Excursion("Cuiabá", 6);
	} // end getBestValue method

	@GET
	@Path("/bynumber/{num}")
	@Produces(MediaType.APPLICATION_JSON)
	// @PathParam("num") : Annote un argument de fonction pour signifier qu'il correspond au num de l'URL
	public Excursion getByNumber(@PathParam("num") int ind) {
		return _listeExcursions.get(ind);
	}

	@DELETE
	@Path("/bynumber/{num}")
	// @PathParam("num") : Annote un argument de fonction pour signifier qu'il correspond au num de l'URL
	public void deleteByNumber(@PathParam("num") int ind) {
		_listeExcursions.remove(ind);
	} // end deleteByNumber method
} // end Excursions class