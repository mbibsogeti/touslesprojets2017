/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ib
 *
 */
public class LimaServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//log("doGet"); //ajoute un message dans le log dans la console d'eclipse
		log("doGet"+this);
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Pérou: Lima</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Destination Lima</h1>");
		out.write("<section>");
	//	out.write("<p> Pas de voyages actuellement</p>");
		out.write(getInitParameter("text"));
		out.write("</body>");
		out.write("</html>");

	}
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		log("init");
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log("dest");
		super.destroy();
	}

	

}
