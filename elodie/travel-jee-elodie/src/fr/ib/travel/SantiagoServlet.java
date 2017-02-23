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

public class SantiagoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8"); //en-tête HTTP
		
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>SANTIAGO</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Santiago</h1>");
		
		HttpSession s = req.getSession();
		int n =1 ;
		if (s.getAttribute("nbFois")!=null){
			n = (Integer)s.getAttribute("nbFois");
		}
		s.setAttribute("nbFois", n+1);
		if(n == 1){
			out.write("<p> BIENVENUE </p>");			
		}else if (n == 2 || n == 3 || n == 4){
			out.write("<p> BIENVENUE DE NOUVEAU </p>");	
		}else{
			out.write("<p> VOUS ETES DANS NOS FAVORIS </p>");
		}
	
		Cookie c = new Cookie("last", URLEncoder.encode(new Date().toString(), "UTF-8"));
		c.setMaxAge(10);
		res.addCookie(c);
		
		Cookie [] cs = req.getCookies();
		if (cs != null)
			for (Cookie co : cs)
				if(co.getName().equals("last")){
					out.write(co.getValue());
				}
					
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");	
	}
}
