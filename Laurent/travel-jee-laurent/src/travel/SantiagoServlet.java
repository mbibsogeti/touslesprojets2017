package travel;

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

	String titleHTML = "Welcome to 'Santiago'";
	String headHTML = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>" + titleHTML
			+ "</title><link rel='stylesheet' href='./css/bootstrap.min.css'></head>";
	String bodyHeadHTML = "<body><div class='container'>";
	String bodyFootHTML = "</div></body>";
	String bodyMenuHTML = "<nav ><ul class='nav nav-tabs nav-justified'><li><a href='./index.html'>Accueil</a><li><a href='./quito.html'>Quito</a><li><a href='./cartagena.html'>Cartagena</a><li><a href='./maracaibo.html'>Maracaibo</a><li><a href='./lima.html'>Lima</a><li class='active'><a href='./santiago.html'>Santiago</a><li><a href='/travel-jee-laurent/lapaz.jsp'>Lapaz</a><li><a href='/travel-jee-laurent/buenosaires.jsp'>Buenos Aires</a></ul></nav>";

	public SantiagoServlet() {
		// TODO Auto-generated constructor stub
	}

	public String bodyHTML(String txt) {
		return headHTML+bodyHeadHTML + bodyMenuHTML + txt + bodyFootHTML;
	}

	public String colHTML(String txt, int taille) {
		return "<section class='col-xs-" + taille + "'>" + txt + "</section>";
	}

	public String rowHTML(String txt) {
		return "<div class='row'>" + txt + "</div>";
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); // Permet d'indiquer que ce qu'on
											// enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		int Attribut1;
		HttpSession s=req.getSession();
		
		if(s.getAttribute("Attribut1")!=null){
			Attribut1=(Integer)s.getAttribute("Attribut1");
		}else {
			Attribut1=0;
			s.setAttribute("Attribut1", Attribut1);
		}
		
		String txt = "";
		txt += this.rowHTML(this.colHTML("<h1 class='text-centered'>Santiago</h1>", 12));

		if((Integer)s.getAttribute("Attribut1")<5){
			txt += this.rowHTML(this.colHTML(
					"<h3 class='text-justify-xs'> Bienvenue à santiago !!! En espagnol Santiago ou Santiago de Chile, souvent appelée Santiago du Chili, est la capitale du Chili, pays d'Amérique latine, où elle se situe dans la Vallée Centrale. Ses habitants s’appellent les Santiagois (Santiaguinos en espagnol).</h3>",
					12));
			Attribut1+=1;
			s.setAttribute("Attribut1", Attribut1);
		}else{
			txt+=this.rowHTML(this.colHTML("<img alt='' src='/travel-jee-laurent/img/memesJoke.jpg' class='text-centred'>", 12));
			Attribut1+=1;
			s.setAttribute("Attribut1", Attribut1);
			if((Integer)s.getAttribute("Attribut1")>8){
				s.removeAttribute("Attribut1");
			}
		}
		
		//Création d'un cookie avec une donnée de date
		Cookie c= new Cookie("last",URLEncoder.encode(new Date().toString(),"UTF-8"));
		c.setMaxAge(10);
		res.addCookie(c);
		
		Cookie[] cs=req.getCookies();
		if(cs!=null){
			for(Cookie C : cs){
				if(C.getName().equals("last")) txt+=URLDecoder.decode(C.getValue(),"UTF-8");
			}
		}
		
		out.write(this.bodyHTML(txt));
	}

}
