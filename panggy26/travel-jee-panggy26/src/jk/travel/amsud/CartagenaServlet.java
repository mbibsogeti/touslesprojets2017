package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		HashMap<String, String> descs = new HashMap<>();
		// la méthode put peut ajouter ou écraser si la clef existe déjà
		descs.put("Barranquilla", "Trekk de 4 jours");
		descs.put("Bogotá", "Train");
		descs.put("Cali", "Visite en car");
		descs.put("San Andrés", "Croisière");
		descs.put("Medellín", "Football");
		// Pour fixer le type de sortie (norme MIME)
		res.setContentType("text/html");
		// Pour fixer l'encodage de Tomcat
		res.setCharacterEncoding("UTF-8");
		// Obtenir la main sur un flux de sortie déjà préparé
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div class='container'>");
		out.write("<h1>¡Bienvenido a Carthagène des Indes!</h1>");
		for (String k : descs.keySet()) {
			// Moyen d'appeler une page et de lui envoyer des informations
			// Le ? sépare le nom de la page (gauche) du paramètre city, de nom arbitraire (droite)
			// Le premier k est celui de la barre d'adresse, le second écrit les clefs sur la page
			out.write("<p><a href='cartagena?city=" + k + "'>" + k + "</a></p>");
		}
		// Si on a cliqué sur un lien, on reste sur la même page mais la valeur du paramètre de city="" s'ajoute dans l'URL
		if (req.getParameter("city") != null) {
			// Écrit la valeur correspondant à la clef dans le dictionnaire descs
			out.write(descs.get(req.getParameter("city")));
		}
		out.write("</div>");
		out.write("</body>");
		// On parcourt les clefs du dictionnaire

	}
	
}