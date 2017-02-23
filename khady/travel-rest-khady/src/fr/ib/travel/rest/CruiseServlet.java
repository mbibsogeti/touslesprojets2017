package fr.ib.travel.rest;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/cruise", "/cruise/*" }) // remplace la déclaration que l'on
										// faisait dans notre fichier web.xml

public class CruiseServlet extends HttpServlet {
	private ArrayList<String> cruises;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/csv");
		res.setCharacterEncoding("utf-8");

		Writer out = res.getWriter();
		String url = req.getRequestURL().toString();
		log(url);

		if (url.endsWith("/cruise")) {
			for (String a : cruises)
				out.write(a + "\n");
		} else {
			String n = url.substring(url.lastIndexOf("/") + 1);
			out.write(cruises.get(Integer.parseInt(n)));
		}

	}

	@Override
	public void init() throws ServletException {
		super.init();
		cruises = new ArrayList<>();
		cruises.add("Manaus,9");
		cruises.add("Rio,5");
		cruises.add("Belem,7");
		cruises.add("Porto Velho,8");
		cruises.add("Santaren,12");
	}

}
