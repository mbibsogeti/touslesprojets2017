package fr.ib.travel.jersey;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
		l.add(new Excursion("xx", 5));
		l.add(new Excursion("Rio", 7));
		l.add(new Excursion("yy", 4));
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList1() {
		return l;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Decription() {
		return "Ceci est l'API des excursions au Brésil\n" + "Adresses :\n" + "- plage\n" + "- Carnaval\n"
				+ "- Jungle\n";
	}

	@GET
	@Path("/bestValue")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@HeaderParam("User-Agent") String va) {
		if (va.toLowerCase().contains("chrome"))
			return new Excursion ("Ciuaba", 8);
		return new Excursion("Ciuaba", 6);
	}

	@GET
	@Path("/bynumber/{no}")
	@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("no") int n) {
		return l.get(n);
	}

	@DELETE
	@Path("/bynumber/{no}")
	public Excursion deleteByNumber(@PathParam("no") int n) {
		return l.remove(n);
	}

}
