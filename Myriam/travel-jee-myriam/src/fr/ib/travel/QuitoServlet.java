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
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html><head><meta charset='UTF-8'><title>Amérique Latine</title><meta http-equiv='X-UA-Compatible' content='IE=Edge'><meta name='viewport'content='width=device-width, initial-scale=0.5, minimal-scale=0.5'><link rel='stylesheet' href='css/bootstrap.min.css'></head>");
		out.write("<h1>Bienvenue à Quito (Chili)</h1>");
		out.write("<p>Blablabla</p>");
		
		out.write("<table><tr><th>Nombre de jours</th><th>Tarif TTC €</th></tr>");
		
		for (int i=1;i<=5;i++) {
			float prix=(float) (1060+(i*5*32.80));
			out.write("<tr><td>"+i*5+"</td><td>"+String.format("%.2f", prix)+"</td></tr>");
		}
		
		out.write("</table>");
	}
	

}
