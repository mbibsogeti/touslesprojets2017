package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		log("doGet"+this);
		
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");

		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='utf-8'>");
		out.write("<title>Voyage, voyage...</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>PEROU</h1>");
		out.write("<h2>Lima </h2>");
		out.write(getInitParameter("text"));
		out.write("</body>");	
		out.write("</html>");
				
	}
	

	@Override
	public void init() throws ServletException {
		
		super.init();
		log("init");
	
	}
	
	@Override
	public void destroy() {
	
		super.destroy();
		log("destroy");
	}

}
