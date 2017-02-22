package fr.ib.hugo.travel;

import java.io.IOException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SantiagoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		HttpSession s = req.getSession();
		Cookie c = new Cookie("last", URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10);

		Cookie[] cs = req.getCookies();
		if (cs != null)
			for(Cookie c2:cs){
				if(c2.getName().equals("last"))
					out.write(c2.getValue());
			}

			out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("<link rel='stylesheet' href='../css/bonito.css'>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>El viaje de tus sueños: Santiago</title>");
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
		out.write("<li><a href='../peru/lima'><span class='glyphicon glyphicon-camera'></span> Lima</a>");
		out.write(
				"<li class='active'><a href='#'><span class='glyphicon glyphicon-scissors'></span> Santiago</a>");
		out.write("<li><a href='../lapaz.jsp'><span class='glyphicon glyphicon-cloud'></span> La Paz</a>");
		out.write("<li><a href='../buenosaires.jsp'><span class='glyphicon glyphicon-education'></span> Buenos Aires</a>");
		out.write("<li><a href='../asuncion.jsp'><span class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>");
		out.write("<li><a href='../uruguay/montevideo'><span class='glyphicon glyphicon-flash'></span> Montevideo</a>");
		out.write("</ul>");
		out.write("</nav>");

		out.write("<div class='container'>");

		out.write("<div class='row'>");
		out.write("<h1>Santiago - Chile</h1>");
		out.write("</div>");

		out.write("<div class='row'>");
		out.write("<section class='col-xs-6'>");
		out.write("<h2>Viajes a Santiago</h2>");

		int x = 1;

		if (s.getAttribute("a") != null) {
			x = (Integer) s.getAttribute("a");
		}
		s.setAttribute("a", x + 1);
		if (x <= 3) {
			out.write("<p>Bienvenido! " + x + "</p>");
		}

		else if (x <= 5) {
			out.write("<p>Bienvenido nuevamente!</p>");
		}

		else {
			out.write("<p></p>");
		}

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
