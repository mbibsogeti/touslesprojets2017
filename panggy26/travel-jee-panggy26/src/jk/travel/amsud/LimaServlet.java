package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet {

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
		out.write("<h1>¡Bienvenido a Perú!</h1>");
		// Récupérer une option écrite dans web.xml
		out.write(getInitParameter("text"));
		out.write("</div>");
		out.write("</body>");
		// Affichage dans la console d'Eclipse
		log("Je suis dans la méthode LimaServlet.doGet");
		// En appuyant sur F5, on se rend compte que c'est toujours la même Servlet qui est utilisée
		log("Affichage de this : " + this);
	}
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Je suis dans la méthode Lima.Servlet.init");
	}
	@Override
	public void destroy() {
		// On fait notre travail
		log("Je suis dans la méthode Lima.Servlet.destroy");
		super.destroy();
	}
}