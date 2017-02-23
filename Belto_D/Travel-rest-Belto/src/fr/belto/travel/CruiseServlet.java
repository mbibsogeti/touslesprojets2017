package fr.belto.travel;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet({"/cruise", "/cruise/*"})
public class CruiseServlet extends HttpServlet {

	private static final int Integerparse = 0;
	@Override
	public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		res.setContentType("text/csv");
		res.setCharacterEncoding("utf-8");	
		Writer out = res.getWriter();
		String url=req.getRequestURL().toString();
		if (url.equals("http://localhost:8080/travel-rest-Belto/cruise"))// comparer l'url
			for (String c:cruises)// affichage de l'url si la comparaison le permet
				out.write(c+"\n");
		else 
		{int b = url.length();// on cherche la taille de l'url
			int a= Integer.parseInt(url.substring (b-1));// on le transforme en nombre et on le stock dans une variable
		    out.write(cruises.get(a));// on affiche ce qu'on nous demande
		    
		}
		
	}
	private ArrayList<String>cruises;//  liste pour les destinations avec les jours//
	public void init(){// ajouter les destination avec le nombre de jours de séjour
	cruises=new ArrayList<String>();
	cruises.add("Manaus,9");
	cruises.add("Belen,10");
	cruises.add("Porto Vetto,5");
	cruises.add("Sataran ,7");	
	}
}
