/**
 * 
 */
package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ib
 *
 */
public class SantiagoServlet extends HttpServlet {

	private static final String Integer = null;

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Santiago</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Santiago de Chili</h1>");
		// out.write("<p> Bienvenue sur la page de Santiago de Chili</p>");
		int p;
		HttpSession s = req.getSession();
		int n = 1;
		if (s.getAttribute("v") != null)
			n = (Integer) s.getAttribute("v");
		s.setAttribute("v", n + 1);
		if (n == 1)
			out.write("<p> Bienvenue sur la page de Santiago de Chili</p>");
		else if (n < 5)
			out.write("<p> Bienvenue de nouveau sur la page de Santiago de Chili</p>");

		out.write("</body>");
		out.write("</html>");
		/* écriture cookie*/
		Cookie c=new Cookie("last",URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10);// en seconde 
		res.addCookie(c);
		/*lecture cookie*/
		Cookie[]cs=req.getCookies();
		if(cs!=null)
			for(Cookie c1:cs)
				if(c1.getName().equals("last"))
					out.write(c1.getValue());
		

	}
}
