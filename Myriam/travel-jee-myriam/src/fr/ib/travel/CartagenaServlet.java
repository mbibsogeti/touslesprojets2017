package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/HTML");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<h1>Bienvenue en Colombie</h1>");

		HashMap<String, String> dscs = new HashMap<>();
		dscs.put("Baranquilla", "Treck de 4 jours");
		dscs.put("Bogota", "train");
		dscs.put("Cali", "car");
		dscs.put("San Andres", "Croisiere");

		for (String k : dscs.keySet())
			out.write("<p><a href='cartagena?city=" + k + "'>" + k + "</a></p>");

		if (req.getParameter("city") != null && !dscs.containsKey(req.getParameter("city"))) {
			throw new ServletException("Destination Inconnue !");
		}

		if (req.getParameter("city") != null) {
			out.write(dscs.get(req.getParameter("city")));
		}

	}

}
