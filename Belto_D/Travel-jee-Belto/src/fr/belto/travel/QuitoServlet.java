package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Voyages en amérique du sud</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Voyages en amérique du sud</h1>");
		out.write("<h2>Vive les vacances</h2>");
		out.write(
				"<p> Bienvenue à notre agence de voyage. Nous disposons d'un centre de: 400 m<sup>2</sup> pour vous acceuillir.  Nous sommes ouvert de 10h à 19h non stop, tous les jours de la semaine sauf dimanche. Nous vous proposons un nombre importants de voyage en amérique du sud pour tous les budgets!</p> ");
		out.write("<table>");
		for (int i = 5; i <= 25; i += 5)
			out.write("<tr><th>" + "Pour "+i+" Jours, " + "</th>" + "<td>"+ "le prix a payé est: " + String.format("%.2f", 1060 + (i - 1) * 32.80)+"€" + " minimum"+ "</td></tr>");
		out.write("</table>");

	}

}
