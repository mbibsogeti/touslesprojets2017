package fr.ib.hugo.travel;

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
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>El viaje de tus sueños: Cartagena</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<nav>");
		out.write("<ul class='nav nav-pills nav-justified'>");
		out.write("<li><a href='../index.html'><span class='glyphicon glyphicon-home'></span> Inicio</a>");
		out.write(
				"<li><a href='../ecuador/quito'><span class='glyphicon glyphicon-headphones'></span> Viajar a Quito</a>");
		out.write(
				"<li class='active'><a href='#'><span class='glyphicon glyphicon-king'></span> Viajar a Cartagena</a>");
		out.write("<li><a href='../venezuela/maracaibo'><span class='glyphicon glyphicon-apple'></span> Viajar a Maracaibo</a>");
		out.write("<li><a href='../peru/lima'><span class='glyphicon glyphicon-camera'></span> Viajar a Lima</a>");
		out.write("</ul>");
		out.write("</nav>");
		out.write("<div class='container'>");
		out.write("<div>");
		out.write("<h1>Cartagena - Colombia</h1>");
		out.write("</div>");

		HashMap<String, String> descs = new HashMap<>();
		descs.put("Barranquilla", "Trekk de 4 dias");
		descs.put("Bogota", "Viaje en tren");
		descs.put("Cali", "Viaje en Autocar");
		descs.put("San Andrés", "Viaje en crucero");
		descs.put("Medellin", "Viaje en Jeep");

		out.write("<div class='row'>");
		out.write("<section class='col-sm-6'>");
		out.write("<h2>Desde Cartagena</h2>");
		out.write(
				"<p>Viaje desde Cartagena a los siguientes destinos, todo con la mejor agencia de viajes El Viaje de tus Sueños.</p>");
		for (String k : descs.keySet()) {
			// out.write(k+"<br>");
			out.write("<p><a href='cartagena?city=" + k + "'>" + k + "</a></p>");
		}
		
		out.write("<p>");
		if (req.getParameter("city") != null && descs.containsKey(req.getParameter("city"))) {
			out.write("<button class='btn btn-warning'>"+descs.get(req.getParameter("city")));
		}
		out.write("</button>");
		out.write("</p>");
		
		
		out.write("</section>");
		out.write("</div>");

		out.write("</body>");
		out.write("</html>");
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
