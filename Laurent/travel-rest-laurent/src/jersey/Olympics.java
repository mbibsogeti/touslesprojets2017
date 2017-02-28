package jersey;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/olympics") //Indication de chemin d'accès à cette servlet
public class Olympics {

	@GET //Indique la fct à appeler pour une utilisation de la méthode get lors de l'utilisation de l'url indiqué dans le path
	@Produces(MediaType.TEXT_PLAIN) //Définition du format de ce que la méthode produit au niveau de la page web (un texte de base)
	//@Consumes //Definition du format de ce que la méthode consume
	public String getInfos(){
		return "Plus de voyages de prévu pour les jeux olympiques au Brésil !";
	}
	
	
}
