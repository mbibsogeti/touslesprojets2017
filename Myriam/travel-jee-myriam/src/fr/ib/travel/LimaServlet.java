package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		log("doGet"+this);
		
		res.setContentType("text/HTML");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<h1>Bienvenue à Lima</h1>");
		out.write(getInitParameter("texte"));
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		log("destroy");
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		log("init");
	}


}
