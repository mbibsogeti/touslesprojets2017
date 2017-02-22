package fr.ib.hugo.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		log("destroy");
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		log("init");
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("<link rel='stylesheet' href='../css/bonito.css'>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>El viaje de tus sueños: Lima</title>");
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
				"<li><a href='../venezuela/maracaibo'><span class='glyphicon glyphicon-apple'></span> Maracaibo</a>");
		out.write("<li class='active'><a href='#'><span class='glyphicon glyphicon-camera'></span> Lima</a>");
		out.write("<li><a href='../chile/santiago'><span class='glyphicon glyphicon-scissors'></span> Santiago</a>");
		out.write("<li><a href='../lapaz.jsp'><span class='glyphicon glyphicon-cloud'></span> La Paz</a>");
		out.write("<li><a href='../buenosaires.jsp'><span class='glyphicon glyphicon-education'></span> Buenos Aires</a>");
		out.write("<li><a href='../asuncion.jsp'><span class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>");
		out.write("<li><a href='../uruguay/montevideo'><span class='glyphicon glyphicon-flash'></span> Montevideo</a>");
		out.write("</ul>");
		out.write("</nav>");
		// permet de laisser une trace du passage par cette page dans les
		// fichiers log.
		log("doGet"+this);

		out.write("<div class='container'>");

		out.write("<div class='row'>");
		out.write("<h1>Lima - Peru</h1>");
		out.write("</div>");

		out.write("<div class='row'>");
		out.write("<section class='col-xs-6'>");
		out.write("<h2>Viajes a Lima</h2>");
		out.write("<p>"+getInitParameter("texto")+"</p>");
		out.write("</section>");
		out.write("</div>");

		out.write("</div>");
		out.write("</body>");
		out.write("</html>");

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
