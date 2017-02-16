package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override /* est une annotation pour nous prévenir en cas d'erreur par rapport à la class mère HttpServlet */
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
 res.setContentType("text/html");	
 Writer out = res.getWriter();
 out.write("<!DOCTYPE html>");
 out.write("<html>");
 out.write("<head>");
 out.write("<meta charset='utf-8'>");
 out.write("<title>Voyage...</title>");
 out.write("</head>");
 out.write("<body>");
 out.write("<h1>AMERIQUE DU SUD</h1>");
 out.write("<p>Quito !</p>");
 out.write("</body>");
 out.write("</html>");
	}

}
