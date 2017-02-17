package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class maracaiboServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html"); // respecte la norme mime
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); // déclare les sortie
		String name = "";
		String tel = "";
		String nb = "";
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>voyage en amerique latine</title>");
		out.write("</head>");
		out.write("<body>");

		out.write("<h1>Agence de voyage amerique du sud</h1>");
		out.write("<h2>formulaire Maraciabo</h2>");
		out.write("<form action='?' method='post'>");//on peut mettre get ppur que les truc apparaise en clair sur la barre d'adress , par contre caché ou en clair on peut tjr les utilisé
		if (req.getParameter("Nom") != null)
			name = req.getParameter("Nom");
		out.write("<p><label>Nom:<input type='text' name='Nom' value= '" + name + "'></label></p>");

		if (req.getParameter("tel") != null)
			tel = req.getParameter("tel");
		out.write("<p><label>tel:<input type='text' name='tel' value= '" + tel + "'></label></p>");
		
		if (req.getParameter("number") != null)
			nb = req.getParameter("number");

		out.write("<p><label>number<input type='number' name='number' value= '" + nb + "'></label></p>");

		out.write("<p><label>tvoyage:<input type='submit' value='go'></label></p>");
		out.write("</form>");

		if (req.getParameter("tel").trim().equals("") && req.getParameter("Nom").trim().equals(""))

			out.write("<p>Inscription reçue incorrecte </p>");

		else if (!req.getParameter("tel").trim().equals("") ^ !req.getParameter("Nom").trim().equals(""))
			out.write("<p>Inscription reçue incomplete</p>");
		else
			out.write("<p>Inscription reçue ok</p>");

		// super.service(arg0, arg1);
	}

}
