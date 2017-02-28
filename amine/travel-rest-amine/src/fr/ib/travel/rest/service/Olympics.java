package fr.ib.travel.rest.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/olympics")
public class Olympics {
	// annotation lu par Jersey
	@GET
	// @Produces("text/plain") ou---->
	@Produces(MediaType.TEXT_PLAIN) // affichage en mode brute sur le navigateur
	public String gettInfos() {
		return "Plus de voyages....";
	}

}