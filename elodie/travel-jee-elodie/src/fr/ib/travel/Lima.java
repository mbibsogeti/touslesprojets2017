package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lima extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		log("doGet"+this);
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("utf-8"); // en-tête HTTP
		Writer out = resp.getWriter();
		
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>LIMA</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Lima !!</h1>");
		out.write(getInitParameter("Text"));
		out.write("</body>");
		out.write("</html>");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("init");
	}
	
	@Override
	public void destroy() {
		
		log("destroy");
		super.destroy();
	}

}
