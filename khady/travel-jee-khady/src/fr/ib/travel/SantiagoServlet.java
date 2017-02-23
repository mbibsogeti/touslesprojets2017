package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SantiagoServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");

		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='utf-8'>");
		out.write("<title>Voyage...</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h2>CHILI</h2>");
		out.write("<h3>SANTIAGO... Welcome to our magnificient paradise !</h3>");		 
     	out.write("</body>");
		out.write("</html>");

		//Les cookies
		HttpSession s = req.getSession();
		int n = 1;
		if (s.getAttribute("x") != null) 
			n = (Integer)s.getAttribute("x");
			s.setAttribute("x", n + 1);
			if (n == 1){ 
				out.write("Bienvenue");
			} else if (n < 5) {
				out.write("Bienvenue à nouveau");
			}

			
		Cookie c =new Cookie("last", URLEncoder.encode(new Date().toString(),"utf-8"));
		c.setMaxAge(10);
		res.addCookie(c);
		Cookie[]cs = req.getCookies();
		if(cs!=null)
			for(Cookie c2:cs)
				if(c2.getName().equals("last"))
					out.write(c.getValue());
			
			
		}

	}
