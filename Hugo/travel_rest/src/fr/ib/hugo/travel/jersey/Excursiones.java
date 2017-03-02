// Service web Representation State Transfert (REST) avec la JAX-RS API Jersey, pour renvoyer un flux de données en format JSON

package fr.ib.hugo.travel.jersey;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/excursiones")
public class Excursiones {

	private List<Excursion> l;

	public Excursiones() {
		l = new ArrayList<>();
		l.add(new Excursion("Uberlandia", 3));
		l.add(new Excursion("Curitiba", 10));
		l.add(new Excursion("Sao Caetano", 5));
		l.add(new Excursion("Porto Alegre", 2));
	}

	@GET
	@Path("/bynumber/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("no") int n) {
		return l.get(n);
	}

	@DELETE
	@Path("/bynumber/{no}")
	public void deleteByNumber(@PathParam("no") int n) {
		l.remove(n);
	}

	@GET
	public String getInfos() {

		return "Texto Bruto";

	}

	@GET
	@Path("/lista")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList(@Context HttpServletResponse res, @HeaderParam("AcceptLanguage") String la) {
		return l;
	}

	@GET
	@Path("/value")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@HeaderParam("User-Agent") String ua) {
		if (ua.toLowerCase().contains("chrome"))
			return new Excursion("Ciuiba", 8);
		else {
			return new Excursion("Ciuiba", 6);
		}
	}

}
