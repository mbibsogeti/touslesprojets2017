package travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuitoServlet extends HttpServlet {

	String titleHTML="Welcome to 'Quito'";
	String headHTML="<!DOCTYPE html><html><head><meta charset='UTF-8'><title>"+titleHTML+"</title><link rel='stylesheet' href='./css/bootstrap.min.css'></head>";
	String bodyHeadHTML="<body><div class='container'>";
	String bodyFootHTML="</div></body>";
	String bodyMenuHTML="<nav ><ul class='nav nav-tabs nav-justified'><li><a href='./index.html'>Accueil</a><li class='active'><a href='./quito.html'>Quito</a><li><a href='./cartagena.html'>Cartagena</a><li><a href='./maracaibo.html'>Maracaibo</a><li><a href='./lima.html'>Lima</a></ul></nav>";
	
	public QuitoServlet() {
		// TODO Auto-generated constructor stub
	}
	
	public String colHTML(String txt, int taille){
		return "<section class='col-xs-"+taille+">"+txt+"</section";
	}
	
	public String rowHTML(String txt){
		return "<div class='row'>"+txt+"</div>";
	}
	
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //Permet d'indiquer que ce qu'on enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); //Permet de prendre la main sur un flux de sortie déjà prévu, pour pouvoir y glisser des choses dedans
		String txtHTML = this.headHTML+"<body><div class='container'>"+this.bodyMenuHTML+"<div class='row'><h1 class='col-xs-12'>Quito</h1></div><div class='row'><section class='col-sm-6 table-responsive'><table class='table table-striped table-bordered table-condensed'><tbody><tr><th>Jours</th><th>TTC</th></tr>";
		int prixAvion=1060;
		double prixUnit=32.80;
		
		for(int i=5;i<=25;i+=5){
			txtHTML+="<tr><td>"+i+"</td><td>"+String.format("%.2f",(prixAvion+(prixUnit*i)))+"€</td></tr>";
		}
		txtHTML+="</tbody></table></section></div>"+this.bodyFootHTML;
		out.write(txtHTML);
	}
	
	
}
