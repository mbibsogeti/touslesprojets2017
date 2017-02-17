package travel;

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
		res.setCharacterEncoding("UTF-8");
		Writer out = res.getWriter();
		
		
//		Définition des valeurs des values des différents champs du formulaire :
		String name="";
//		Récupération de la valeur entrée dans le formulaire par l'utilisateur pour la retourner en cas d'erreur dans le form :
		if (req.getParameter("name")!=null) {
			name=req.getParameter("name");
		}
		String tel="";
		if (req.getParameter("tel")!=null) {
			tel=req.getParameter("tel");
		}
		String nb="";
		if (req.getParameter("nb")!=null) {
			nb=req.getParameter("nb");
		}
		
//		Description de la page :
		out.write("<!DOCTYPE html><html><head><meta charset='UTF-8'>");
		out.write("<title>Maracaibo</title>");
		out.write("<link rel='stylesheet' href='../css/bootstrap.min.css'>");
		out.write("</head>");
		out.write("<body>");
		out.write("<div class='container'>");
		
		out.write("<h1>Welcome on the Maracaibo webpage</h1>");
		out.write("<h2>Inscription:</h2>");
		
//		Création d'un panneau donnant le résultat du 'submit' du formulaire :
		if (req.getParameter("tel")!=null) {
//			Le trim permet d'éliminer les espaces éventuels :
			if (! req.getParameter("name").trim().equals("")) {
				out.write("<p class='well'>Form sent: "+ req.getParameter("name")+"</p>");
			} else {
				out.write("<p class='well well-warning'>Erreur !</p>");
			}
		}
		
		
//		Création du formulaire :
		out.write("<section class='row'><section class='col-xs-4'>");
		out.write("<form action='?' method='post'>");
		out.write("<section class='form-group'>");
		out.write("<p>Name: <input type='text' name='name' class='form-control' value='"+name+"'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p>Tel: <input type='tel' name='tel' class='form-control' value='"+tel+"'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p>Travellers: <input type='number' name='nb' class='form-control' value='"+nb+"'></p>");
		out.write("</section>");
		out.write("<section class='form-group'>");
		out.write("<p><input type='submit' value='send' class='btn btn-primary'></p>");
		out.write("</section>");
		out.write("</section></section>");
		out.write("</form></div></body></html>");
	}

}
