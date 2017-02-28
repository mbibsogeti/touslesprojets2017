package fr.obodrel.travel;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("/trips")
public class TripHolder {
	private ArrayList<Trip> allTripsAvailable;
	
	public TripHolder() {
		allTripsAvailable = new ArrayList<Trip>();

		allTripsAvailable.add(new Trip("Paraná",0));
		allTripsAvailable.add(new Trip("Santa Catarina",1));
		allTripsAvailable.add(new Trip("Rio Grande do Sul",2));
		allTripsAvailable.add(new Trip("Espírito Santo",3));
		allTripsAvailable.add(new Trip("Minas Gerais",4));
		allTripsAvailable.add(new Trip("Rio de Janeiro",5));
		allTripsAvailable.add(new Trip("São Paulo",6));
		allTripsAvailable.add(new Trip("Sergipe",7));
		allTripsAvailable.add(new Trip("Rio Grande do Norte",8));
		allTripsAvailable.add(new Trip("Piauí",9));
	}
	
	/*@Consumes*/
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getInformations() {
		String textOut = "";

		textOut += "This is the Brasil's trips API.\n";
		textOut += "Following destinations are available :\n";
		textOut += "\t- n°1 :\n";
		textOut += "\t- n°2 :\n";
		textOut += "\t- n°3 :\n";
		
		return textOut;
	}
	
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Trip> getList() {
		return allTripsAvailable;
	}
	
	@GET
	@Path("/bestvalue")
	@Produces(MediaType.APPLICATION_JSON)
	public Trip getBestValue(@Context HttpServletRequest req) {
		int currDangerosity = 6;
		Enumeration<String> headerNames = req.getHeaderNames();
		while(headerNames.hasMoreElements()) {
			String currentHeaderContent = req.getHeader(headerNames.nextElement());
			if(currentHeaderContent.toLowerCase().contains("chrome".toLowerCase())) {
				currDangerosity += 2;
				break;
			}
		}	
		return new Trip("Ciuaba",currDangerosity);
	}
	/*public Trip getBestValue(@HeaderParam("UserAgent") Stirng userAgent) {
		int currDangerosity = 6;
		
		if(userAgent.toLowerCase().contains("chrome".toLowerCase())) {
			currDangerosity += 2;
			break;
		}	
		return new Trip("Ciuaba",currDangerosity);
	}*/
	
	@GET
	@Path("/list/{selectedTrip}")
	@Produces(MediaType.APPLICATION_JSON)
	public Trip getByNumber(@PathParam("selectedTrip")int selectedTrip) {
		return allTripsAvailable.get(selectedTrip);
	}
	
	@DELETE
	@Path("/list/{selectedTrip}")
	public void deleteByNumber(@PathParam("selectedTrip")int selectedTrip) {
		System.out.println("TripHoldern deleteByNumber, selectedTrip = "+selectedTrip+", size = "+allTripsAvailable.size());
		allTripsAvailable.remove(selectedTrip);
		System.out.println("TripHoldern deleteByNumber, selectedTrip = "+selectedTrip+", size = "+allTripsAvailable.size());
	}
}

