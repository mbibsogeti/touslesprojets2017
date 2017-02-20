package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet {

	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		out.write("<h1>¡Bienvenido a Maracaibo!</h1>");
		// FORMULAIRE //
		// Avec un action='?', on revient sur la même page. Les données sont dans la barre d'adresse grâce à l'attribut name=""
		// Avec method='post', les paramètres n'apparaissent pas dans la barre d'adresse. Valeur par défaut : method='get'
		out.write("<form action='?' method='post'>");

		String name = "";
		String tel = "";
		String nb = ""; // Considérer un nombre complique le problème
		if (req.getParameter("Nom") != null) {
			name = req.getParameter("Nom");
		}
		out.write("<p><label>Nom : </label><input type='text' name='Nom' value='" + name + "'></p>");
		if (req.getParameter("Tel") != null) {
			tel = req.getParameter("Tel");
		}
		out.write("<p><label>Téléphone : </label><input type='tel' name='Tel' value='" + tel + "'></p>");
		if (req.getParameter("Nb") != null) {
			nb = req.getParameter("Nb");
		}
		out.write("<p><label>Voyageur(s) : </label><input type='number' name='Nb' value='" + nb + "'></p>");
		out.write("<p><input type='submit' value='Envoi'></p>");
		// Si on a rentré un Nom. Il est suffisant de tester un seul paramètre, car si on en a un, c'est qu'on les a tous !
		if (req.getParameter("Nom") != null && req.getParameter("Tel") != null && req.getParameter("Nb") != null) {
			// Cas valide : si nom, téléphone et nombre de voyageur(s) sont non vides ""
			if ((!req.getParameter("Nom").trim().equals("")) && (!req.getParameter("Tel").trim().equals(""))
					&& (!req.getParameter("Nb").trim().equals(""))) {
				out.write("<p>Inscription reçue pour " + req.getParameter("Nb") + " personne(s) au nom de " + req.getParameter("Nom")
						+ " de numéro de téléphone " + req.getParameter("Tel") + "</p>");
			} else { // Cas invalide : si un des 3 éléments est manquant
				out.write("<p>Formulaire invalide. Essayez encore !</p>");
			}
		}

		// FERMETURE DES BALISES //
		out.write("</div>");
		out.write("</body>");
	} // fin méthode Service

} // fin classe MaracaiboServlet