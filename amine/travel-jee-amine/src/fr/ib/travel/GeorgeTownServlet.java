/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author ib
 *
 */
public class GeorgeTownServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			// lire la data source DS
			DataSource ds = (DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
			res.setContentType("text/html");
			res.setCharacterEncoding("utf-8");
			Writer out = res.getWriter();
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset='UTF-8'>");
			out.write("<title>George Town</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1>George Town</h1>");
			out.write("<p><a href='index.html'>Retour</a></p>");
			out.write("</body>");
			out.write("</html>");
		} catch (Exception ex) {
			log("Erreur!", ex);
		}
	}

}
