package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8"); //en-tête HTTP
		HashMap<String,String> descs=new HashMap<>();
		descs.put("Barranquilla", "Trekk de 4 jours");
		descs.put("Bogota", "Train de 2 jours");
		descs.put("Cali", "Car de 5 jours");
		descs.put("San Andréas", "Croisière de 6 jours");
		
		
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Cartagena</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Cartagena</h1>");
		
		for(String k : descs.keySet()){
			out.write("<p><a href='cartagena?city=" + k + "'>"+k+"</a></p>");
		}
		if(req.getParameter("city")!=null){
			out.write(descs.get(req.getParameter("city")));
		}
		out.write("</body>");
		out.write("</html>");	
	}
}
