package fr.obodrel.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class CartagenaServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = null;
		HashMap<String,String> descs = new HashMap<String,String>();
		String destinationsList = "";

		String currCity = req.getParameter("city");
		
		descs.put("Barranquilla", "4 Days Trekk");
		descs.put("Bogo", "Train Trip");
		descs.put("Cali", "Bus Trip");
		descs.put("San Andres", "Cruise Trip"); 
		
		if(currCity != null && !descs.containsKey(currCity)) {
			throw new ServletException("Unknown destination!");
		}
		
		destinationsList +="\n\t\t<ul>";
		
		ArrayList<String> keySet = new ArrayList<String>(descs.keySet());

		Collections.sort(keySet, new Comparator<String>() {
			@Override
			public int compare(String arg0, String arg1) {
				int min = Math.min(arg0.length(), arg1.length());
				
				for(int i=0;i<min;i++) {
					if(arg0.toCharArray()[i]-arg1.toCharArray()[i] == 0) {
						continue;
					}
					return (arg0.toCharArray()[i]-arg1.toCharArray()[i]) / Math.abs(arg0.toCharArray()[i]-arg1.toCharArray()[i]);
				}
				return 0;
				
			}
	    });
		
		for(String key : keySet) {
			destinationsList += "\n\t\t\t<li><a href=\"?city="+key+"\">"+key+"</a></li>";
		}
		destinationsList +="\n\t\t</ul>";
		
		resp.setContentType("text/html;charset=UTF-8");

		outHtmlFile = resp.getWriter();
		
		outHtmlFile.print("<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Cartagena</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+ "\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+ "</h1>\n\t\t<nav class=\"col-xs-12\">\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../\">Home"
				+ "</a></li>\n\t\t\t\t<li><a href=\"../equator/quito\">Quito Travel</a></li>"
				+ "\n\t\t\t\t<li class=\"active\"><a href=\".\">Cartagena Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../venezuela/maracaibo\">Maracaibo Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../peru/lima\">Lima Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../chile/santiago\">Santiago Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../lapaz.jsp\">Lapaz Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../buenosaires.jsp\">Buenos Aires Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../asuncion.jsp\">Asuncion Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../montevideo\">Montevideo Travel</a></li>"
				+ "\n\t\t\t</ul>\n\t\t</nav>\n\t\t<h2>Welcome to Cartagena</h2>" + destinationsList);
		
		
		if(currCity != null && descs.containsKey(currCity)) {
			outHtmlFile.print("\n\t\t<p>Welcome to "+currCity+"!"+" You will do : "+descs.get(currCity)+"</p>");
		} else {
			outHtmlFile.print("\n\t\t<p>Welcome!</p>");
		}
		
		outHtmlFile.print("\n\t</div>\n</body>\n</html>");
	}

}
