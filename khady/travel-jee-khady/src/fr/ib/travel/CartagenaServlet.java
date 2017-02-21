package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class CartagenaServlet extends HttpServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");		
		
		
		TreeMap<String,String> descs= new TreeMap<>();
		
		descs.put("Barranquilla", "Trekk de 4 jours...");
		descs.put("Bogota", "Train de 5 jours...");
		descs.put("Cali", "Car de 8 jours...");
		descs.put("San Andrès", "Croisière de 10 jours...");
		
		res.setCharacterEncoding("utf-8");	
		res.setContentType("text/html");
			
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='utf-8'>");
		out.write("<title>Voyage...</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>COLOMBIE</h1>");
	 	out.write("<p>Cartagena !</p>");
		out.write("</body>");
		out.write("</html>");
				
		for(String k : descs.keySet())
			out.write("<p><a href='cartagena?city="+k+"'>"+k+"</a></p>");
		if(req.getParameter("city")!=null)
			out.write(descs.get(req.getParameter("city")));
		
		
		
		
		
		
		
		

	}

	
	
	
}
