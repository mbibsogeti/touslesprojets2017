package fr.obodrel.travel;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class SantiagoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter outHtmlFile = null;
		HttpSession currSession = null;
		String outHtmlStr = "";
		int timesVisited = 0;
		Cookie lastLoginDateCookie = null;
		List<Cookie> allCookies;
		
		lastLoginDateCookie = new Cookie("lastLoginDate",URLEncoder.encode(new Date().toString(),"UTF-8"));
		lastLoginDateCookie.setMaxAge(10);
		resp.addCookie(lastLoginDateCookie);
		allCookies = (List<Cookie>) Arrays.asList(req.getCookies());
		
		currSession = req.getSession();
		
		
		if(currSession.getAttribute("timesVisited") != null) {
			timesVisited = (Integer)currSession.getAttribute("timesVisited");
		}
		currSession.setAttribute("timesVisited", ++timesVisited);
				
		resp.setContentType("text/html;charset=UTF-8");

		outHtmlFile = resp.getWriter();

		outHtmlStr = "<!DOCTYPE html>\n<html xmlns=\"\">\n<head>\n<meta charset=\"UTF-8\">\n"
				+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"../css/bootstrap.min.css\">"
				+ "\n<title>Santiago</title>\n</head>\n<body>\n\t<div class=\"container-fluid\">"
				+ "\n\t\t<h1 class=\"col-xs-12 col-xs-offset-3\">Obodrel's Travel, South America division!"
				+ "</h1>\n\t\t<nav class=\"col-xs-12\">\n\t\t\t<ul class=\"nav nav-pills nav-justified\">\n\t\t\t\t<li><a href=\"../\">Home"
				+ "</a></li>\n\t\t\t\t<li><a href=\"../equator/quito\">Quito Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../colombia/cartagena\">Cartagena Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../venezuela/maracaibo\">Maracaibo Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../peru/lima\">Lima Travel</a></li>"
				+ "\n\t\t\t\t<li class=\"active\"><a href=\".\">Santiago Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../lapaz.jsp\">Lapaz Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../buenosaires.jsp\">Buenos Aires Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../asuncion.jsp\">Asuncion Travel</a></li>"
				+ "\n\t\t\t\t<li><a href=\"../montevideo\">Montevideo Travel</a></li>"
				+ "\n\t\t\t</ul>\n\t\t</nav>\n\t\t<h2>Welcome to Santiago</h2>\n\t\t<p>Welcome!</p>";
		
		
		if(timesVisited <= 1 ) {
			outHtmlStr += "\n\t\t<p>Welcome!</p>";
		} else if (timesVisited < 5) {
			outHtmlStr += "\n\t\t<p>Welcome back!</p>";
		}
		
		for(Cookie cookie : allCookies) {
			if(cookie.getName().equals("lastLoginDate")) {
				outHtmlStr += "\n\t\t<p>Your last login was : "+URLDecoder.decode(cookie.getValue(),"UTF-8")+"</p>";
			}
		}
		
		outHtmlStr += "\n\t</div>\n</body>\n</html>";
		outHtmlFile.print(outHtmlStr);
		
	}

	@Override
	public void init() throws ServletException {
		super.init();
		log("SantiagoServlet init, this = "+this);
	}

}
