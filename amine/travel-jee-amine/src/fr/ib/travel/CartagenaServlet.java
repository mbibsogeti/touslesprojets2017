/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.TreeMap;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class CartagenaServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		/* Dictionnaire de données */
		TreeMap<String, String> descs = new TreeMap<>(); // dictionnaire de
															// valeurs
		descs.put("Barranquilla", "Trekk de 4 jours ....");
		descs.put("Bogota", "Train....");
		descs.put("Cali", "Car....");
		descs.put("San Andrès", "Croisière....");

		/* Mon HTML Cartagena */
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Agence de voyage: Cartagena</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Carthagène des Indes</h1>");
		out.write(
				"<section><p>Carthagène des Indes (en espagnol : Cartagena de Indias) est une ville de Colombie et la capitale du département de Bolívar. Ville portuaire, elle est située sur la côte septentrionale du pays, au bord de la mer des Caraïbes (ou mer des Antilles), à environ 120 km de Barranquilla. Sa population s'élève à 1 075 000 habitants.</p>");
		out.write("</section>");
		for (String k : descs.keySet())
			// out.write(k);
			// lien qui renvoi dans la même page, exemple pour faire des liens
			out.write("<p><a href='cartagena?city=" + k + "'>" + k + "</a></p>");
			//pour récupérer un paramètre du dictionnaire
		if(req.getParameter("city")!=null && descs.containsKey(req.getParameter("city")))
			out.write("<p>"+descs.get(req.getParameter("city"))+"</p>");
		out.write("</body>");
		out.write("</html>");
	}
}
