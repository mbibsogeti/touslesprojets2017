package fr.obodrel.travel;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MaracaiboServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = null;
		String reqTel, reqName, reqNbTravellers;
		String outHtmlStr;
		
		resp.setContentType("text/html;charset=UTF-8");
		outHtmlFile = resp.getWriter();

		outHtmlStr = "<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Maracaibo</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+ "\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+ "</h1>\n\t\t<nav class=\"col-xs-12\">\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../\">Home"
				+ "</a></li>\n\t\t\t\t<li><a href=\"../equator/quito\">Quito Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../colombia/cartagena\">Cartagena Travel</a></li>"
				+ "\n\t\t\t\t<li class=\"active\"><a href=\".\">Maracaibo Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../peru/lima\">Lima Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../chile/santiago\">Santiago Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../lapaz.jsp\">Lapaz Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../buenosaires.jsp\">Buenos Aires Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../asuncion.jsp\">Asuncion Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../montevideo\">Montevideo Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../georgetown\">George Town Travel</a></li>"
				+ "\n\t\t\t</ul>\n\t\t</nav>\n\t\t<h2>Welcome to Maracaibo</h2>\n\t\t<h3>Inscription!</h3>";

		reqTel = "";
		reqName = "";
		reqNbTravellers = "";
		
		if (req.getParameter("telFormMaracaibo") != null) {
			reqTel = req.getParameter("telFormMaracaibo");
			reqName = req.getParameter("nameFormMaracaibo");
			reqNbTravellers = req.getParameter("nbTravellersFormMaracaibo");
			if (reqTel.trim().equals("") || reqName.trim().equals("") || reqNbTravellers.trim().equals("")) {
				outHtmlStr += "\n\t\t<p>An error occured, you must have forgotten to fill in some values, please retry!</p>";
			} else {

				outHtmlStr += "\n\t\t<p>We received an inscription from : " + reqTel + "!";
				outHtmlStr += " You will be " + reqName + " to travel and we will contact";
				outHtmlStr += " you at the following telephone number " + reqNbTravellers + "!";
				outHtmlStr += "\n\t</div>\n</body>\n</html>";
				outHtmlFile.print(outHtmlStr);
				return;
			}
		}

		outHtmlStr += "\n\t\t<form action=\".\" method=\"post\">\n\t\t\t<section class=\"form-group\">"
				+ "\n\t\t\t\t<label for=\"nameMaracaibo\">Name :</label><input name=\"nameFormMaracaibo\" "
				+ "id=\"nameMaracaibo\" type=\"text\" class=\"form-control\" value=\"" + reqName + "\" required>"
				+ "\n\t\t\t\t<label for=\"telMaracaibo\">Telephone Number :</label><input name=\"telFormMaracaibo\""
				+ " id=\"telMaracaibo\" type=\"tel\" class=\"form-control\" value=\"" + reqTel + "\" required>"
				+ "\n\t\t\t\t<label for=\"nbTravellersMaracaibo\">Travellers :</label><input name=\""
				+ "nbTravellersFormMaracaibo\" id=\"nbTravellersMaracaibo\" type=\"number\" class=\"form-control\" value=\""
				+ reqNbTravellers + "\" required>"
				+ "\n\t\t\t</section>\n\t\t\t<input class=\"btn btn-primary\" type=\"submit\" value=\"Submit\">"
				+ "\n\t\t</form>";

		outHtmlStr += "\n\t</div>\n</body>\n</html>";
		outHtmlFile.print(outHtmlStr);

	}
}
