package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeorgeTownServlet extends HttpServlet{
	

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
		
		out.write("<h1>GeorgeTown</h1>");
		out.write("</body>");
		out.write("</html>");
		try{}
		catch(exception ex){
			log("erreur!"ex)
		}
}
}

