package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HashMap<String,String> descs= new HashMap<>();// Dictionnaire dans le HTML (Clé, Valeur) les deux dans le type String
		descs.put("Barranquilla", "Trekk de 4 jours"); // clé "Barranquilla" et valeur "Trekk de 4 jours"
		descs.put("Bogota", "Train de 2 jours"); 
		descs.put("Cali", "Car en 5 jours");
		descs.put("San Andrès", "Croisiere");
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); 
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Bienvenue à Cartagena (ville de Colombie)</title>");
		out.write("<link rel='stylesheet' href='css/bootstap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Voyages en Cartagena</h1>");
		 for(String k: descs.keySet())// afficher que la clé comme un lien à l'écran
			 out.write("<p><a href='cartagena?city="+k+"'>"+k+"</a><p/>");
		// pour aller chercher la valeur quand l'utilisateur click, en utilisant city comme nom de paramètre
		if (req.getParameter("city")!=null && descs.containsKey(req.getParameter("city"))) // si le paramètre n'est pas nul et existe alors!!!
			out.write(descs.get(req.getParameter("city")));
		if (req.getParameter("city")!=null && ! descs.containsKey(req.getParameter("city"))) // Déclencher une exception
			throw new ServletException("Destination inconnue");
		          
		}
}
