package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Maracaibo extends HttpServlet {

	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		res.setCharacterEncoding("utf-8"); // en-tête HTTP

		Writer out = res.getWriter();
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta charset='UTF-8'>");
		out.write("<title>MARACAIBO</title>");
		out.write("</head>");
		out.write("<body>");
		out.write("<h1 style='color:red'>Maracaibo</h1>");
		out.write("<h2>Inscription</h1>");

		
		String name = "";
		String phone = "";
		String nb ="";
		
		//Condition: case du formulaire non-rempli
		if (req.getParameter("telephone") != null) {
			phone = req.getParameter("telephone");
			if (req.getParameter("nom").equals("")) {
				out.write("<p>C'est la faute à Khaddy</p>");
			}else{
			out.write("<p> Inscription reçue de: " + req.getParameter("nom") + "</p>");
			}
		}
		
		//Pour ne pas avoir null en valeur de rafraichissement dans le formulaire
		if(req.getParameter("nom")!=null){
			name = req.getParameter("nom");
		}
		if(req.getParameter("nbVoyageur")!=null){
			nb = req.getParameter("nbVoyageur");
		}
		
		
		out.write("<form action='maracaibo' method='post'>");
		out.write("<p><label>Nom </label><input type='text' name='nom' value='"+name+"'></p>");
		out.write("<p><label>Tél </label><input type='tel' name='telephone' value='"+phone+"'></p>");
		out.write("<p><label>Voyageur </label><input type='number' name='nbVoyageur' min='1' max='10'value='"+nb+"'></p>");
		out.write("<p><input type='submit' name='sent' value='Envoi'></p>");
		out.write("</form>");
		out.write("</body>");
		out.write("</html>");
	}
}
