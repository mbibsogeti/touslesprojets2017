package travel;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LimaServlet extends HttpServlet{

	String titleHTML="Welcome to 'Lima'";
	String headHTML="<!DOCTYPE html><html><head><meta charset='UTF-8'><title>"+titleHTML+"</title><link rel='stylesheet' href='./css/bootstrap.min.css'></head>";
	String bodyHeadHTML="<body><div class='container'>";
	String bodyFootHTML="</div></body>";
	String bodyMenuHTML="<nav ><ul class='nav nav-tabs nav-justified'><li><a href='./index.html'>Accueil</a><li><a href='./quito.html'>Quito</a><li><a href='./cartagena.html'>Cartagena</a><li><a href='./maracaibo.html'>Maracaibo</a><li class='active'><a href='./lima.html'>Lima</a></ul></nav>";
	
	public LimaServlet() {
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
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html"); //Permet d'indiquer que ce qu'on enverra sera du type choisis
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter(); //Permet de prendre la main sur un flux de sortie déjà prévu, pour pouvoir y glisser des choses dedans
		out.write(headHTML);
		String txt="";
		
		txt+=this.rowHTML(this.colHTML("<h1>Lima</h1>", 6));
		
		txt+=this.rowHTML(this.colHTML("<h3>"+getInitParameter("text")+"</h3>", 12));
		
		out.write(this.bodyHTML(txt));
		
		log("doGet"+this);
	}

	@Override
	public void destroy() {
		
		log("destroy");
		
		super.destroy();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		log("init");
	}
	
}
