package fr.ib.travel.rest;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/cruise", "/cruise/*" })

public class CruiseServlet extends HttpServlet {
	// créer une liste cruises
	private ArrayList<String> cruises;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// choix d'un certain type de fichier à renvoyer
		res.setContentType("text/csv");
		res.setCharacterEncoding("utf-8");
		Writer out = res.getWriter();
		out.write("");
		// traitement d'URL
		String url = req.getRequestURL().toString();
		log(url);
		if(url.endsWith("/cruise")){
			// enregistrer les données de liste dans le fichier cruise.csv
			for (String c : cruises)
				out.write(c + "\n");
		}
		else {
			String n=url.substring(url.lastIndexOf("/")+1);
			out.write(cruises.get(Integer.parseInt(n)));
		}
		
	}

	@Override
	public void init() throws ServletException {
		// remplisage de la liste
		super.init();
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Belem,7");
		cruises.add("Porto Velho,15");
		cruises.add("Santaren,10");
	}

}
