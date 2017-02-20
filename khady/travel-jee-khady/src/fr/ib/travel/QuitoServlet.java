package fr.ib.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override /*
				 * est une annotation pour nous prévenir en cas d'erreur par
				 * rapport à la class mère HttpServlet
				 */
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("");
		res.setCharacterEncoding("utf-8");
		
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
		
		int avion = 1060;
		double nuite = 32.8;
		
		out.write("<table>");
		out.write("<tr>");
		out.write("<th>Jours</th>");
		out.write("<th>TTC</th>");
		out.write("</tr>");		
		
		for (int i = 5; i <= 25; i += 5) {
			out.write("<tr><th>"+(i)+"</th>"+"<td>"+ String.format("%.2f",((i*nuite)+avion))
			+" €"+ "</td>");				
		}
		out.write("</table>");	
}

}
