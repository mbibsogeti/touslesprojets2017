package fr.ib.hugo.travel;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgetownServlet extends HttpServlet{
	
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
		out.write("<title>El viaje de tus sueños: Cartagena</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<nav>");
		out.write("<ul class='nav nav-pills nav-justified'>");
		out.write("<li><a href='../index.html'><span class='glyphicon glyphicon-home'></span> Inicio</a>");
		out.write(
				"<li><a href='../ecuador/quito'><span class='glyphicon glyphicon-headphones'></span> Quito</a>");
		out.write(
				"<li><a href='../colombia/cartagena'><span class='glyphicon glyphicon-king'></span> Cartagena</a>");
		out.write("<li><a href='../venezuela/maracaibo'><span class='glyphicon glyphicon-apple'></span> Maracaibo</a>");
		out.write("<li><a href='../peru/lima'><span class='glyphicon glyphicon-camera'></span> Lima</a>");
		out.write("<li><a href='../chile/santiago'><span class='glyphicon glyphicon-scissors'></span> Santiago</a>");
		out.write("<li><a href='../lapaz.jsp'><span class='glyphicon glyphicon-cloud'></span> La Paz</a>");
		out.write("<li><a href='../buenosaires.jsp'><span class='glyphicon glyphicon-education'></span> Buenos Aires</a>");
		out.write("<li><a href='../asuncion.jsp'><span class='glyphicon glyphicon-tree-deciduous'></span> Asuncion</a>");
		out.write("<li><a href='../uruguay/montevideo'><span class='glyphicon glyphicon-flash'></span> Montevideo</a>");
		out.write("<li class='active'><a href='#'><span class='glyphicon glyphicon-send'></span> Georgetown</a>");
		out.write("</ul>");
		out.write("</nav>");
		out.write("</body>");
		out.write("</html>");
		
		try{
			DataSource ds=(DataSource) new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
			log("cool man!");
		} catch(Exception ex){
			log("Error!",ex);
		}
	}
	
	private static final long serialVersionUID = 1L;
}
