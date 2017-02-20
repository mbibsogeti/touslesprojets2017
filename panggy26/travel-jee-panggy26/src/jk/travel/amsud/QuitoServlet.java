package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {
	
	@Override
	// req : request, res : response
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Pour fixer le type de sortie (norme MIME)
		res.setContentType("text/html");
		// Pour fixer l'encodage de Tomcat
		res.setCharacterEncoding("UTF-8");
		// Obtenir la main sur un flux de sortie déjà préparé
		Writer out = res.getWriter();
		// Code HTML écrit ligne par ligne !!!
		out.write("<!DOCTYPE html>");
		out.write("<head>");
		// Échappement des guillemets
		out.write("<meta charset=\"UTF-8\">");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>¡Bienvenido al Ecuador!</h1>");
		out.write("<p>Voici un paragraphe fort instructif.</p>");
		out.write("</body>");
		/////////////////////////////////////////////////////////////////////////////////
		// Tableau des prix pour 5,10,15,20,25 jours avec avion 1060€ et nuitée 32.80€ //
		/////////////////////////////////////////////////////////////////////////////////
		out.write("<table class='table'>");
		out.write("");
		out.write("<th>Jours</th><th>Prix TTC</th>");
		// BOUCLE MOI //
//		for (int i = 5; i <= 5 * 5; i += 5) {
//			double prixTotal = 1060 + (i - 1) * 32.8;
//		out.write("<tr><td>" + i + "</td>" + "<td>" + prixTotal + " €</td>");
//		}
		// BOUCLE MICKAËL //
		for (int i = 5; i <= 5 * 5; i += 5) {
			out.write("<tr><td>" + i + "</td>" + "<td>" + String.format("%.2f", 1060 + (i - 1) * 32.80) + " €</td>");
		}
		out.write("</table>");
	}

}