package fr.belto.travel;

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
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		HttpSession s = req.getSession();
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Santiago</title>");
		out.write("</head>");
		out.write("<body>");
		int x=0;
		if (s.getAttribute("Connexion") != null)
			x = (Integer) s.getAttribute("Connexion");
		s.setAttribute("Connexion", x+1);
		if (x < 5) {
			out.write("<h1> Bienvenue!</h1>");
		} else
			out.write("<h1> Vous vous etes connecté plus de 4 fois</h1>");
		
		
		Cookie c= new Cookie ("last",URLEncoder.encode(new Date().toString(), "utf-8"));// On cree une cookie pour enregistrer la date de connexion
		c.setMaxAge(10);// on rajoute 10 seconde à la date
		res.addCookie(c);// et on le stock
		
		Cookie[]cs=req.getCookies();// on va chercher les cookies qui sont présentes dans l'application
		if(cs!=null)// une fonction pour lire et si elle n'est pas null
			for (Cookie c2:cs)
				if(c2.getName().equals("last"))
		out.write(c2.getValue());// on affiche sa valeur
	}
	
}