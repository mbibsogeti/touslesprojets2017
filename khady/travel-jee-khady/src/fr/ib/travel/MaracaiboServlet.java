package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
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
		out.write("<h1>VENEZUELA</h1>");
		out.write("<h2>Maracaibo !</h2>");
		out.write("</body>");
		out.write("<p>Inscription</p>");

	
		if(req.getParameter("tel")!=null){
                if(req.getParameter("name").trim().equals("")){
                	out.write("Elément(s) formulaire manquant(s) !");
				}else {
					out.write("<p>Inscription reçue pour : "+ req.getParameter("name")+" </p>");
				}
		}
					
		String name ="";
		String tel ="";
		String nb = "";
		if(req.getParameter("name")!=null)
			name = req.getParameter("name");
		if(req.getParameter("tel")!=null)
			tel = req.getParameter("tel");
		if(req.getParameter("nb")!=null)
			nb = req.getParameter("nb");
		
		out.write("<form action = '?' method='post'>");		
		out.write("<p><label>Nom <input id ='name' type ='text'name='name' value ="+req.getParameter("name")+ "></label></p>");
		out.write("<p><label>Tél <input type='tel'name='tel' value=" +req.getParameter("tel")+ "></label></p>");	
		out.write("<p><label>Voyageurs <input id='nbTravellers' type='number' name='nb' value="+req.getParameter("nb")+"></label></p>");
		out.write("<p><label>Soumettre <input type='submit'></label></p>");
		out.write("</form>");
		out.write("</html>");
		
		
		
		
		
	}

}
