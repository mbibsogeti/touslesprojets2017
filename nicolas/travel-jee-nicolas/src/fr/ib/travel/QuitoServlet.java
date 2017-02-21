package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //respecte la norme mime
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();  // déclare les sortie 
		out.write("<!DOCTYPE html>"); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>voyage en amerique latine</title>");
		out.write("</head>");
		out.write("<body>");
		
		out.write("<h1>Agence de voyage amerique du sud</h1>");
		out.write("<h2>grille tarifaire</h2>");
		out.write("<table border='1' 'style'='font-size=20px'><tr><th>jours</th><th>ttc(€)</th></tr>");
		for (int i=5; i<=25; i+=5)
		 		{
			double a= 1060 + 32.8*i;
			out.write("<tr><td>" + i +"</td><td>" + a + "</td></tr>");
				}	
		out.write("</body>");
		out.write("</html>");
		
		//super.service(arg0, arg1);
	}

}
