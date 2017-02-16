package fr.obodrel.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class QuitoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = resp.getWriter();

		resp.setContentType("text/html");

		outHtmlFile.print("<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Quito</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+"\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+"</h1>\n\t\t<nav>\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../../\">Home"
				+"</a></li>\n\t\t\t\t<li class=\"active\"><a href=\"#\">Quito Travel</a></li>\n\t\t\t</ul>"
				+"\n\t\t</nav>\n\t\t<h2>Welcome to Quito</h2>\n\t\t<p>Welcome!</p>\n\t</div>\n</body>\n</html>");
	}
}
