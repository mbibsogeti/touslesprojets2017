package fr.ib.travel.rest.jersey;

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
private List<Excursion>liste;


public Excursions(){
	liste = new ArrayList<>();
	liste.add(new Excursion("Ciuba",6));
	liste.add(new Excursion("Uberlandia",9));
	liste.add(new Excursion("Curitiba",11));
	liste.add(new Excursion("Fortaleza",12));
	liste.add(new Excursion("Natal",7));
	liste.add(new Excursion("Porto Alegre",8));
	liste.add(new Excursion("Recife",9));
	
}

@GET @Path("/list")
@Produces(MediaType.APPLICATION_JSON)
public List<Excursion> getList(){ // ou getliste() ou autre chose car choix nom arbitraire
	return liste;
}	

	
@GET
@Produces(MediaType.TEXT_PLAIN)
	public String getDocumentation() {
	return "Ceci est l'API des excursions au Brésil \n Adresses:\n -\n -\n -\n";
	}

@GET @Path("/bestvalue")
@Produces(MediaType.APPLICATION_JSON)
public Excursion getBestValue(@HeaderParam("User-Agent") String va){
	
	if(va.toLowerCase().contains("chrome"))
		return new Excursion("Ciuba",8);	
	return new Excursion("Ciuba",6);
	
	   }
	


	
@GET @Path("/bynumber/{no}")// "no" (arbitraire) fait comprendre à l'url que le chiffre saisi correspond à n	
@Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("no") int n){//@PathParam vient annoter l'entier n
	return liste.get(n);	
}

@DELETE @Path("/bynumber/{no}")
public void deleteByNumber (@PathParam("no") int n){//on ne peut pas le tester cette methode sur l'url
liste.remove(n);

}


}
