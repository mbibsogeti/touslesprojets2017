package travel;

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
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		
		HashMap<String, String> descs = new HashMap<> ();
		descs.put("Barranquilla","Trekk à Barranquilla");
		descs.put("Bogota","Plouf à Bogota");
		descs.put("Cali","Dodo au chaud à Cali");
		descs.put("San Andrès","Un très beau truc");
		
		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
		out.write("<title>Cartagena</title>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<jsp:include page='WEB-INF/jsp/header.jsp'>");
		out.write("<jsp:param name='year' value='2017'/>");
		out.write("</jsp:include>");
		out.write("<div class='container'>");
		out.write("<h1>Welcome on the Cartagena webpage</h1>");
		
		out.write("<section>");
		for (String k:descs.keySet()) {
			out.write("<p><a href='cartagena?city="+k+"'>"+k+"</a></p>");
		}
		if (req.getParameter("city")!=null && descs.containsKey(req.getParameter("city"))) {
			out.write("Our offer for this place: "+descs.get(req.getParameter("city")));
		}
		if (req.getParameter("city")!=null && !descs.containsKey(req.getParameter("city"))) {
			throw new ServletException("Destination unknown!");
		}
		
		out.write("<a href='../index.html'>Accueil</a>");
		out.write("</section></div></body></html>");
	
	}

}
