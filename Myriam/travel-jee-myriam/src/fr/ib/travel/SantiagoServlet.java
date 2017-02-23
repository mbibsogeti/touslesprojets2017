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
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/HTML");
		res.setCharacterEncoding("UTF-8");
		
		Writer out=res.getWriter();
		out.write("<!DOCTYPE html>");
		
		HttpSession s=req.getSession();
		
		if(s.getAttribute("x")!=null){	
			int nb_s= (Integer)(s.getAttribute("x"));

			if (nb_s==1)
				out.write("<h1>Bienvenue au Chili</h1>");
			else if (nb_s<5 && nb_s>1)
				out.write("<h1>Bienvenue de nouveau !</h1>");
			
			s.setAttribute("x", nb_s+1);
		}
		
		Cookie c=new Cookie("last",URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10);;
		res.addCookie(c);
		
		Cookie[] cs=req.getCookies();
		if (cs!=null){
			for (Cookie c1:cs){
				if(c1.getName().equals("last"))
					out.write(c1.getValue());
			}
		}
			
	}
}
