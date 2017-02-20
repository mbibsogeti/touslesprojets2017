package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8"); //en-tête HTTP
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>QUITO</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Quito!!!</h1>");
		out.write("<table>");
		out.write("<tr>");
		out.write("<th>Jours</th>");
		out.write("<th>TTC</th>");
		out.write("</tr>");
		
		for(int i=5;i<26;i+=5){
			int prixAvion=1060; 
			double prixNuite=32.80;
			double prixTotal = 0;
			prixTotal = prixAvion+(prixNuite*i);
			String index = String.valueOf(i);
			String tot =  String.valueOf(prixTotal);
			out.write("<tr>");
			out.write("<td>"+index+"</td>");
			out.write("<td>"+tot+"\u20ac </td>");
			out.write("</tr>");
		}
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");	
	}
}
