package travel;

import java.io.IOException;
import java.io.Writer;

import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CartagenaServlet extends HttpServlet{

	String titleHTML="Welcome to 'Cartagena'";
	String headHTML="<!DOCTYPE html><html><head><meta charset='UTF-8'><title>"+titleHTML+"</title><link rel='stylesheet' href='/travel-jee-laurent/css/bootstrap.min.css'></head>";
	String bodyHeadHTML="<body><div class='container'>";
	String bodyFootHTML="</div></body>";
	String bodyMenuHTML="<nav ><ul class='nav nav-tabs nav-justified'><li><a href='./index.html'>Accueil</a><li><a href='./quito.html'>Quito</a><li class='active'><a href='./cartagena.html'>Cartagena</a><li><a href='./maracaibo.html'>Maracaibo</a><li><a href='./lima.html'>Lima</a><li><a href='./santiago.html'>Santiago</a><li><a href='/travel-jee-laurent/lapaz.jsp'>Lapaz</a><li><a href='/travel-jee-laurent/buenosaires.jsp'>Buenos Aires</a></ul></nav>";
	
	public CartagenaServlet() {
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
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //Permet d'indiquer que ce qu'on enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); //Permet de prendre la main sur un flux de sortie déjà prévu, pour pouvoir y glisser des choses dedans
		out.write(headHTML);
		String txt="";
		TreeMap<String,String> descs= new TreeMap<>();
		descs.put("Barranquilla", "Barranquilla est une ville du nord de la Colombie et la capitale du département d'Atlántico. Elle se situe sur la rive occidentale du río Magdalena, le fleuve le plus important de Colombie, à 7,5 km de son embouchure sur la mer des Caraïbes, ou mer des Antilles, dépendance de l'océan Atlantique.");
		descs.put("Bogota","Bogota, anciennement Santa Fe de Bogotá Distrito Capital, est la capitale de la Colombie et également celle du département de Cundinamarca.");
		descs.put("Cali","Cali, officiellement Santiago de Cali, est une ville située dans l'ouest de la Colombie. C'est la capitale du département de Valle del Cauca.");
		descs.put("San Andrès","San Andrés est une île de l'archipel de San Andrés y Providencia, en Colombie.");
		
		txt+=this.rowHTML(this.colHTML("<h1>Cartagena</h1>", 12));
		String tempTxt="";
		
		for(String k : descs.keySet()){
			tempTxt+="<p><a href='cartagena.html?city="+k+"'>"+k+"</a></p>";
		}
		txt+=this.rowHTML(this.colHTML(tempTxt, 2));
		
		if((req.getParameter("city")!=null)&&(!descs.containsKey(req.getParameter("city")))){
			throw new ServletException("Destination inconnue !!");
		}
		
		if((req.getParameter("city")!=null)&&(descs.containsKey(req.getParameter("city")))){
			txt+=this.rowHTML(this.colHTML("<h3>"+descs.get(req.getParameter("city"))+"</h3>", 6));
		}
		out.write(this.bodyHTML(txt));
		
		
	}

	

}
