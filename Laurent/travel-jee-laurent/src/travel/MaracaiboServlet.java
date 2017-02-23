package travel;

import java.io.IOException;
import java.io.Writer;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MaracaiboServlet extends HttpServlet{

	String titleHTML="Welcome to 'Maracaibo'";
	String headHTML="<!DOCTYPE html><html><head><meta charset='UTF-8'><title>"+titleHTML+"</title><link rel='stylesheet' href='/travel-jee-laurent/css/bootstrap.min.css'></head>";
	String bodyHeadHTML="<body><div class='container'>";
	String bodyFootHTML="</div></body>";
	String bodyMenuHTML="<nav ><ul class='nav nav-tabs nav-justified'><li><a href='./index.html'>Accueil</a><li><a href='./quito.html'>Quito</a><li><a href='./cartagena.html'>Cartagena</a><li class='active'><a href='./maracaibo.html'>Maracaibo</a><li><a href='./lima.html'>Lima</a><li><a href='./santiago.html'>Santiago</a><li><a href='/travel-jee-laurent/lapaz.jsp'>Lapaz</a><li><a href='/travel-jee-laurent/buenosaires.jsp'>Buenos Aires</a></ul></nav>";
	
	public MaracaiboServlet() {
		// TODO Auto-generated constructor stub
	}

	public String bodyHTML(String txt){
		return bodyHeadHTML+bodyMenuHTML+txt+bodyFootHTML;
	}
	
	public String colHTML(String txt, int taille){
		return "<section class='col-xs-"+taille+"'>"+txt+"</section>";
	}
	
	public String rowHTML(String txt){
		return "<div class='row'>"+txt+"</div>";
	}
	
	public String formHTML(String title,TreeMap<String, String[]> form){
		String txt="";
		txt+="<h2>"+title+"</h2>";
		txt+="<form class='form-inline' action='?' method='post'>";
		txt+="<section class='form-group'>";
		for(String k : form.keySet()){
			txt+="<p>";
			txt+="<label for='"+k+"'>"+k+" : </label> <input type='"+form.get(k)[0]+"' name='"+k+"' class='form-control input-xs' value='"+form.get(k)[1]+"'>";
			txt+="</p>";
		}
		txt+="<input type='submit' name='Envoi' value='Envoi' class='btn btn-primary'>";
		txt+="</section>";
		txt+="</form>";
		return txt;
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //Permet d'indiquer que ce qu'on enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); //Permet de prendre la main sur un flux de sortie déjà prévu, pour pouvoir y glisser des choses dedans
		out.write(headHTML);
		String txt="";
		
		txt+=this.rowHTML(this.colHTML("<h1>Maracaibo</h1>", 6));
		
		//Création de mon dictionnaire pour le formulaire (avec un tableau de string pour la valeur associée à un clé pour pouvoir utiliser plusieur valeur
		TreeMap<String,String []> form = new TreeMap<>();
		form.put("Nom",new String[]{"text",req.getParameter("Nom")==null?"":req.getParameter("Nom")});
		form.put("Tel",new String[]{"text",req.getParameter("Tel")==null?"":req.getParameter("Tel")});
		form.put("Voyageurs",new String[]{"number",req.getParameter("Voyageurs")==null?"":req.getParameter("Voyageurs")});
		
		txt+=this.formHTML("Inscription", form);
		
		
		if(req.getParameter("Tel")!=null){ //Test d'envoi du formulaire
			if(!req.getParameter("Nom").trim().equals("")){ //test de remplissage du champ "nom"
				txt+=this.rowHTML(this.colHTML("<h3> Inscription reçue : "+req.getParameter("Nom")+"</h3>", 12));
			}else
				txt+=this.rowHTML(this.colHTML("<h3>Même pas capable de remplir un formulaire, bouffon !!!</h3>",12));
		}
		
		out.write(this.bodyHTML(txt));
	}
}
