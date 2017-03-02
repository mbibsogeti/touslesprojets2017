package fr.ib.hugo.travel;

import java.io.BufferedReader;
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

	private ArrayList<String> cruises;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/csv");
		Writer out = res.getWriter();
		String url = req.getRequestURL().toString();

		if (url.endsWith("/cruise")) {
			for (String c : cruises) {
				out.write(c + "\n");
			}
		} else {
			String n = url.substring(url.lastIndexOf("/") + 1);
			out.write(cruises.get(Integer.parseInt(n) - 1));
		}

		// for (int i = 1; i <= 5; i++) {
		// if (url.equals("http://localhost:8080/hugo-travel-rest/cruise/" + i))
		// {
		// String c = cruises.get(i - 1);
		// out.write(c);
		// log(""+c);
		// break;
		// } else {
		// for (String c : cruises) {
		// out.write(c + "\n");
		// log(""+c);
		// break;
		// }
		//
		// }
		//
		// }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		BufferedReader in=req.getReader();
		cruises.add(in.readLine());
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int n=0;
		cruises.remove(n);
	}

	@Override
	public void init() throws ServletException {
		cruises = new ArrayList<String>();
		cruises.add("Manaus,9");
		cruises.add("Belem,2");
		cruises.add("Porto Velho,5");
		cruises.add("Santaren,7");
	}

	private static final long serialVersionUID = 1L;

}
