package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;

public class GeorgeTownServlet extends HttpServlet{
	

@Override



public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {  //se treouve avec source override /implement fonction..

		
		log("doGet"+this); //affiche dans la console le message doget
	
		res.setContentType("text/html"); //respecte la norme mime
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>"); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>voyage en amerique latine</title>");
		out.write("</head>");
		out.write("<body>");
		
		out.write("<h1>GeorgeTown</h1>");
		out.write("</body>");
		out.write("</html>");
		try{
			DataSource ds=(DataSource)
					new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
						
		}
		catch(Exception ex){
			log("erreur!",ex);
		}
}
}

