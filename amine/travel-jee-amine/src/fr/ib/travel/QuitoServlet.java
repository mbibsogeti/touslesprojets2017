/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class QuitoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); // nous permet d'écrire
		// out.write("Quito!");//affiche Quito! sur le navigateur
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Agence de voyage: Amérique Latine</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Agence: Destination Quito</h1>");
		out.write("	<p>Bienvenue dans notre agence de voyage. Notre centre: 400m <sup>2</sup></p>");
		out.write("<table border='1'><tr><th>Jours</th><th>TTC</th></tr>");
		final int avion = 1060;
		final double  hotel = 32.80;
		for (int day = 5; day <= 25; day += 5) {
			double ttc = avion + hotel * (day-1);
			out.write("<tr><td>" + day + "</td><td>" +String.format("%.2f", ttc)+ "</td></tr>");
		}
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");

	}
}
