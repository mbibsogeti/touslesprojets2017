/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class MaracaiboServlet extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();

		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Voyage: Maracaibo</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Maracaïbo</h1>");
		out.write(
				"<section><p>Maracaibo ou Maracaïbo est une ville du Venezuela et la capitale de l'État de Zulia. Elle est située à l'entrée du lac Maracaibo, à 514 km à l'ouest de Caracas. La population de son aire urbaine était estimée à 3 600 000 habitants en 2008. Maracaibo, dont l'économie repose sur l'exploitation du pétrole du lac Maracaibo, est la deuxième ville du Venezuela après la capitale.</p></section>");
		out.write("<section><h2>Insription</h2></section>");
		/*
		 * if (req.getParameter("tel") != null) {
		 * out.write("<p>Inscription reçue:" + req.getParameter("nom") +
		 * "</p>"); //out.write("<p>Inscription reçue:" +
		 * req.getParameter("tel") + "</p>");
		 * //out.write("<p>Inscription reçue:" + req.getParameter("nb") +
		 * "</p>"); }
		 */
		/* vérification que le formulaire est bien rempli */

		if (req.getParameter("tel") != null) {
			if (!(req.getParameter("nom").equals("")))
				out.write("<p>Iscription reçue: " + req.getParameter("nom") + "</p>");
			else {
				out.write("<p> ERREUR!</p>");

			}

		}
		out.write("<form action='?' method='post'>");
		/*-------------------------------*/
		String nom = "";
		if (req.getParameter("nom") != null) {
			nom = req.getParameter("nom");
			out.write("<p><label> Nom: <input type='name' name='nom' value='" + nom + "'/></label></p>");
		} else
			out.write("<p><label> Nom: <input type='name' name='nom'/></label></p>");

		/*---------------------------*/
		String tel = "";
		if (req.getParameter("tel") != null) {
			tel = req.getParameter("tel");
			out.write("<p><label> Téléphone: <input type='tel'  name='tel' value='" + tel + "'/></label></p>");
		} else
			out.write("<p><label> Téléphone: <input type='tel'  name='tel' value='" + tel + "'/></label></p>");
		/*--------------------------*/
		String nb = "";
		if (req.getParameter("nb") != null) {
			nb = req.getParameter("nb");
			out.write("<p><label> Voyageurs: <input type='number'  name='nb'value='" + nb + "'/></label></p>");
		} else
			out.write("<p><label> Voyageurs: <input type='number'  name='nb'value='" + nb + "'/></label></p>");


		out.write("<p><label><input type='submit'/></label></p>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
}
