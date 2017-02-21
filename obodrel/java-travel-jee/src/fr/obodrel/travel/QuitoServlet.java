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
		PrintWriter outHtmlFile = null;

		resp.setContentType("text/html;charset=UTF-8");

		outHtmlFile = resp.getWriter();
		
		outHtmlFile.print("<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Quito</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+ "\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+ "</h1>\n\t\t<nav class=\"col-xs-12\">\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../\">Home"
				+ "</a></li>\n\t\t\t\t<li class=\"active\"><a href=\".\">Quito Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../colombia/cartagena\">Cartagena Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../venezuela/maracaibo\">Maracaibo Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../peru/lima\">Lima Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../chile/santiago\">Santiago Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../lapaz.jsp\">Lapaz Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../buenosaires.jsp\">Buenos Aires Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../asuncion.jsp\">Asuncion Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../montevideo\">Montevideo Travel</a></li>"
				+ "\n\t\t\t</ul>\n\t\t</nav>\n\t\t<h2>Welcome to Quito</h2>\n\t\t<p>Welcome!</p>"
				+ getQuitoDaysTravelArray()
				+ "\n\t</div>\n</body>\n</html>");
	}

	private String getQuitoDaysTravelArray() {
		String out;

		out = "\n\t\t<table class=\"table table-striped\">\n\t\t\t<thead>\n\t\t\t\t<tr>\n\t\t\t\t\t"
				+ "<th>Days</th>\n\t\t\t\t\t<th>Price WT</th>\n\t\t\t\t</tr>\n\t\t\t</thead>\n\t\t\t<tbody>";

		for (int i = 0; i < 5; i++) {
			out += "\n\t\t\t\t<tr>\n\t\t\t\t\t<td>" + 5 * (i + 1) + "</td>\n\t\t\t\t\t<td>";
			out += (1060 + 5 * i * 32.80) + "€</td>\n\t\t\t\t</tr>";
		}

		out += "\n\t\t\t</tbody>\n\t\t</table>";

		return out;
	}
}
