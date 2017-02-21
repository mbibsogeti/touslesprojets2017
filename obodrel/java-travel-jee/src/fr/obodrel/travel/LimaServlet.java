package fr.obodrel.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LimaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = null;
		String outHtmlStr;
		
		log("LimaServelt doGet, this = "+this);
		log("LimaServelt doGet, displayedTxt = "+getInitParameter("displayedTxt"));
		resp.setContentType("text/html;charset=UTF-8");

		outHtmlFile = resp.getWriter();
		

		outHtmlStr = "<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Lima</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+ "\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+ "</h1>\n\t\t<nav class=\"col-xs-12\">\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../\">Home"
				+ "</a></li>\n\t\t\t\t<li><a href=\"../equator/quito\">Quito Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../colombia/cartagena\">Cartagena Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../venezuela/maracaibo\">Maracaibo Travel</a></li>"
				+ "\n\t\t\t\t<li class=\"active\"><a href=\".\">Lima Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../chile/santiago\">Santiago Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../lapaz.jsp\">Lapaz Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../buenosaires.jsp\">Buenos Aires Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../asuncion.jsp\">Asuncion Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../montevideo\">Montevideo Travel</a></li>"
				+ "\n\t\t\t</ul>\n\t\t</nav>\n\t\t<h2>Welcome to Lima</h2>\n\t\t<p>"+getInitParameter("displayedTxt")+"</p>"
				+  "\n\t</div>\n</body>\n</html>";
		
		outHtmlFile.print(outHtmlStr);
	}

	@Override
	public void destroy() {
		log("LimaServelt destroy, this = "+this);
		super.destroy();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		log("LimaServelt init, this = "+this);
	}
}