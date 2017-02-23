package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgetownServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
			DataSource ds=(DataSource)
		    new InitialContext().lookup("java:comp/env/jdbc/travelDS");		
			ds.getConnection().close();
		}catch(Exception ex){
			log("Erreur!", ex);
		}
		
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Voyages en amérique du sud, georgetown</title>");
		out.write("<h2>Vive les vacances, Youuuhou!!!!</h2>");
	}
}
