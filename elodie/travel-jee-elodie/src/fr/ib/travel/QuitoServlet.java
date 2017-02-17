package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>QUITO</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Quito!!!</h1>");
		out.write("</body>");
		out.write("</html>");
	}
	

}
