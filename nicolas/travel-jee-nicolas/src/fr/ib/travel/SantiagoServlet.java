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

public class SantiagoServlet extends HttpServlet {



@Override
	



public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {  //se treouve avec source override /implement fonction..

		
		log("doGet"+this); //affiche dans la console le message doget
	
		res.setContentType("text/html"); //respecte la norme mime
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>"); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>voyage en amerique latine</title>");
		out.write("</head>");
		out.write("<body>");
		
		out.write("<h1>Satntiago</h1>");
		//out.write("<p>Bienvenu a SantiagoBienvenu a SantiagoBienvenu a SantiagoBienvenu a SantiagoBienvenu a SantiagoBienvenu a SantiagoBienvenu a SantiagoBienvenu a Santiago</p>");
		//out.write(getInitParameter("text"));
		
	
		HttpSession s=req.getSession();
		int n=1;
		//s.setAttribute("x", 3);
		if(s.getAttribute("x")!=null)
			n=(Integer)s.getAttribute("x");
		s.setAttribute("x", n+1);
		if(n==1)
			out.write("<p>Bienvenu a Santiago1</p>");
				
		if(n==2 || n==3 || n==4   )
			out.write("<p> Santiago1</p>");
		if(n==5)
			out.write("<p> San</p>");
		
		
		out.write("</body>");
		out.write("</html>");
		
		Cookie c= new Cookie("last", URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10); //unité seconde)
		res.addCookie(c);
		
		Cookie[]cs=req.getCookies();
		if(cs!=null)
			for(Cookie d:cs)
				if(d.getName().equals("last"))
		out.write(d.getValue());
		
		
	}
}

