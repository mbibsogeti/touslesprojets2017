package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class GeorgeTownServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		try{
			DataSource ds = (DataSource)
			new InitialContext().lookup("java:comp/env/jdbc/travelDS");
			ds.getConnection().close();
			
		}catch(Exception ex){
			log("Error !", ex);
		}
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		
		Writer out = res.getWriter();
	    out.write("Welcome to GeorgeTown !!");	
	    
		
		
		
		
		
		
		
		
		
		
	}

}
