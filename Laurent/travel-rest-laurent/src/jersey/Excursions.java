package jersey;

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

@Path("/excursions")
public class Excursions {

	private List<Excursion> lExcursion;
	
	
	public Excursions() {
		super();
		this.lExcursion = new ArrayList<Excursion>();
		lExcursion.add(new Excursion("Brasilia", 2));
		lExcursion.add(new Excursion("Natal", 5));
		lExcursion.add(new Excursion("Osasco", 3));
		lExcursion.add(new Excursion("Londrina", 4));
		lExcursion.add(new Excursion("Santos", 6));
		lExcursion.add(new Excursion("Olinda", 1));
		lExcursion.add(new Excursion("Serra", 7));
		lExcursion.add(new Excursion("Bauru", 8));
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String index(){
		String txt="";
		txt+="Ceci est l'API des excursions au Brésil."+"\n";
		txt+="Adresses :"+"\n";
		txt+="test"+"\n";
		txt+=""+"\n";
		txt+=""+"\n";
		txt+=""+"\n";
		txt+=""+"\n";
		return txt;
	}
	
	@GET @Path("/list") @Produces(MediaType.APPLICATION_JSON)
	public List<Excursion> getList(){
		return lExcursion;
	}
	
	@GET @Path("/bynumber/{No}") @Produces(MediaType.APPLICATION_JSON)
	public Excursion getByNumber(@PathParam("No") int n){
		return lExcursion.get(n);
	}

	@DELETE @Path("/bynumber/{No}")
	public void deleteByNumber(@PathParam("No") int n){
		lExcursion.remove(n);
	}
	
	@Path("/bestvalue/{No}") @GET @Produces(MediaType.APPLICATION_JSON)
	public Excursion getBestValue(@Context HttpServletResponse res, @HeaderParam("User-Agent") String Us, @PathParam("No") int excursion){
		if(Us.contains("Chrome")){
			String tempLocation=lExcursion.get(excursion).getLocation();
			int tempDanger=lExcursion.get(excursion).getDangerosity();
			return new Excursion(tempLocation, tempDanger+2);
		}else{
			return lExcursion.get(excursion);
		}
		
	}
	
}
