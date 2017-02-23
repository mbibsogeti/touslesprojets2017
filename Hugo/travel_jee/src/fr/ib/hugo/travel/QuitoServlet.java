package fr.ib.hugo.travel;

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
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("<link rel='stylesheet' href='../css/bonito.css'>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>El viaje de tus sueños: Quito</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<nav>");
		out.write("<ul class='nav nav-pills nav-justified'>");
		out.write("<li><a href='../index.html'><span class='glyphicon glyphicon-home'></span> Inicio</a>");
		out.write("<li class='active'><a href='#'><span class='glyphicon glyphicon-headphones'></span> Quito</a>");
		out.write("<li><a href='../colombia/cartagena'><span class='glyphicon glyphicon-king'></span> Cartagena</a>");
		out.write("<li><a href='../venezuela/maracaibo'><span class='glyphicon glyphicon-apple'></span> Maracaibo</a>");
		out.write("<li><a href='../peru/lima'><span class='glyphicon glyphicon-camera'></span> Lima</a>");
		out.write("<li><a href='../chile/santiago'><span class='glyphicon glyphicon-scissors'></span> Santiago</a>");
		out.write("<li><a href='../lapaz.jsp'><span class='glyphicon glyphicon-cloud'></span> La Paz</a>");
		out.write("<li><a href='../buenosaires.jsp'><span class='glyphicon glyphicon-education'></span> Buenos Aires</a>");
		out.write("<li><a href='../asuncion.jsp'><span class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>");
		out.write("<li><a href='../uruguay/montevideo'><span class='glyphicon glyphicon-flash'></span> Montevideo</a>");
		out.write("<li><a href='../guyana/georgetown'><span class='glyphicon glyphicon-send'></span> Georgetown</a>");
		out.write("</ul>");
		out.write("</nav>");
		out.write("<div class='container'>");
		out.write("<div>");
		out.write("<h1>Quito - Ecuador</h1>");
		out.write("</div>");
		out.write("<div class='row'>");
		out.write("<section class='col-sm-6'>");
		out.write("<h2>Viaje con los precios mas bajos</h2>");
		out.write(
				"<p>Viaje a Quito - Ecuador al menor precio del mercado. Vuelos desde tan solo 1060 € y hoteles desde 32.80 € por noche.</p>");
		out.write("</section>");

		out.write("<section class='col-sm-6'>");
		out.write("<h2>Precios</h2>");
		out.write("<table class='table table-striped table-hover table-responsive table-bordered table-condensed'>");
		out.write("<tr>");
		out.write("<th>Dias de estadia");
		out.write("<th>Precio total (avion + hotel)");
		double avion=1060;
		double noche=32.80;
		double precioT;
		for (int ndias = 5; ndias <= 25 ; ndias+=5) {
			precioT=avion+(ndias*noche);
			out.write("<tr>");
			out.write("<td>"+ndias);
			out.write("<td>"+String.format("%.2f", precioT)+" €");
		}
//		out.write("<tr>");
//		out.write("<td>1");
//		out.write("<td>Costa occidental");
//		out.write("<tr>");
//		out.write("<td>2");
//		out.write("<td>Costa sur");
//		out.write("<tr>");
//		out.write("<td>3");
//		out.write("<td>Costa oeste");
//		out.write("<tr>");
//		out.write("<td>4");
//		out.write("<td>Costa norte");
		out.write("</table>");
		out.write("</section>");
		out.write("</div>");
		out.write("</div>");
		out.write("</body>");
		out.write("</html>");
	}

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
