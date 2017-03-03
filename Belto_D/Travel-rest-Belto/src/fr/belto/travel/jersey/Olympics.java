package fr.belto.travel.jersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
@Path("/olympics")
public class Olympics {
@GET @Produces("text/plain") // on dit que la methode produit du texte 
//(@consume= ce que l'on consome à la requette, on aurait pu mettre MediaType.TEXT_PLAIN qui sont réduit)
 public String getInfos(){
     return "Plus de voyages disponible";

}
}
