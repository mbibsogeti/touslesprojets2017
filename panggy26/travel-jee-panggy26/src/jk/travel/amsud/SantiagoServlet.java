package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;

public class SantiagoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		out.write("<h1>¡Bienvenido a Chile!</h1>");
		out.write("</div>");
		out.write("</body>");

		// SESSION //
		HttpSession s = req.getSession();
		// Version moi
		// La 1ère fois : Bienvenue
		if(s.getAttribute("nbCo") == null) {
			s.setAttribute("nbCo", 1);
			out.write("<p>Bienvenue !</p>");
		}
		// De 2 à 4 : Bienvenue de nouveau
		else {
			s.setAttribute("nbCo", (Integer)s.getAttribute("nbCo") + 1);
			if((Integer)s.getAttribute("nbCo") < 5) {
				out.write("<p>Bienvenue de nouveau !</p>");
			}
		}
		// Version Mickaël
//		int n = 1;
// 		// La première fois, on ne passe pas par ici car null
//		if(s.getAttribute("nbCo") != null) {
//			n = (Integer)s.getAttribute("nbCo");
//		}
//		s.setAttribute("nbCo", n + 1);
//		if(n == 1) {
//			out.write("<p>Bienvenue !</p>");
//		}
//		else if(n < 5) {
//			out.write("<p>Bienvenue à tous !</p>");
//		}
		
		// COOKIE //
		// Écriture
		Cookie c = new Cookie("last", URLEncoder.encode(new Date().toString(), "UTF-8"));
		// Si on réactualise la page après 10 secondes, le cookie est effacé
		c.setMaxAge(10);
		res.addCookie(c);
		
		// Lecture
		Cookie[] cs = req.getCookies();
		// S'il y a des cookies, on les parcourt, s'il y en a un du nom de 'last', on affiche sa valeur
		if(cs != null) {
			for(Cookie i : cs) {
				if(i.getName().equals("last")) {
					out.write(i.getValue());
				}
			}
		}
	}
}