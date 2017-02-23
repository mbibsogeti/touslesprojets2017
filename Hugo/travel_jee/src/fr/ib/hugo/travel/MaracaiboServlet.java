package fr.ib.hugo.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet {

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
		out.write("<title>El viaje de tus sueños: Maracaibo</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<nav>");
		out.write("<ul class='nav nav-pills nav-justified'>");
		out.write("<li><a href='../index.html'><span class='glyphicon glyphicon-home'></span> Inicio</a>");
		out.write(
				"<li><a href='../ecuador/quito'><span class='glyphicon glyphicon-headphones'></span> Quito</a>");
		out.write(
				"<li><a href='../colombia/cartagena'><span class='glyphicon glyphicon-king'></span> Cartagena</a>");
		out.write(
				"<li class='active'><a href='#'><span class='glyphicon glyphicon-apple'></span> Maracaibo</a>");
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
		out.write("<div class='row'>");
		out.write("<h1>Maracaibo - Venezuela</h1>");
		out.write("</div>");

		out.write("<div class='row'>");
		out.write("<section class='col-xs-6'>");
		out.write("<h2>Inscripciones</h2>");

		if (req.getParameter("tel") != null && !"".equals(req.getParameter("tel"))) {
			if (req.getParameter("Nom") != null && !"".equals(req.getParameter("Nom"))) {
				out.write("<p>" + req.getParameter("Nom") + " tu inscripcion ha sido recibida.");
			} else {
				out.write("<p>Por favor ingrese su nombre y numero de teléfono.");
			}
		} else {
			out.write("<p>Por favor ingrese su nombre y numero de teléfono.");
		}
		// method='post' permet d'eviter de passer par l'url dans la barre
		// d'adresses,évitant ainsi le cas où les champs soient très grands i.e.
		// textarea
		out.write("<form action=? method='post'>");
		out.write("<section class='form-group'>");

		if (req.getParameter("Nom") != null) {
			out.write("<label for='name'> Nombre: </label> <input type='text' name='Nom' id='name' value='"
					+ req.getParameter("Nom") + "' class='form-control'>");
		} else {
			out.write(
					"<label for='name'> Nombre: </label> <input type='text' name='Nom' id='name' class='form-control'>");
		}

		out.write("</section>");
		out.write("<section class='form-group'>");

		if (req.getParameter("tel") != null) {
			out.write("<label for='tel'> Teléfono: </label> <input type='text' name='tel' id='tel' value='"
					+ req.getParameter("tel") + "' class='form-control'>");
		} else {
			out.write(
					"<label for='tel'> Teléfono: </label> <input type='text' name='tel' id='tel' class='form-control'>");
		}

		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write(
				"<label for='passengers'> Pasajeros: </label> <input type='number' name='pasajeros' id='passengers' min='0' class='form-control'>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<input type='submit' value='Enviar' class='btn btn-warning'>");

		out.write("</section>");
		out.write("</form>");
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