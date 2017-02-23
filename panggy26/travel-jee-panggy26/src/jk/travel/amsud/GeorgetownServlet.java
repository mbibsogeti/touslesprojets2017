package jk.travel.amsud;

import java.io.IOException;
import java.io.Writer;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgetownServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
			// Message dans la console de Tomcat
			log("Ca marche !");	
		} // end try
		catch(Exception ex) {
			log("Erreur !", ex);	
		} // end catch
		
		// Pour fixer le type de sortie (norme MIME)
		res.setContentType("text/html");
		// Pour fixer l'encodage de Tomcat
		res.setCharacterEncoding("UTF-8");
		// Obtenir la main sur un flux de sortie déjà préparé
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<head>");
		out.write("<meta charset=\"UTF-8\">");
		out.write("</head>");
		out.write("<body>");
		out.write("<div>");
		out.write("<h1>Welcome to Guyana !</h1>");
		out.write("</div>");
		out.write("</body>");
	} // end méthode doGet
}