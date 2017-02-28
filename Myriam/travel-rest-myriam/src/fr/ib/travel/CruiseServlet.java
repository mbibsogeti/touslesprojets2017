package fr.ib.travel;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/cruise", "/cruise/*" })

public class CruiseServlet extends HttpServlet {

	private ArrayList<String> cruises;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/csv"); // sort un fichier csv
		
		Writer out = res.getWriter();
		
		// On récupère le dernier caractere de l'URL
		String url = req.getRequestURL().toString();
		System.out.println(url);
		int length = url.length();
		String num = url.substring(length - 1, length);
		System.out.println(num);

		// On compare les clés de cruises avec le dernier caratere de l'URL
		for (String c : cruises) {
			
			int t = c.length();
			String index = c.substring(t - 1, t);
			
			if (num.equals("e"))
				out.write(c + "\n");
			
			else if (num.equals(index))
				out.write(c + "\n");
		}
	}
	

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		cruises.add(req.getReader().readLine());
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int n=0;
		cruises.remove(n);
	}



	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Belem,8");
		cruises.add("Porto Velto,7");
		cruises.add("Santaren,6");

	}

}
