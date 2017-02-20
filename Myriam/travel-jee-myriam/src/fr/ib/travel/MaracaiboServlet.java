package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/HTML");
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		
		String name="";
		if (req.getParameter("nom")!=null)
			name=req.getParameter("nom");
		
		String tel="";
		if (req.getParameter("tel")!=null)
			tel=req.getParameter("tel");
		
		String nb ="";
		if (req.getParameter("nb")!=null)
			nb=req.getParameter("nb");
		
		out.write("<!DOCTYPE html>");
		out.write("<h1>Bienvenue au Vénézuela (Maracaibo)</h1>");
		out.write("<h2>Inscription</h2>");
		out.write("<form action='?' method='post'><p><label>Nom </label><input type='text' name='nom' id='nom' value='"+name+"'/></p>");
		out.write("<p><label>Tel </label><input type='tel'name='tel' id='tel' value='"+tel+"'/></p>");
		out.write("<p><label>Nombre de voyageurs </label><input type='number' name='nb' id='nb' value='"+nb+"'/></p>");
		out.write("<p><input type='submit' value='Envoi'/></p>");
		out.write("</form>");
		
		if(req.getParameter("tel")=="" || req.getParameter("nom")=="" || req.getParameter("nb")=="")
			out.write("<p>Vous devez remplir tous les champs pour envoyer le formulaire</p>");
	}

}
