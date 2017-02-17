package fr.belto.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); 
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>Bienvenue à Cartagena (ville de Colombie)</title>");
		out.write("<link rel='stylesheet' href='css/bootstap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1>Voyages au Maracaïbo</h1>");
		String telephone=""; // declaration de la variable telephone
		String nom="";// declaration de la variable nom
		String voyageur=""; // declaration de la variable voyageur
		if (req.getParameter("tel")!=null && req.getParameter("name")!=null && req.getParameter("nb")!=null){
			if(!req.getParameter("name").trim().equals("") && // verification que la case name est remplie
			   !req.getParameter("nb").trim().equals("") && // verification que la case nb est remplie
			   !req.getParameter("tel").trim().equals("")) // verification que la case tel est remplie
				out.write("<p>Inscrription reçue: "+ req.getParameter("name")+"</p>");
			else
				{out.write("<p>Erreur!</p>");// si au moins un case est vide, on affiche erreur!
			   if(req.getParameter("tel")!=null) // si cette case n'est pas vide alors on le garde
				   telephone=req.getParameter("tel");// on renvoi sa valeur dans telephone qui sera recuperer en bas dans out.write(" input
			   if(req.getParameter("name")!=null)// si cette case n'est pas vide, on le garde 
				   nom=req.getParameter("name");// on renvoi sa valeur dans nom qui sera recuperer en bas dans out.write(" input
			   if (req.getParameter("nb")!=null)// si cette case n'est pas vide alors on le garde
				   voyageur=req.getParameter("nb");//on renvoi sa valeur dans nb qui sera recuperer en bas dans out.write(" input
				}
			}		
		out.write("<form action='?' method='post'>");// le action='?' veut dire que à l'envoie du formulaire on revient sur la page
		out.write("<h2>Inscription<h2>");
		out.write("<p>");
		out.write("<label> Nom:</label>");
		out.write("<input value= '"+ nom+"'name='name' type='text'>");// le name permet de retrouver sa demande dans le navigateur
		out.write("</p>");
		out.write("<p>");
		out.write("<label> Tel:</label>");
		out.write("<input value= '"+telephone+"' name='tel' type='tel'>");
		out.write("</p>");
		out.write("<p>");
		out.write("<label> Voyageurs:</label>");
		out.write("<input value= '"+voyageur+"' name='nb' type='number'>");
		out.write("</p>");
		out.write("<p>");
		out.write("<label></label>");
		out.write("<input  type='submit'>");
		out.write("</p>");
				
	}
}