// produces defini ce que la methode produit ; plain
// sc'est dfu tex brut , on peut mettree aussi
// mediatype.textplain quelque chose et consumer ce
// que ça consome et terme de forma du corp de
// requetes

package fr.ib.travel.jersey;

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

	private List<Excursion> l;

	public Excursions() {
		l = new ArrayList<>();
		l.add(new Excursion("ville dur", 10));
		l.add(new Excursion("ville soft", 1));
		l.add(new Excursion("ville au milieu", 5));
	}

	@GET
	@Produces("text/plain")
	public String getInfos() {
		return "ceci est L'api des excursions au brésil";
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON) // @produces indique qu'on produit du
											// jason !

	public List<Excursion> getList() { // liste d'excursion
		return l;

	}

@GET @Path("/bestvalue")
@Produces(MediaType.APPLICATION_JSON)
public Excursion getBestValues(@HeaderParam("user-Agent")String va){
	if(va.toLowerCase().contains("chrome"))
	return new Excursion("Cuiaba",8);
	return new Excursion("Cuiaba",8);
}

	@GET
	@Path("/bynumber/{n}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("n") int n) { // on peut aussi
															// mettre @ context
															// et @headerParam
															// ....getbynumber
															// nom arbitraire ,
															// on regarde des
															// excurtion (défini
															// dans la liste) et
															// on va=renvoyer
															// des excustion
		return l.get(n);
	}

	@DELETE
	@Path("/bynumber/{n}")

	public void deleteByNumber(@PathParam("n") int n) {
		l.remove(n);
	}

}
