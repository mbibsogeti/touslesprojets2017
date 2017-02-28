package fr.obodrel.travel;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/olympics")
public class Olympics {
	/*@Consumes */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInformations() {
		return "No more travel available, Olympics Games have ended";
	}
}
