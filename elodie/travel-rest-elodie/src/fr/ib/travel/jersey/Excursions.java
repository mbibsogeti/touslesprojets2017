package fr.ib.travel.jersey;




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

@Path ("/excursions")
public class Excursions {
	
	private List<Excursion> l;
	
	public Excursions(){
		l=new ArrayList<>();
		l.add(new Excursion("Rio", 4));
		l.add(new Excursion("Brazil", 6));	
	}
	
	@GET @Produces(MediaType.TEXT_PLAIN) 
	public String getExcursion(@Context HttpServletResponse res){
		res.setCharacterEncoding("UTF-8");
		String str = "Ceci est l'API des excursions au Brésil \nAdresses:\n-\n-\n-\n";
		return str;
	}
	
	@GET @Path("/list") @Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList(){
		return l;
	}
	
	
	@GET @Path("/bestvalue") @Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@HeaderParam("User-Agent") String navig){
		if (navig.contains("Chrome")){
			return new Excursion("Ciuaba", 8);
		}
		return new Excursion("Ciuaba", 6);
	}
	
	@GET @Path("/bynumber/{n}") @Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam ("n")  int n){
		return l.get(n-1);
	}
	
	@DELETE @Path("/bynumber/{n}") @Produces(MediaType.APPLICATION_JSON)
	public void deletetByNumber(@PathParam ("n")  int n){
		l.remove(n-1);
	}
	
}
