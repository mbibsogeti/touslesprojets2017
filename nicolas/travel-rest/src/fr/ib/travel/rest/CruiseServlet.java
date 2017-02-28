package fr.ib.travel.rest;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/cruise", "/cruise/*" }) // permet d'acceder a la servlet par
										// plusieur adresse..
public class CruiseServlet extends HttpServlet {
	private ArrayList<String> cruises;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/* super.doGet(req, resp); tjr enlever lors d'une redéfinition */

		res.setContentType("text/csv"); // respecte la norme mime et indique que
										// le corp contien du csv
		res.setCharacterEncoding("utf-8");
		String name = "";
		Writer out = res.getWriter(); // ecrit dans le anvigateur
		out.write("");
		String url = req.getRequestURL().toString();//récupère 'url
		log(url);
		if(url.endsWith("/cruises")){
			for (String c : cruises)
				out.write(c + "\n");}// le corp contien ça
	
		else{ String m=url.substring(url.lastIndexOf("/")+1);//trouve la première chose après le dernier slach
	
			out.write(cruises.get(Integer.parseInt(m)));//affiche en sorti une seul ligne de la liste comportan le numéro correct
		}
			
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("toto,8");
		cruises.add("tutu,4");
		cruises.add("Maee,1");
		cruises.add("jesais pas,59");
		cruises.add("Manas,9");
		super.init();
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doDelete(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int m=0;
		cruises.remove(m);
		//super.doDelete(req, resp); ne pas laissé car methode super font remonté une exception si pas utilisé ..
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		cruises.add(req.getReader().readLine());  
		// autre methode bufferedreader in = req.getReader();cruises.add(in.readLine()
		// TODO Auto-generated method stub
		//super.doPost(req, resp);  ne pas laissé car methode super font remonté une exception si pas utilisé ..
	}
	
	
	
}
