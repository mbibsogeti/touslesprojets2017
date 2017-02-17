package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet {

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public void service(HttpServletRequest req , HttpServletResponse res) throws ServletException, IOException {
		HashMap<String,String>descs=new HashMap<>();
		descs.put("Barranquilla ","trekk de 4 jr");
		descs.put("Bogota ","train de 2 jr");
		descs.put("cali ","car de 4 jr");
		descs.put("san andreas ","croisiere cool");
		
		res.setContentType("text/html"); //respecte la norme mime
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();  // déclare les sortie 
		out.write("<!DOCTYPE html>"); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Cartagena</title>");
		out.write("</head>");
		out.write("<body>");
		
		out.write("<h1>Cartagena</h1>");
		out.write("<h2>autre ville de colombie</h2>");
	
		for (String k:descs.keySet())
			out.write("<p><a href='Cartagena?city="+k+"'>"+ k +"</a></p>");	

		if(req.getParameter("city")!=null &&descs.containsKey(req.getParameter("city")))
		out.write("<p>"+ descs.get(req.getParameter("city"))+"</p>");
		
		out.write("</body>");
		out.write("</html>");
		
		//super.service(arg0, arg1);
	}

}
