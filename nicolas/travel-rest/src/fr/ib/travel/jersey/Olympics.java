package fr.ib.travel.jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/olympics")
public class Olympics {
	
	@GET @Produces("text/plain")   //produces defini ce que la methode produit ; plain sc'est dfu tex brut , on peut mettree aussi mediatype.textplain quelque chose et consumer ce que ça consome et terme de forma du corp de requetes 
	public String getInfos(){
		return "plus ";
	}
		


}
